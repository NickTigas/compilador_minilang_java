public class lexico {
    leitor ldat;

    public lexico(String arquivo){
        ldat = new leitor(arquivo);
    }
    public Token proximoToken(){
        int charlido = -1;

        //espaço em branco
        while((charlido = ldat.lerproxchar())!=-1){
            char c = (char)charlido;
            if( c == ' ' || c =='\n') continue;

            if(c == '=') {
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh ==
                if (c == '=') {
                    return new Token(TipoToken.EQ, "==");
                } else {
                    return new Token(TipoToken.ASSIGN, "=");
                }
            }

            else if(c == '+'){
                return new Token(TipoToken.PLUS, "+");
            }
            else if(c == '-'){
                return new Token(TipoToken.MINUS, "-");
            }
            else if(c =='*'){
                return new Token(TipoToken.TIMES, "*");
            }
            else if(c== '/'){
                return new Token(TipoToken.DIVIDE, "/");
            }
            else if(c== '<'){
                return new Token(TipoToken.LT, "<");
            }
            else if(c== '>'){
                return new Token(TipoToken.GT, ">");
            }
            else if(c== '('){
                return new Token(TipoToken.LPAREN, "(");
            }
            else if(c== ')'){
                return new Token(TipoToken.RPAREN, ")");
            }
            else if(c== '{'){
                return new Token(TipoToken.LBRACE, "{");
            }
            else if(c== '}'){
                return new Token(TipoToken.RBRACE, "}");
            }
            else if(c== ';'){
                return new Token(TipoToken.SEMICOLON, ";");
            }
            else if(c== ':'){
                return new Token(TipoToken.COLON, ":");
            }
            else if(c== ','){
                return new Token(TipoToken.COMMA, ",");
            }
            else if(c== '.'){
                return new Token(TipoToken.DOT, ".");
            }


        }
        return null;
    }
}
