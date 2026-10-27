import java.util.List;
import java.util.function.Supplier;

public class lexico {
    leitor ldat; //variavel ldat do "tipo" leitor

    private boolean inicioId(char c) {
        return (c >= 'a' && c <= 'z') || c == '_';
    }

    private boolean corpoId(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_';
    }

    public lexico(String arquivo) {
        ldat = new leitor(arquivo);
    }
    /* Cria objeto lexico -> recebe "programa.txt" -> cria um objeto leitor
    -> passa "programa.txt" para leitor -> guarda o leitor em ldat */

    public Token proximoToken() {//Core do analisador lexico
        //faz e leitura do texto de entrada até reconhecer um padrão

        WHITESPACE();
        ldat.confirmar();
        int ini = ldat.getInicio();

        List<Supplier<Token>> regras = List.of(//comment antes do oparitimetico se n da problema
                this::end, this::reservado, this::id, this::parenteses, this::NUMBER,
                this::comment, this::opAritimetico, this::opRelacional,
                this::semicolon, this::colon, this::dot, this::CADEIA_AUXILIAR
        );

        for (Supplier<Token> regra : regras) {
            Token t = regra.get();
            if (t != null) {
                ldat.confirmar();
                if (t.nome == TipoToken.COMMENT) return proximoToken();   // ignora comentaria
                t.pos = ini;
                return t;
            }
            ldat.zerar();
        }

        // nenhuma regra reconheceu: erro léxico
        int c = ldat.lerproxchar();
        throw new ErroCompilacao("Erro léxico: caractere inesperado '" + (char) c + "'", ini);



        /*
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
        prox = id();
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
        prox = colon();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }
        prox = CADEIA_AUXILIAR();
        if(prox == null) ldat.zerar();
        else{
            ldat.confirmar();
            return prox;
        }

        //todos os padroes

        System.err.println("Erro léxico kk");
        System.err.println(ldat.toString());

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

        return null;*/
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
        }
        else return null;

    }

    private Token semicolon(){ //delimitar final de linha
        int charlido = ldat.lerproxchar();
        if(charlido == ';') {
            return new Token(TipoToken.SEMICOLON, ";");
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

    private Token NUMBER() {
        char c = (char) ldat.lerproxchar();
        if (!Character.isDigit(c)) return null;
        while (true) {
            c = (char) ldat.lerproxchar();
            if (Character.isDigit(c)) continue;
            if (c == '.') {
                char d = (char) ldat.lerproxchar();
                if (Character.isDigit(d)) {
                    while (Character.isDigit(c = (char) ldat.lerproxchar())) ;
                    ldat.rollback();
                    return new Token(TipoToken.NUMBERREAL, ldat.getLexema());
                }
                ldat.rollback(); ldat.rollback();   // devolve '.' e d
                return new Token(TipoToken.NUMBER, ldat.getLexema());
            }
            ldat.rollback();
            return new Token(TipoToken.NUMBER, ldat.getLexema());
        }
    }

    private Token id() {
        char c = (char) ldat.lerproxchar();
        if (!inicioId(c)) return null;
        while (true) {
            c = (char) ldat.lerproxchar();
            if (!corpoId(c)) {
                ldat.rollback();
                return new Token(TipoToken.ID, ldat.getLexema());
            }
        }
    }

    private Token comment() {
        char c = (char) ldat.lerproxchar();
        if (c != '/') return null;

        c = (char) ldat.lerproxchar();
        if (c != '/') return null;          // era só uma '/', deixa para opAritimetico

        while (true) {
            int r = ldat.lerproxchar();
            if (r == -1 || r == '\n') {
                ldat.rollback();            // devolve o '\n' (ou EOF) para quem vem depois
                return new Token(TipoToken.COMMENT, ldat.getLexema());
            }
        }
    }

    private Token CADEIA_AUXILIAR(){
        int aux = 1;
        while(true){
            char c = (char) ldat.lerproxchar();
            if(aux==1){
                if(c=='\'') aux = 2;
                else return null;
            }
            else if (aux == 2){
                if(c=='\n') return null;
                if(c=='\'') return new Token(TipoToken.CADEIA, ldat.getLexema());
                else if (c== '\\') aux = 3;
            } else if (aux == 3){
                if(c=='\n') return null;
                else aux = 2;
            }
        }
    }

    private void WHITESPACE() {
        while (true) {
            char c = (char) ldat.lerproxchar();
            if (!Character.isWhitespace(c)) { ldat.rollback(); return; }
        }
    }

    private Token reservado(){
        while (true) {
            char c = (char) ldat.lerproxchar();
            if(!corpoId(c)){
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
                else return null;
            }

        }
    }

    private Token end() {                       // só fim de arquivo
        if (ldat.lerproxchar() == -1) return new Token(TipoToken.EOF, "EOF");
        return null;
    }

    private Token colon() {
        int charlido = ldat.lerproxchar();
        char c = (char) charlido;
        if (c == ':') return new Token(TipoToken.COLON, ":");
        else return null;
    }

    private Token dot() {
        if ((char) ldat.lerproxchar() == '.') return new Token(TipoToken.DOT, ".");
        return null;
    }
}