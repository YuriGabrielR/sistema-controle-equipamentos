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
            response.put("Message", "Equipamento criado com sucesso!"); 
            response.put("status", HttpStatus.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    



}