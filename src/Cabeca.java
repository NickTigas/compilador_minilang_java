import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Cabeca {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Uso: java Cabeca <arquivo.minilang>");
            System.exit(2);
        }
        String caminho = args[0];
        if (!caminho.endsWith(".minilang")) {
            System.err.println("Erro: o arquivo precisa ter a extensão .minilang");
            System.exit(2);
        }
        Path p = Path.of(caminho);
        if (!Files.isReadable(p)) {
            System.err.println("Erro: não foi possível abrir '" + caminho + "'");
            System.exit(2);
        }

        // ISO_8859_1 = 1 byte por char, igual ao leitor (que lê bytes)
        String fonte = Files.readString(p, StandardCharsets.ISO_8859_1);

        try {
            parser pars = new parser(new lexico(caminho));
            No raiz = pars.program();
            raiz.imprimir();
        } catch (ErroCompilacao e) {
            mostrarErro(caminho, fonte, e);
            System.exit(1);
        }
    }

    static void mostrarErro(String arquivo, String fonte, ErroCompilacao e) {
        int pos = Math.max(0, Math.min(e.pos, fonte.length()));

        int linha = 1;
        for (int i = 0; i < pos; i++) if (fonte.charAt(i) == '\n') linha++;

        int ini = fonte.lastIndexOf('\n', pos - 1) + 1;   // início da linha
        int fim = fonte.indexOf('\n', pos);
        if (fim < 0) fim = fonte.length();
        String texto = fonte.substring(ini, fim).replace("\r", "");
        int coluna = pos - ini + 1;

        // preserva tabs para o ^ alinhar
        StringBuilder pad = new StringBuilder();
        for (int i = 0; i < coluna - 1 && i < texto.length(); i++)
            pad.append(texto.charAt(i) == '\t' ? '\t' : ' ');
        while (pad.length() < coluna - 1) pad.append(' ');

        String num = String.format("%4d | ", linha);
        System.err.println(arquivo + ":" + linha + ":" + coluna + ": " + e.getMessage());
        System.err.println(num + texto);
        System.err.println(" ".repeat(num.length() - 2) + "| " + pad + "^");
    }

}