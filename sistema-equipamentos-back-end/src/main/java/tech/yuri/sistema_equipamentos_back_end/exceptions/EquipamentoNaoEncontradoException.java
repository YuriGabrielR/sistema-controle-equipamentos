package tech.yuri.sistema_equipamentos_back_end.exceptions;

public class EquipamentoNaoEncontradoException extends RuntimeException{

    public EquipamentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EquipamentoNaoEncontradoException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }
}
