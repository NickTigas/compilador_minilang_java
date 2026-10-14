public class Cabeca {
    public static void main(String args[]){
        lexico Lex = new lexico(args[0]);
        parser pars = new parser(Lex);
        pars.program();
    }
}
