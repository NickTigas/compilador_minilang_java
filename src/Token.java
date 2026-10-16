public class Token {
    public TipoToken nome; //instancia do TipoToken
    public String lexema; //valor
    public int pos; // offset do primeiro caractere
    // pos guarda a posicao da linha do codigo

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