package tech.yuri.sistema_equipamentos_back_end.exceptions;

public class NumeroDeSerieExistenteException extends RuntimeException {
    public NumeroDeSerieExistenteException(String mensagem) {
        super(mensagem);
    }

    public NumeroDeSerieExistenteException(String mensagem, Throwable exception) {

        super(mensagem, exception);
    }
}
