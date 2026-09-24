package antlr4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.IOException;

public class principal {
    public static void main(String args[]) throws IOException {

        CharStream cs = CharStreams.fromFileName(args[0]);


        lexeri lex = new lexeri(cs);

        Token t;

        while ((t = lex.nextToken()).getType() != Token.EOF) {
            System.out.print("<" + t.getType() + "," + t.getText() + ">");
        }
    }
}