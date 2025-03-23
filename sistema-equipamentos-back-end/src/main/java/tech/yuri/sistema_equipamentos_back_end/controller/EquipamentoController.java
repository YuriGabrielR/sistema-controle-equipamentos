package tech.yuri.sistema_equipamentos_back_end.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import tech.yuri.sistema_equipamentos_back_end.dtos.request.EquipamentoCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.EquipamentoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.service.EquipamentoService;


@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService; 

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }


    @GetMapping
    public ResponseEntity<List<EquipamentoResponseDTO>>listar(){
            var resultado = equipamentoService.listar(); 

        return ResponseEntity.status(HttpStatus.OK).body(resultado); 
    }



    @PostMapping("/criar")
    public ResponseEntity criar(@RequestBody @Valid EquipamentoCriarRequestDTO data){
        equipamentoService.criar(data);

        Map<String, Object> response = new HashMap<>();
            response.put("message", "Equipamento criado com sucesso!");
            response.put("status", HttpStatus.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable("id") String id){
        var result = equipamentoService.listarPorId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Equipamento encontrado!");
        response.put("data", result);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") String id){
        equipamentoService.deletar(id);
        Map<String, Object> response = new HashMap<>();

        response.put("message", "Equipamento deletado com sucesso!");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}