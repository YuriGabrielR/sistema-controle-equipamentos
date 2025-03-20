package tech.yuri.sistema_equipamentos_back_end.controller; 

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}