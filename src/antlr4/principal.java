package antlr4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;


public class principal {
    public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        lexer lex = new lexer(cs);
        while((t=lex.nextToken()).getType() != Token.EOF){
            System.out.print(("<"+t.getType()+","+t.getText()+">"));
        }
    }
}
