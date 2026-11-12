import java.util.*;

public class Interpretador {
    private final Map<String, Integer> vars = new HashMap<>();
    private final Scanner entrada = new Scanner(System.in);

    public void executar(No programa) {
        exec(programa.filhos.get(0));          // PROGRAM -> BLOCO
    }

    private void exec(No n) {
        switch (n.tipo) {
            case "BLOCO":
                for (No c : n.filhos) exec(c);
                break;
            case "ATRIB":
                vars.put(n.lexema, avaliar(n.filhos.get(0)));
                break;
            case "READ":
                String nome = n.filhos.get(0).lexema;
                System.out.print(nome + " = ");
                if (!entrada.hasNext()) throw new RuntimeException("Erro de execução: entrada vazia em read(" + nome + ")");
                String txt = entrada.next();
                try { vars.put(nome, Integer.parseInt(txt)); }
                catch (NumberFormatException e) { throw new RuntimeException("Erro de execução: '" + txt + "' não é número"); }
                break;
            case "WRITE":
                No arg = n.filhos.get(0);
                if (arg.tipo.equals("CADEIA")) System.out.println(texto(arg.lexema));
                else System.out.println(formatar(avaliar(arg)));
                break;
            case "IF":
                if (condicao(n.filhos.get(0))) exec(n.filhos.get(1));
                else if (n.filhos.size() > 2) exec(n.filhos.get(2));
                break;
            case "WHILE":
                while (condicao(n.filhos.get(0))) exec(n.filhos.get(1));
                break;
            default:
                throw new RuntimeException("Nó desconhecido: " + n.tipo);
        }
    }

    private boolean condicao(No n) {                       // nó REL
        int a = avaliar(n.filhos.get(0));
        int b = avaliar(n.filhos.get(1));
        switch (n.lexema) {
            case "=": case "==": return a == b;
            case "<":  return a < b;
            case ">":  return a > b;
            case "<=": return a <= b;
            case ">=": return a >= b;
            default: throw new RuntimeException("Operador relacional desconhecido: " + n.lexema);
        }
    }

    private int avaliar(No n) {

        if (n.tipo.equals("EXPR")) {
            return antlr4.Aritimetico.calcularExpressao(
                    n.lexema,
                    vars
            );
        }

        throw new RuntimeException(
                "Expressão inválida: " + n.tipo
        );
    }

    private String formatar(int valor) {
        return Integer.toString(valor);
    }

    private String texto(String lex) {                     // tira aspas e escapes
        String s = lex.substring(1, lex.length() - 1);
        return s.replace("\\'", "'").replace("\\\\", "\\");
    }
}