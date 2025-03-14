package tech.yuri.sistema_equipamentos_back_end.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.yuri.sistema_equipamentos_back_end.dtos.request.UserCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.UserResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService UserService; 

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }


  @PostMapping("/criar")
  public ResponseEntity criar(@RequestBody @Valid UserCriarRequestDTO data ){
        UserService.criar(data);

        Map<String, Object> response = new HashMap<>(); 

        response.put("Message:", "Usuário criado"); 
        response.put("status", HttpStatus.OK);


        return ResponseEntity.ok(response); 

    }  


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listar(){
        var result = UserService.listar(); 
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> listarPorId(@PathVariable("id") String id){
        var result = UserService.listarPorId(id); 
        return ResponseEntity.ok(result);

    }

}