import java.util.ArrayList;
import java.util.List;

public class parser {

    private static final int tamanhoBuffer = 1;

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
            if (proximo.nome == TipoToken.EOF) fim = true;
        }
        System.out.print("Foi lido"+lookahead(1));
    }
    Token lookahead(int k){
        if(bufferTokens.isEmpty()) return null;
        if(k-1 >= bufferTokens.size()) return bufferTokens.get(bufferTokens.size()-1); //retorma o ultimo
        // nao resolve mt coisa mas, evita de dar problema
        return  bufferTokens.get(k-1);//pega o token que ta a frente
    }
    private Token anterior = null;

    Token match(TipoToken tipo) {
        Token atual = lookahead(1);
        if (atual.nome == tipo) {
            anterior = atual;
            lerToken();
            return atual;
        }
        erroFaltando(tipo.toString());
        return null;
    }

    void erroFaltando(String esperado) {
        Token t = lookahead(1);
        int pos = (anterior != null) ? anterior.pos + anterior.lexema.length() : t.pos;
        throw new ErroCompilacao("Erro sintático: faltando " + esperado
                + " (encontrado " + (t.nome == TipoToken.EOF ? "fim do arquivo" : "'" + t.lexema + "'") + ")", pos);
    }


    void erroSintatico(String... esperados){
        Token t = lookahead(1);
        String achado = (t.nome == TipoToken.EOF) ? "fim do arquivo" : "'" + t.lexema + "'";
        throw new ErroCompilacao("Erro sintático: esperado " + String.join(" ou ", esperados) + ", encontrado " + achado, t.pos);
    }

    //programa nome: 'program' 'id' ':'
    public No program() {
        match(TipoToken.PROGRAM);
        Token nome = match(TipoToken.ID);
        match(TipoToken.COLON);
        No corpo = bloco();
        match(TipoToken.DOT);
        match(TipoToken.EOF);//$ representa o fim de arquivo
        return new No("PROGRAM", nome.lexema).add(corpo);
    }

    //delimitacao apartir do " ; " para separar o codigo em blocos
    No bloco() {
        match(TipoToken.BEGIN);
        No b = new No("BLOCO").add(comando());
        while (lookahead(1).nome == TipoToken.SEMICOLON) {
            match(TipoToken.SEMICOLON);
            b.add(comando());
        }
        match(TipoToken.END);
        return b;
    }

    //aritimetico
    //serve para remover a recursao a esquerda
    No aritimetico() {
        No esq = termoaritimetico();
        while (lookahead(1).nome == TipoToken.PLUS || lookahead(1).nome == TipoToken.MINUS) {
            Token op = match(lookahead(1).nome);
            No dir = termoaritimetico();
            esq = new No("BINOP", op.lexema).add(esq).add(dir);
        }
        return esq;
    }

    No termoaritimetico() {
        No esq = fatoraritimetico();
        while (lookahead(1).nome == TipoToken.TIMES || lookahead(1).nome == TipoToken.DIVIDE) {
            Token op = match(lookahead(1).nome);
            No dir = fatoraritimetico();
            esq = new No("BINOP", op.lexema).add(esq).add(dir);
        }
        return esq;
    }

    No fatoraritimetico() {
        Token t = lookahead(1);
        if (t.nome == TipoToken.NUMBER)  { match(TipoToken.NUMBER); return new No("NUM", t.lexema); }
        if (t.nome == TipoToken.ID)      { match(TipoToken.ID);     return new No("ID", t.lexema); }
        if (t.nome == TipoToken.LPAREN) {
            match(TipoToken.LPAREN);
            No e = aritimetico();
            match(TipoToken.RPAREN);
            return e;                      // parênteses não precisam de nó
        }
        erroSintatico("NUMBER", "ID", "(");
        return null;
    }

    No relacional() {
        No esq = aritimetico();
        Token op = oprelacional();
        No dir = aritimetico();
        return new No("REL", op.lexema).add(esq).add(dir);
    }

    Token oprelacional() {
        TipoToken t = lookahead(1).nome;
        if (t == TipoToken.EQ || t == TipoToken.LT || t == TipoToken.GT
                || t == TipoToken.LE || t == TipoToken.GE || t == TipoToken.ASSIGN)
            return match(t);
        erroSintatico("==", "<", ">", "<=", ">=");
        return null;
    }

    No comando() {
        switch (lookahead(1).nome) {
            case ID: return atrib();
            case BEGIN: return bloco();
            case READ:  return read();
            case WRITE: return write();
            case IF:    return condicao();
            case WHILE: return loop();
            default: erroSintatico("atrib", "begin", "read", "write", "if", "while"); return null;
        }
    }
    //"if" "condicao" "then" "comando" "else"(caso necessidade) "comando" => if a>b then write(a) else write(b)
    No condicao() {
        match(TipoToken.IF);//if
        No cond = relacional();
        match(TipoToken.THEN);//then
        No entao = comando();
        No se = new No("IF").add(cond).add(entao);
        if (lookahead(1).nome == TipoToken.ELSE) {
            match(TipoToken.ELSE);//else
            se.add(comando());
        }
        return se;
    }
    //while condicao corpo ou do condicao while
    No loop() {
        match(TipoToken.WHILE);
        No cond = relacional();
        match(TipoToken.DO);
        No corpo = comando();
        return new No("WHILE").add(cond).add(corpo);
    }

    //"read" "(" ")" => read()
    No read() {
        match(TipoToken.READ);//read
        match(TipoToken.LPAREN);//(
        Token id = match(TipoToken.ID);
        match(TipoToken.RPAREN); //)
        return new No("READ").add(new No("ID", id.lexema));
    }

    No write() {
        match(TipoToken.WRITE);
        match(TipoToken.LPAREN);
        Token t = lookahead(1);
        if (t.nome == TipoToken.ID) {
            match(TipoToken.ID);
            match(TipoToken.RPAREN); //)
            return new No("WRITE").add(new No("ID", t.lexema));

        }
        if(t.nome == TipoToken.CADEIA) {
            match(TipoToken.CADEIA);
            match(TipoToken.RPAREN); //)
            return new No("WRITE").add(new No("CADEIA", t.lexema));
        }
        erroSintatico("ID", "CADEIA");
        return null;
    }

    No atrib() {
        Token id = match(TipoToken.ID);
        match(TipoToken.ASSIGN);
        No e = aritimetico();
        return new No("ATRIB", id.lexema).add(e);
    }

}