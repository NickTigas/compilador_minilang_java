public class Cabeca {
    public static void main(String[] args) {
        // Verifica se o argumento do arquivo foi fornecido
        if (args.length == 0) {
            System.out.println("Erro: Nenhum arquivo de entrada foi fornecido.");
            System.out.println("Uso correto: java Cabeca <caminho_do_arquivo.minilang>");
            return; // Encerra o programa de forma limpa
        }

        lexico Lex = new lexico(args[0]);
        parser pars = new parser(Lex);
        No raiz = pars.program();
        raiz.imprimir(); //representacao Arvore AST
    }
}
