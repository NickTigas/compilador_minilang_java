public class lexico {
    leitor ldat; //variavel ldat do "tipo" leitor

    public lexico(String arquivo) {
        ldat = new leitor(arquivo);
    }
    /* Cria objeto lexico -> recebe "programa.txt" -> cria um objeto leitor
    -> passa "programa.txt" para leitor -> guarda o leitor em ldat */

    public Token proximoToken() {//Core do analisador lexico
        //faz e leitura do texto de entrada até reconhecer um padrão

        int charlido = -1; //começa em -1

        Token prox = null;
        WHITESPACE();
        ldat.confirmar();

        prox = end();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = reservado();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = var();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = parenteses();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = NUMBER();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = opAritimetico();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = opRelacional();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = comment();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = program();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = semicolon();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        //todos os padroes

        System.err.println("Erro léxico kk");
        System.err.println(ldat.toString());
        /*
        while ((charlido = ldat.lerproxchar()) != -1) {
            char c = (char) charlido; //ler char
            if (c == ' ' || c == '\n') continue; // espaço em branco ou \n = ignora
            if (c == 'p') {
                return new Token(TipoToken.PROGRAM, "PROGRAM");

            } else if (c == '=') { //compara o char =
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh ==
                if (c == '=') {
                    return new Token(TipoToken.EQ, "==");
                } else { // caso n seja eh =
                    ldat.rollback();
                    return new Token(TipoToken.ASSIGN, "=");
                }
                //operadores aritimeticos
            } else if (c == '+') return new Token(TipoToken.PLUS, "+");
                else if (c == '-') return new Token(TipoToken.MINUS, "-");
                else if (c == '*') return new Token(TipoToken.TIMES, "*");
                else if (c == '/') return new Token(TipoToken.DIVIDE, "/");

                //operadores logicos
                else if (c == '<') {//compara o char <
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh <=
                if (c == '=') {
                    return new Token(TipoToken.LE, "<=");
                } else { // caso n seja eh <
                    ldat.rollback();
                    return new Token(TipoToken.LT, "<");
                }
            } else if (c == '>') {//compara o char >
                c = (char) ldat.lerproxchar();
                // verifica o prox char, pra confirma se eh >=
                if (c == '=') { // verifica o prox char, pra confirma se eh >=
                    return new Token(TipoToken.GE, ">=");
                } else { // caso n seja eh >
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
        */
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

    private Token program(){
        int charlido = ldat.lerproxchar();
        if(charlido == -1) {
            return new Token(TipoToken.PROGRAM, "program");
            //new Token(TipoToken.PROGRAM, ldat.getLexema());
        }
        else return null;

    }

    private Token semicolon(){ //delimitar final de linha
        int charlido = ldat.lerproxchar();
        if(charlido == ';') {
            return new Token(TipoToken.SEMICOLON, ";");
            //new Token(TipoToken.PROGRAM, ldat.getLexema());
        }
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
                if(Character.isDigit(c)) valor = 2; //verific se eh digito
                else return null;
            }
            else if(valor==2){
                if(!Character.isLetterOrDigit(c)){//digito ou letra
                    ldat.rollback();
                    return new Token(TipoToken.VAR, ldat.getLexema());
                }
            }
        }
    }

    private Token comment(){
        int com = 1;
        while(true){
            char c = (char) ldat.lerproxchar();
            if(com==1){
                if(c=='^') com = 2;
                else return null;
            }
            else if (com == 2){
                if(c=='\n') return null;
                if(c=='^') return new Token(TipoToken.COMMENT, ldat.getLexema());
                else if (c== '\\') com = 3;
            } else if (com == 3){
                if(c=='\n') return null;
                else com = 2;
            }
        }
    }

    private void WHITESPACE(){
        int estado = 1;
        while (true) {
            char c = (char) ldat.lerproxchar();
            if (estado == 1) {
                if (Character.isWhitespace(c) || c == ' ') estado = 2;
                else if (c == '\t') estado = 3;
                else {
                    ldat.rollback();
                    return;
                }
            }
              else if(estado==2){
                if (c == '\t') estado = 3;
                else if (!Character.isWhitespace(c)) {// tirei o "|| c == ' '", o que parava a leitura no meio de espaços seguidos
                    return;
                }
            }
              else if(estado==3){
                  if(c=='\n') return;
            }
        }
    }
    private Token reservado(){
        while (true) {
            char c = (char) ldat.lerproxchar();
            if(!Character.isLetterOrDigit(c)){
                ldat.rollback();
                String lexema = ldat.getLexema();

                if(lexema.equals("program")) return new Token(TipoToken.PROGRAM, lexema);
                else if(lexema.equals("begin")) return new Token(TipoToken.BEGIN, lexema);
                else if(lexema.equals("end")) return new Token(TipoToken.END, lexema);
                else if(lexema.equals("read")) return new Token(TipoToken.READ, lexema);
                else if(lexema.equals("write")) return new Token(TipoToken.WRITE, lexema);
                else if(lexema.equals("if")) return new Token(TipoToken.IF, lexema);
                else if(lexema.equals("then")) return new Token(TipoToken.THEN, lexema);
                else if(lexema.equals("else")) return new Token(TipoToken.ELSE, lexema);
                else if(lexema.equals("while")) return new Token(TipoToken.WHILE, lexema);
                else if(lexema.equals("do")) return new Token(TipoToken.DO, lexema);
                else if(lexema.equals("int")) return new Token(TipoToken.INT, lexema);
                else if(lexema.equals("float")) return new Token(TipoToken.FLOAT, lexema);
                else return null;
            }

        }
    }

  /*(  private Token pontuacao(){

    }*/

    private Token end(){
        int charlido = ldat.lerproxchar();
        if(charlido == -1) return new Token(TipoToken.END, "end");
        return null;
    }

}
