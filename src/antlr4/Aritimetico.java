
package antlr4;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import java.util.Map;
import java.util.Collections;

public class Aritimetico {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Informe o arquivo de entrada.");
            return;
        }

        int resultado = calcular(args[0]);

        System.out.println("Resultado: " + resultado);
    }

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
                                    int linha, int coluna, String msg,
                                    RecognitionException e) {

                throw new RuntimeException(
                        arquivo + ":" + linha + ":" + (coluna + 1) + ": " + msg
                );
            }
        };
    }

    public static int calcularExpressao(
            String expressao,
            Map<String, Integer> vars) {

        CharStream cs = CharStreams.fromString(expressao);

        exprLexer lexer = new exprLexer(cs);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ouvinte("expressão"));

        exprParser parser = new exprParser(
                new CommonTokenStream(lexer)
        );

        parser.vars = vars;

        parser.removeErrorListeners();
        parser.addErrorListener(ouvinte("expressão"));

        return parser.program().val;
    }
}
