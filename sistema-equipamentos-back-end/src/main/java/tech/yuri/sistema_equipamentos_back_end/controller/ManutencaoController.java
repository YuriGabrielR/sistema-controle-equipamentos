package tech.yuri.sistema_equipamentos_back_end.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.yuri.sistema_equipamentos_back_end.dtos.request.ManutencaoCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.ManutencaoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.service.ManutencaoService;



@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

  private final ManutencaoService manutencaoService; 

    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }





    @GetMapping
    public ResponseEntity<List<ManutencaoResponseDTO>> listar (){

        var result = manutencaoService.listar(); 
        return ResponseEntity.ok(result);

    }
    

    @PostMapping("/criar")
    public ResponseEntity criar(@RequestBody ManutencaoCriarRequestDTO data){

      manutencaoService.criar(data);

      Map<String, Object> response = new HashMap<>();
      response.put("message", "Manutencão criada com sucesso!");
      response.put("status", HttpStatus.CREATED);

      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    
    }

  

}