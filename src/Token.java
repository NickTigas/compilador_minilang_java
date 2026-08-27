public class Token {
    public TipoToken nome;
    public String lexema;

    public Token(TipoToken tipoToken, String s) {
        this.nome = tipoToken;
        this.lexema = s;
    }

    @Override
    public String toString(){
       return "<"+nome+","+lexema+">";
    }

}
