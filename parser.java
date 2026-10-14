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

    //programa nome: 'program' 'id' ':'
    public void program(){
        match(TipoToken.PROGRAM); //program
        match(TipoToken.ID);
        declaracao();//nome do programa
        match(TipoToken.COLON); //:

    }

    //declaraçao variavel
    void declaracao(){
        match(TipoToken.ID);
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
        if(lookahead(1).nome == TipoToken.PLUS || lookahead(1).nome == TipoToken.MINUS){
            aritimetico2DLC1();
            aritimetico2();
        }else{
            //vazio
        }
    }

    void aritimetico2DLC1(){//+, -
        if(lookahead(1).nome == TipoToken.PLUS){
            match(TipoToken.PLUS);
            termoaritimetico();
        }else if(lookahead(1).nome == TipoToken.MINUS){
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
        if(lookahead(1).nome == TipoToken.TIMES || lookahead(1).nome == TipoToken.DIVIDE){
            termoaritimetico2DLC1();
            termoaritimetico2();
        }else{
            //vazio
        }
    }

    void termoaritimetico2DLC1(){//+, -
        if(lookahead(1).nome == TipoToken.TIMES){
            match(TipoToken.TIMES);
            fatoraritimetico();
        }else if(lookahead(1).nome == TipoToken.DIVIDE){
            match(TipoToken.DIVIDE);
            fatoraritimetico();
        }else{
            erroSintatico("*","/");
        }
    }

    void fatoraritimetico() {
        if(lookahead(1).nome == TipoToken.INT) {
            match(TipoToken.INT);
        }else if (lookahead(1).nome == TipoToken.ID) {
            match(TipoToken.ID);
        }else if(lookahead(1).nome == TipoToken.LPAREN){
            match(TipoToken.LPAREN);
            aritimetico();
            match(TipoToken.RPAREN);
        }else{
            erroSintatico("INT","ID","(");
        }
    }

    void relacional(){
        if(lookahead(1).nome == TipoToken.INT || lookahead(1).nome == TipoToken.ID ||
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
        else erroSintatico("=","==","<",">",",=",">=");
    }

    void listaComand(){
        comando();
        listaComandDLC1();
    }

    void listaComandDLC1(){
        if(lookahead(1).nome == TipoToken.BEGIN || lookahead(1).nome == TipoToken.END ||
                lookahead(1).nome == TipoToken.IF || lookahead(1).nome == TipoToken.THEN ||
                lookahead(1).nome == TipoToken.DO || lookahead(1).nome == TipoToken.WHILE ||
                lookahead(1).nome == TipoToken.WRITE || lookahead(1).nome == TipoToken.READ ||
                lookahead(1).nome == TipoToken.ELSE){
           listaComand();
        }
        else{
            //vazio
        }
    }

    void comando(){
        if(lookahead(1).nome == TipoToken.BEGIN) subAlgoritimo();
        else if (lookahead(1).nome == TipoToken.READ)  read();
        else if(lookahead(1).nome == TipoToken.WRITE) write();
        else if (lookahead(1).nome == TipoToken.IF) condicao();
        else if(lookahead(1).nome == TipoToken.WHILE) loop();
        else if(lookahead(1).nome == TipoToken.DO) loop();
        else if (lookahead(1).nome == TipoToken.THEN) condicao();
        else erroSintatico("begin, read, write, if, while, do, then");
    }

    void subAlgoritimo(){
        match(TipoToken.BEGIN);
        listaComand();
        match(TipoToken.END);
    }

    void loop() {
        match(TipoToken.WHILE);
        relacional();
        comando();
        loopDLC1();
    }
    void loopDLC1(){
        match(TipoToken.DO);
        relacional();
        match(TipoToken.WHILE);
        comando();
    }

    void condicao(){
        match(TipoToken.IF);
        relacional();
        match(TipoToken.THEN);
        comando();
        condicaoDLC1();
    }
    void condicaoDLC1(){
        if(lookahead(1).nome == TipoToken.ELSE){
            match(TipoToken.ELSE);
            comando();
        }else{
            //vazio
        }
    }
    void read(){
        match(TipoToken.READ);
        match(TipoToken.ID);
    }
    void write(){
        match(TipoToken.WRITE);
        writeDLC();
    }

    void writeDLC(){
        if(lookahead(1).nome == TipoToken.ID) match(TipoToken.ID);
        else if(lookahead(1).nome == TipoToken.CADEIA) match(TipoToken.CADEIA);
        else erroSintatico(TipoToken.ID.toString(), TipoToken.CADEIA.toString());
    }

}