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

    //programa : 'program' ':' 'nome'
    public void program(){
        match(TipoToken.PROGRAM); //program
        match(TipoToken.COLON); //:
        //match(TipoToken. ); //nome do programa

    }

}