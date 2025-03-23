package tech.yuri.sistema_equipamentos_back_end.service; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
import tech.yuri.sistema_equipamentos_back_end.dtos.request.EquipamentoCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.EquipamentoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.Equipamento;
import tech.yuri.sistema_equipamentos_back_end.exceptions.EquipamentoNaoEncontradoException;
import tech.yuri.sistema_equipamentos_back_end.exceptions.NumeroDeSerieExistenteException;
import tech.yuri.sistema_equipamentos_back_end.mappers.EquipamentoMapper;
import tech.yuri.sistema_equipamentos_back_end.repository.EquipamentoRepository;


@Service
public class EquipamentoService{

    private final EquipamentoRepository equipamentoRepository; 
    private final EquipamentoMapper equipamentoMapper;


    public EquipamentoService(EquipamentoRepository equipamentoRepository, EquipamentoMapper equipamentoMapper) {
        this.equipamentoRepository = equipamentoRepository;
        this.equipamentoMapper = equipamentoMapper;
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

    public void criar(EquipamentoCriarRequestDTO data){

        var numeroDeSerieExiste = equipamentoRepository.existsByNumeroSerie(data.getNumeroSerie());

        if(numeroDeSerieExiste){
         throw  new NumeroDeSerieExistenteException("Já existe um equipamento cadastrado com o número de série: " + data.getNumeroSerie()
         );
        }

         var dataEntity = new Equipamento(); 
         dataEntity.setId(null); 
         dataEntity.setNome(data.getNome()); 
         dataEntity.setLocalizacaoEstoque(data.getLocalizacaoEstoque());
         dataEntity.setStatus(data.getStatus());
         dataEntity.setModelo(data.getModelo());
         dataEntity.setNumeroSerie(data.getNumeroSerie());

         equipamentoRepository.save(dataEntity);   
         
    }

    public EquipamentoResponseDTO listarPorId(String id){
        var idEntity = Long.valueOf(id);

        var result = equipamentoRepository
                .findById(idEntity)
                .orElseThrow(()-> new EquipamentoNaoEncontradoException(String.format("Equipamento com ID %s não encontrado.", id)));

        return equipamentoMapper.toDTO(result);

    }



    public void deletar(String id){
        var idEntity = Long.valueOf(id);

        var equipamentoExiste = equipamentoRepository
                .findById(idEntity)
                .orElseThrow(()-> new EquipamentoNaoEncontradoException(String.format("Equipamento com ID %s não encontrado.", id)));

        equipamentoRepository.deleteById(equipamentoExiste.getId());

    }

}