package tech.yuri.sistema_equipamentos_back_end.service; 

import org.springframework.stereotype.Service;

import tech.yuri.sistema_equipamentos_back_end.repository.ManutencaoRepository;



@Service
public class ManutencaoService{

    private ManutencaoRepository manutencaoRepository; 

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }


}