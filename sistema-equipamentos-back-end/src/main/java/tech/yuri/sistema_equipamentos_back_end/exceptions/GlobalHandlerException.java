package tech.yuri.sistema_equipamentos_back_end.exceptions; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice

public class GlobalHandlerException {

@ExceptionHandler(UsuarioNaoEncontradoException.class)
public ResponseEntity<Object> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex){
    
    Map<String, Object> response = new HashMap<>();

    response.put("message", ex.getMessage());
    response.put("error", true);

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}


@ExceptionHandler(EmailExistenteException.class)
public ResponseEntity<Object> handleEmailExisteException(EmailExistenteException ex){

    Map<String, Object> response = new HashMap<>();

    response.put("message", ex.getMessage());
    response.put("error", true);

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
}


@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Object> handleValidationsContraints (MethodArgumentNotValidException ex){

    Map<String, Object> response = new HashMap<>();     

     List<String> errorMessages = ex.getBindingResult()
                                    .getAllErrors()
                                    .stream()
                                    .map(error -> error.getDefaultMessage())
                                    .collect(Collectors.toList());

    response.put("message", errorMessages);
    response.put("error", true);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); 

}

@ExceptionHandler(EquipamentoNaoEncontradoException.class)
 public ResponseEntity<Object> handleEquipamentoNaoEncontrado(EquipamentoNaoEncontradoException ex) {

    Map<String, Object> response = new HashMap<>();

    response.put("message", ex.getMessage());
    response.put("error", true);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
}


@ExceptionHandler(NumeroDeSerieExistenteException.class)
    public ResponseEntity<Object> handleNumeroDeSerieExistente(NumeroDeSerieExistenteException ex){

    Map<String, Object> response = new HashMap<>();

    response.put("message", ex.getMessage());
    response.put("error", true);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

}

}
