public class lexic {
    public static void main(String[] args){

        lexico lex = new lexico(args[0]);
        Token t = null;

        while((t= lex.proximoToken()).nome !=TipoToken.END){
            System.out.println(t);
        }

    }
}
