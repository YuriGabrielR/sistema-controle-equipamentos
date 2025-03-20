package tech.yuri.sistema_equipamentos_back_end.service; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.yuri.sistema_equipamentos_back_end.dtos.response.EquipamentoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.repository.EquipamentoRepository;


@Service
public class EquipamentoService{

    private final EquipamentoRepository equipamentoRepository; 

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }


    public List<EquipamentoResponseDTO> listar(){
        var resultadoEntity = equipamentoRepository.findAll(); 

        var resultadoToDTO = resultadoEntity.stream().map(equipamento -> 
        new EquipamentoResponseDTO(
            equipamento.getId(), 
            equipamento.getLocalizacaoEstoque(), 
            equipamento.getModelo(), 
            equipamento.getNome(), 
            equipamento.getNumeroSerie(), 
            equipamento.getStatus()))
            .collect(Collectors.toList())
        ;

        return resultadoToDTO;
    }    


}