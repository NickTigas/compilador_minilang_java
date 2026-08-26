public class lexico {
    leitor ldat;

    public lexico(String arquivo) {
        ldat = new leitor(arquivo);
    }

    public Token proximoToken() {
        int charlido = -1;

        //espaço em branco
        while ((charlido = ldat.lerproxchar()) != -1) {
            char c = (char) charlido;
            if (c == ' ' || c == '\n') continue;
            if (c == 'p') {
                return new Token(TipoToken.PROGAM, "PROGAM");
            } else if (c == '=') {
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh ==
                if (c == '=') {
                    return new Token(TipoToken.EQ, "==");
                } else {
                    ldat.rollback();
                    return new Token(TipoToken.ASSIGN, "=");
                }
            } else if (c == '+') return new Token(TipoToken.PLUS, "+");
                else if (c == '-') return new Token(TipoToken.MINUS, "-");
                else if (c == '*') return new Token(TipoToken.TIMES, "*");
                else if (c == '/') return new Token(TipoToken.DIVIDE, "/");

                else if (c == '<') {
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh ==
                if (c == '=') {
                    return new Token(TipoToken.LE, "<=");
                } else {
                    ldat.rollback();
                    return new Token(TipoToken.LT, "<");
                }
            } else if (c == '>') {
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh >=
                if (c == '=') {
                    return new Token(TipoToken.GE, ">=");
                } else {
                    ldat.rollback();
                    return new Token(TipoToken.GT, ">");
                }
            } else if (c == '(') return new Token(TipoToken.LPAREN, "(");
            else if (c == ')') return new Token(TipoToken.RPAREN, ")");
            else if (c == '{') return new Token(TipoToken.LBRACE, "{");
            else if (c == '}') return new Token(TipoToken.RBRACE, "}");
            else if (c == ';') return new Token(TipoToken.SEMICOLON, ";");
            else if (c == ':') return new Token(TipoToken.COLON, ":");
            else if (c == ',') return new Token(TipoToken.COMMA, ",");
            else if (c == '.') return new Token(TipoToken.DOT, ".");
        }
        return null;
    }

    private Token opAritimetico(){
        int charlido = ldat.lerproxchar();
        char c = (char)charlido;

        if(c == '+') return new Token(TipoToken.PLUS, ldat.getLexema());
        else if(c == '-') return new Token(TipoToken.MINUS, ldat.getLexema());
        else if(c =='*') return new Token(TipoToken.TIMES, ldat.getLexema());
        else if(c== '/') return new Token(TipoToken.DIVIDE, ldat.getLexema());
        else return null;

    }
    private Token delimit(){
        int charlido = ldat.lerproxchar();
        char c = (char)charlido;
        if(c=='p') return new Token(TipoToken.PROGAM, ldat.getLexema());
        else return null;

    }
    private Token parenteses(){
        int charlido = ldat.lerproxchar();
        char c = (char)charlido;
        if (c == '(') return new Token(TipoToken.LPAREN, ldat.getLexema());
        else if (c == ')') return new Token(TipoToken.RPAREN, ldat.getLexema());
        else if (c == '{') return new Token(TipoToken.LBRACE, ldat.getLexema());
        else if (c == '}') return new Token(TipoToken.RBRACE, ldat.getLexema());
        else return null;
    }

    private Token opRelacional(){
        int charlido = ldat.lerproxchar();
        char c = (char)charlido;
        if (c == '=') {
            c = (char) ldat.lerproxchar();
            // verifica o prox char, pra confirma se eh ==
            if (c == '=') {
                return new Token(TipoToken.EQ, ldat.getLexema());
            } else {
                ldat.rollback();
                return new Token(TipoToken.ASSIGN, ldat.getLexema());
            }
        } else if (c == '<') {
            c = (char) ldat.lerproxchar();
            // verifica o prox char, pra confirma se eh ==
            if (c == '=') {
                return new Token(TipoToken.LE, ldat.getLexema());
            } else {
                ldat.rollback();
                return new Token(TipoToken.LT, ldat.getLexema());
            }
        } else if (c == '>') {
            c = (char) ldat.lerproxchar();
            // verifica o prox char, pra confirma se eh >=
            if (c == '=') {
                return new Token(TipoToken.GE, ldat.getLexema());
            } else {
                ldat.rollback();
                return new Token(TipoToken.GT, ldat.getLexema());
            }
        }
        else return null;
    }

    private Token NUMBER(){
        int number = 1;
        while (true){
            char c = (char) ldat.lerproxchar();
            if(number==1){
                if(Character.isDigit(c)) number = 2;
                else return null;
            }
            else if(number==2) {
                if (c == '.') {
                    c = (char) ldat.lerproxchar();
                    if (Character.isDigit(c)) number = 3;
                    else return null;
                }
            }
            else if(!Character.isDigit(c)){
                ldat.rollback();
                return new Token(TipoToken.NUMBER, ldat.getLexema());
            }
            else if(number==3){
                if(!Character.isDigit(c)){
                    ldat.rollback();
                    return new Token(TipoToken.NUMBERREAL, ldat.getLexema());
                }
            }
        }
    }

    private Token var(){
        int valor = 1;
        while (true){
            char c = (char) ldat.lerproxchar();
            if(valor==1){
                if(Character.isDigit(c)) valor = 2;
                else return null;
            }
            else if(valor==2){
                if(!Character.isLetterOrDigit(c)){
                    ldat.rollback();
                    return new Token(TipoToken.VAR, ldat.getLexema());
                }
            }
        }
    }
    private void WHITESPACE_COMMENT(){
        int estado = 1;
        while (true) {
            char c = (char) ldat.lerproxchar();
            if (estado == 1) {
                if (Character.isWhitespace(c) || c == ' ') estado = 2;
                else if (c == '%') estado = 3;
                else {
                    ldat.rollback();
                    return;
                }
            }
              else if(estado==2){
                if (c == '%') estado = 3;
                else if (!Character.isWhitespace(c) || c == ' ') {
                    ldat.rollback();
                    return;
                }
            }
              else if(estado==3){
                  if(c=='\n') return;
            }
        }
    }

    
}
