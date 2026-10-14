import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class leitor {
    private final static int tamanhobuffer = 20;//5 tamanho do buffer que sera enviado para

    int[] bufferleitura;
    int ponteiro; //aponta pro momento que esta a lritura do buffer
    int bufferatual; //demontra o buffer que esta sendo usado atualmente
    int inilexema; //inicio do lexema que esta tentando ser achado

    private String lexema; //guarda o Lexema em string pra facilitar o uso do mesmo

    InputStream is; //InputStream le dados em sequência (bytes)


    public leitor(String arquivo) {//inicializa o lexico passando um caminho p/ um arquivo de entrada
        try {
            is = new FileInputStream(new File(arquivo)); //constroi o texto
            initbuffer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        // quando criado a instancia do texto, inputstream aponta pro arquivo
    }

    private void initbuffer() {
        /*divide o buffer em 2 pra poder ler a parte faltante depois do op logico
        assim evita o problema de comparação sem ter um espaço*/
        bufferatual = 2;
        inilexema = 0;
        lexema = "";
        bufferleitura = new int[tamanhobuffer *2 ]; // criação do buffer
        ponteiro = 0;
        recabuffer1();//buffer da esquerda
    }

    private void initponteiro() {
        ponteiro++;
        if (ponteiro == tamanhobuffer) recabuffer2(); //quando a esq chega na metade carrega direita
        else if (ponteiro == tamanhobuffer * 2) {// como são 40 posições(0-39) quando ele chega na posição 40 ele passa do limite de (0-39)
            recabuffer1();
            ponteiro = 0;
        }
    }

    private void recabuffer1() {//buffer esquerda
        if (bufferatual == 2){//evita carregamento desnecessario
            bufferatual = 1;
        for (int i = 0; i < tamanhobuffer; i++) {
            try {
                bufferleitura[i] = is.read();
                if (bufferleitura[i] == -1) break; //chega no fim para de carregar o buffer
            } catch (IOException ex) {
                Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    private void recabuffer2() {//buffer direita
        if (bufferatual == 1) {//evita carregamento desnecessario
            bufferatual = 2;

        for (int i = tamanhobuffer; i < tamanhobuffer * 2; i++) {// só preenche 2 posições
            try {
                bufferleitura[i] = is.read();
                if (bufferleitura[i] == -1) break;
            } catch (IOException ex) {
                Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    private int lercharbuffer(){
        int ret = bufferleitura[ponteiro];
        System.out.println(this);//estado atual da leitura do buffer
        initponteiro();
        return ret;
    }

    public int lerproxchar(){// metodo para ler char por char
        //int ret= is.read(); //retorna -1 quando chega no fim do arquivo
        int c = lercharbuffer(); // lex var acumula char
        lexema += (char)c ;
        System.out.print((char)c);
        return c;
    }

    public void rollback(){//retorna o ponteiro à posição anterior
        ponteiro--;
        lexema = lexema.substring(0,lexema.length() - 1); //tira o ultimo char do lexema
        if(ponteiro <0) ponteiro = tamanhobuffer*2-1; //lógica circular o final do ponteiro 2 conecta no começo do 1
    }

    public void zerar(){// caso não identifique um padrão (>, =) ele volta o ponteiro pro inicio do lexema
        ponteiro = inilexema;
        lexema = ""; //lexema se torna vazio
    }

    public void confirmar(){ // pega o inicio do lexema e agrega ao ponteiro, passa a leitura para frente pra continuar dps
        inilexema = ponteiro;
        lexema = "";
    }

    public String getLexema(){
        return  lexema;
    } //recupera o lexema

    @Override
    public String toString(){//retorna uma string que REPRESENTA(não é ele literal) o buffer
       String ret = "Buffer:["; // imprime todos os chars |
       for(int i : bufferleitura){ //                     v
           char c = (char)i;
           if(Character.isWhitespace(c)) ret += ' ';
           else{
               ret += (char)i;
           }
       }
       ret += "]\n";
       ret += "       ";
       for (int i = 0; i<tamanhobuffer*2;i++){//imprimi os ponteios
           if(i==inilexema && i == ponteiro) ret +="%"; //mesma posicao
           else if(i==inilexema) ret +="^"; //inicio do lexema
           else if(i == ponteiro) ret +="*"; //ponteiro
           else{
               ret +=" ";
           }
       }
       return ret;
    }
}
