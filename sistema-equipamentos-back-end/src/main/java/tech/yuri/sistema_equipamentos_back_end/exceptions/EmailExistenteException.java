package tech.yuri.sistema_equipamentos_back_end.exceptions; 



public class EmailExistenteException extends RuntimeException {

    public EmailExistenteException(String mensagem) {
        super(mensagem);
    }
        
    public EmailExistenteException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }
}