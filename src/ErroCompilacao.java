public class ErroCompilacao extends RuntimeException {
    public final int pos;   // deslocamento (offset) no arquivo

    public ErroCompilacao(String mensagem, int pos) {
        super(mensagem);
        this.pos = pos;
    }
}