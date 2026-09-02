public class Token {
    public TipoToken nome; //instancia do TipoToken
    public String lexema; //valor

    public Token(TipoToken tipoToken, String s) { //metodo construtor
        this.nome = tipoToken;
        this.lexema = s;
    }

    @Override
    public String toString(){
       return "<"+nome+","+lexema+">";
    }
        //metodo toString pra mostrar na tela as instancias + os valores
}
