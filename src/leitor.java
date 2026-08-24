import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class leitor {
    private final static  int tamanhobuffer = 5;
    int [] bufferleitura;
    int ponteiro;
    InputStream is;


    InputStream is;
    public leitor(String arquivo){
        try {
            is = new FileInputStream(new File(arquivo));
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initbuffer(){
        bufferleitura = new int[tamanhobuffer];
        ponteiro = 0;
        recabuffer1();
    }

    private void initponteiro() {
        ponteiro++;
        if(ponteiro == tamanhobuffer) recabuffer2();
        else if(ponteiro == tamanhobuffer+2) {
            recabuffer1();
            ponteiro = 0;
            }
        }


    }

    private void recabuffer1(){
        for(int i=0;i<tamanhobuffer;i++){
            try{
            bufferleitura[i] = is.read();
            if(bufferleitura[i] == -1) break;
        }
            catch (IOException ex){
            Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void recabuffer2(){
        for(int i= tamanhobuffer ;i<tamanhobuffer+2;i++){
            try{
                bufferleitura[i] = is.read();
                if(bufferleitura[i] == -1) break;
            }
            catch (IOException ex){
                Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int lerproxchar(){
        int ret = is.read();
        System.out.print((char)ret);
        return ret;
    }
    catch (IOException ex){
        Logger.getLogger(leitor.class.getName()).log(Level.SEVERE, null, ex);
        return -1;
    }
}


