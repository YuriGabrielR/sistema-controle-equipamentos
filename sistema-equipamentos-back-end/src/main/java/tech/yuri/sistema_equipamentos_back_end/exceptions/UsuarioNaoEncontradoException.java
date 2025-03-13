package tech.yuri.sistema_equipamentos_back_end.exceptions; 



public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
        
    public UsuarioNaoEncontradoException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }
}