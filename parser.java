import java.util.ArrayList;
import java.util.List;

public class parser {

    private static final int tamanhoBuffer = 10;

    private lexico lexico;
    private List<Token> bufferTokens;
    private boolean fim = false;

    public parser(lexico lexico) {
        this.lexico = lexico;
        bufferTokens = new ArrayList<>();
        lerToken();
    }

    private void lerToken() {

        // Se já existe algum token no buffer,
        // remove o primeiro
        if (bufferTokens.size() > 0) bufferTokens.remove(0);

        // Preenche o buffer até ter 10 tokens
        while (bufferTokens.size() < tamanhoBuffer && !fim) {

            Token proximo = lexico.proximoToken();
            bufferTokens.add(proximo);
            if (proximo.nome == TipoToken.END) fim = true;
        }
        System.out.print("Foi lido"+lookahead(1));
    }
    Token lookahead(int k){
        if(bufferTokens.isEmpty()) return null;
        if(k-1 >= bufferTokens.size()) return bufferTokens.get(bufferTokens.size()-1); //retorma o ultimo
        // nao resolve mt coisa mas, evita de dar problema
        return  bufferTokens.get(k-1);//pega o token que ta a frente
    }
    void match(TipoToken tipo){
        if(lookahead(1).nome == tipo){
            System.out.print("Foi"+lookahead(1));
            lerToken(); //avança a leitura
        }else{
            erroSintatico(tipo.toString());
        }
    }
    void erroSintatico(String... tokensEsperados){
        String mensagem = "Erro Sintático: esperando -> (";
        for(int i=0;i<tokensEsperados.length;i++){
            mensagem += tokensEsperados[i];
            if(i<tokensEsperados.length-1) mensagem += ","; //ve o final da linha e adiciona ,
        }
        mensagem += ") foi encontrado"+lookahead(1);
        throw new RuntimeException(mensagem);
    }

    //programa : 'program' 'id' ':'
    public void program(){
        match(TipoToken.PROGRAM); //program
        match(TipoToken.ID); //nome do programa
        match(TipoToken.COLON); //:
    }

    //declaraçao variavel
    void declaracao(){
        match(TipoToken.VAR);
        match(TipoToken.INT);
        match(TipoToken.ID);
    }

    //aritimetico
    //serve para remover a recursao a esquerda
    void aritimetico(){
        termoaritimetico();
        aritimetico2();
    }
     void aritimetico2(){
        if(lookahead((1).nome == TipoToken.PLUS || lookahead((1).nome == TipoToken.MINUS)){
            aritimetico2DLC1();
            aritimetico2();
        }else{
            //vazio
        }
    }

    void aritimetico2DLC1(){//+, -
        if(lookahead((1).nome == TipoToken.PLUS){
            match(TipoToken.PLUS);
            termoaritimetico();
        }else if(lookahead((1).nome == TipoToken.MINUS){
            match(TipoToken.MINUS);
            termoaritimetico();
        } else{
            erroSintatico("+","-");
        }
    }

    void termoaritimetico(){
        fatoraritimetico();
        termoaritimetico2();
    }
    void termoaritimetico2(){
        if(lookahead((1).nome == TipoToken.TIMES || lookahead((1).nome == TipoToken.DIVIDE)){
            termoaritimetico2DLC1();
            termoaritimetico2();
        }else{
            //vazio
        }
    }

    void termoaritimetico2DLC1(){//+, -
        if(lookahead((1).nome == TipoToken.TIMES){
            match(TipoToken.TIMES);
            fatoraritimetico();
        }else if(lookahead((1).nome == TipoToken.DIVIDE){
            match(TipoToken.DIVIDE);
            fatoraritimetico();
        } else{
            erroSintatico("*","/");
        }
    }

    void fatoraritimetico() {
        if(lookahead(1).nome == TipoToken.INT) {
            match(TipoToken.INT);
        }else if (lookahead(1).nome == TipoToken.VAR) {
            match(TipoToken.VAR);
        }else{
            erroSintatico("tipo errado");
        }
    }

    void relacional(){
        if(lookahead(1).nome == TipoToken.INT || lookahead(1).nome == TipoToken.VAR ||
        lookahead(1).nome == TipoToken.LPAREN){
            aritimetico();
            oprelacional();
            aritimetico();
        }
        else if(lookahead(1).nome == TipoToken.LPAREN){
            match(TipoToken.LPAREN);
            relacional();
            match(TipoToken.RPAREN);
        } else{
            erroSintatico("Tipo errado eu acho");
        }
    }

    void oprelacional(){
        if(lookahead(1).nome == TipoToken.ASSIGN) match(TipoToken.ASSIGN);//=
        else if(lookahead(1).nome == TipoToken.EQ) match(TipoToken.EQ);//==
        else if(lookahead(1).nome == TipoToken.LT) match(TipoToken.LT);//<
        else if(lookahead(1).nome == TipoToken.GT) match(TipoToken.GT);//>
        else if(lookahead(1).nome == TipoToken.LE) match(TipoToken.LE);//<=
        else if(lookahead(1).nome == TipoToken.GE) match(TipoToken.GE);//>=

    }

}