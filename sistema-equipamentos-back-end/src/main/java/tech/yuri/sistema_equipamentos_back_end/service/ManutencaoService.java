package tech.yuri.sistema_equipamentos_back_end.service; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.yuri.sistema_equipamentos_back_end.dtos.request.ManutencaoCriarRequestDTO;
import tech.yuri.sistema_equipamentos_back_end.dtos.response.ManutencaoResponseDTO;
import tech.yuri.sistema_equipamentos_back_end.entity.Manutencao;
import tech.yuri.sistema_equipamentos_back_end.repository.ManutencaoRepository;



@Service
public class ManutencaoService{

    private final ManutencaoRepository manutencaoRepository; 

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }


    public List<ManutencaoResponseDTO> listar(){    
        var resultadoEntity = manutencaoRepository.findAll(); 

        var resultadoToDTO = resultadoEntity.stream().map(manutencao -> 
        new ManutencaoResponseDTO(
            manutencao.getId(), 
            manutencao.getDataInicioManutencao(), 
            manutencao.getDataFimManutencao(), 
            manutencao.getTipoManutencao(), 
            manutencao.getResponsavel(),
            manutencao.getCusto(), 
            manutencao.getStatusManutencao(), 
            manutencao.getObservacoes()
            )).collect(Collectors.toList());


        return resultadoToDTO; 

    }
    
    public void criar (ManutencaoCriarRequestDTO data){
        var dataToEntity = new Manutencao(); 
        dataToEntity.setDataInicioManutencao(data.getDataInicioManutencao());
        dataToEntity.setDataFimManutencao(data.getDataFimManutencao());
        dataToEntity.setResponsavel(data.getResponsavel());
        dataToEntity.setCusto(data.getCusto());
        dataToEntity.setStatusManutencao(data.getStatusManutencao());

        manutencaoRepository.save(dataToEntity);       
        
    }

}