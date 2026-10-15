import java.util.*;

public class No {
    public final String tipo;      // ex: "PROGRAM", "IF", "BINOP"
    public final String lexema;    // pode ser null
    public final List<No> filhos = new ArrayList<>();

    public No(String tipo) { this(tipo, null); }
    public No(String tipo, String lexema) { this.tipo = tipo; this.lexema = lexema; }

    public No add(No filho) { if (filho != null) filhos.add(filho); return this; }

    public void imprimir() { imprimir("", true); }

    private void imprimir(String prefixo, boolean ultimo) {
        System.out.println(prefixo + (ultimo ? "└── " : "├── ")
                + tipo + (lexema != null ? " (" + lexema + ")" : ""));
        for (int i = 0; i < filhos.size(); i++)
            filhos.get(i).imprimir(prefixo + (ultimo ? "    " : "│   "), i == filhos.size() - 1);
    }
}