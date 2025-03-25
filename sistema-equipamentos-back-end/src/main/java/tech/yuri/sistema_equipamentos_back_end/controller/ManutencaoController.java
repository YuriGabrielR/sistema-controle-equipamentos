package tech.yuri.sistema_equipamentos_back_end.controller; 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.yuri.sistema_equipamentos_back_end.service.ManutencaoService;



@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

  private ManutencaoService manutencaoService; 

    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

  

}