public class lexic {
    public static void main(String[] args){

        lexico lex = new lexico(args[0]); //usa o primeiro argumento do main
        Token t = null;

        while((t= lex.proximoToken()).nome !=TipoToken.END){ //loop para a leitura de token
            System.out.println(t);
        }

    }
}
