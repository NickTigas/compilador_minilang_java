import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class leitor {
    private final static int tamanhobuffer = 20;//5

    int[] bufferleitura;
    int ponteiro;
    int bufferatual;
    int inilexema;

    private String lexema;

    InputStream is;


    public leitor(String arquivo) {
        try {
            is = new FileInputStream(new File(arquivo));
            initbuffer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initbuffer() {
        bufferatual = 2;
        inilexema = 0;
        lexema = "";
        bufferleitura = new int[tamanhobuffer *2 ]; // taca dando problema por conta do tam do buffer
        ponteiro = 0;
        recabuffer1();
    }

    private void initponteiro() {
        ponteiro++;
        if (ponteiro == tamanhobuffer) recabuffer2();
        else if (ponteiro == tamanhobuffer * 2) {// como são 40 posições(0-39) quando ele chega na posição 40 ele passa do limite de (0-39)
            recabuffer1();
            ponteiro = 0;
        }
    }

    private void recabuffer1() {
        if (bufferatual == 2){
            bufferatual = 1;
        for (int i = 0; i < tamanhobuffer; i++) {
            try {
                bufferleitura[i] = is.read();
                if (bufferleitura[i] == -1) break;
            } catch (IOException ex) {
                Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    private void recabuffer2() {
        if (bufferatual == 1) {
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
        System.out.println(this);
        initponteiro();
        return ret;
    }

    public int lerproxchar(){
        int c = lercharbuffer();
        lexema += (char)c ;
        //System.out.print((char)c);
        return c;
    }

    public void rollback(){
        ponteiro--;
        lexema = lexema.substring(0,lexema.length() - 1);
        if(ponteiro <0) ponteiro = tamanhobuffer*2-1; // talvez isso impacta a linha 39 por causa do ponteiro negativo ele dá voltas assim podendo cair na posição 40 no qual quebra as posições(0-39)

    }

    public void zerar(){
        ponteiro = inilexema;
        lexema = "";
    }

    public void confirmar(){
        inilexema = ponteiro;
        lexema = "";
    }

    public String getLexema(){
        return  lexema;
    }

    @Override
    public String toString(){
       String ret = "Buffer:[";
       for(int i : bufferleitura){
           char c = (char)i;
           if(Character.isWhitespace(c)) ret += ' ';
           else{
               ret += (char)i;
           }
       }
       ret += "]\n";
       ret += "       ";
       for (int i = 0; i<tamanhobuffer*2;i++){
           if(i==inilexema && i == ponteiro) ret +="%";
           else if(i==inilexema) ret +="^";
           else if(i == ponteiro) ret +="*";
           else{
               ret +=" ";
           }
       }
       return ret;
    }
}
