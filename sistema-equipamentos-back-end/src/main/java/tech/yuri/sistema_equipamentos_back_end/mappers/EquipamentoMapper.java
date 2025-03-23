package tech.yuri.sistema_equipamentos_back_end.mappers;

import org.springframework.stereotype.Component;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.EquipamentoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.Equipamento;

@Component
public class EquipamentoMapper {

    public EquipamentoResponseDTO toDTO(Equipamento data){

        if(data == null){
            return null;
        }

        var equipamentoDTO = new EquipamentoResponseDTO();
        equipamentoDTO.setId(data.getId());
        equipamentoDTO.setNome(data.getNome());
        equipamentoDTO.setLocalizacaoEstoque(data.getLocalizacaoEstoque());
        equipamentoDTO.setStatus(data.getStatus());
        equipamentoDTO.setModelo(data.getModelo());
        equipamentoDTO.setNumeroSerie(data.getNumeroSerie());

        return equipamentoDTO;
    }


    public Equipamento toEntity(EquipamentoResponseDTO data){

        if(data == null){
        return null;
        }

        var equipamentoEntity = new Equipamento();
        equipamentoEntity.setId(data.getId());
        equipamentoEntity.setNome(data.getNome());
        equipamentoEntity.setLocalizacaoEstoque(data.getLocalizacaoEstoque());
        equipamentoEntity.setStatus(data.getStatus());
        equipamentoEntity.setModelo(data.getModelo());
        equipamentoEntity.setNumeroSerie(data.getNumeroSerie());

        return equipamentoEntity;

    }

}
