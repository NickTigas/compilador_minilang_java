public class lexic {
    public static void main(String[] args){

        lexico lex = new lexico(args[0]);
        Token t = null;

        while((t= lex.proximoToken()) !=null){
            System.out.println(t);
        }

    }
}
