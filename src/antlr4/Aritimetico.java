package antlr4;

import org.antlr.v4.runtime.*;

public class Aritimetico {
    public static int calcular(String caminho) throws java.io.IOException {
        CharStream cs = CharStreams.fromFileName(caminho);
        exprLexer exlexer = new exprLexer(cs);
        exlexer.removeErrorListeners();
        exlexer.addErrorListener(ouvinte(caminho));

        exprParser parser = new exprParser(new CommonTokenStream(exlexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ouvinte(caminho));

        return parser.program().val;
    }

    private static BaseErrorListener ouvinte(String arquivo) {
        return new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object simbolo,
                                    int linha, int coluna, String msg, RecognitionException e) {
                throw new RuntimeException(arquivo + ":" + linha + ":" + (coluna + 1) + ": " + msg);
            }
        };
    }
}