package tech.yuri.sistema_equipamentos_back_end.exceptions; 

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice

public class GlobalHandlerException {

@ExceptionHandler(UsuarioNaoEncontradoException.class)
public ResponseEntity<Object> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex){
    
    Map<String, Object> response = new HashMap<>();
  
    response.put("error", ex.getMessage());
    response.put("Message", "usuário não encontrado");
    
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}


@ExceptionHandler(EmailExistenteException.class)
public ResponseEntity<Object> handleEmailExisteException(EmailExistenteException ex){

    Map<String, Object> response = new HashMap<>();

    response.put("Error", "Erro no email");
    response.put("Message", ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
}

}
