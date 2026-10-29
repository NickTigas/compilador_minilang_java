import org.antlr.v4.runtime.*;

public class Aritimetico {
    public static int calcular(String caminho) throws java.io.IOException {
        CharStream cs = CharStreams.fromFileName(caminho);
        exprLexer lexer = new exprLexer(cs);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ouvinte(caminho));

        exprParser parser = new exprParser(new CommonTokenStream(exprlexer));
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