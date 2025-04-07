package tech.yuri.sistema_equipamentos_back_end.dtos.response; 

import java.time.LocalDate;

import tech.yuri.sistema_equipamentos_back_end.enums.ManutencaoStatus;
import tech.yuri.sistema_equipamentos_back_end.enums.ManutencaoTipos;



public class ManutencaoResponseDTO{

    private Long id; 

    private LocalDate dataInicioManutencao;

    private LocalDate dataFimManutencao;

    private ManutencaoTipos tipoManutencao; 

    private String responsavel; 


    private Double custo; 

    private ManutencaoStatus statusManutencao; 

    private String observacoes; 


    

    public ManutencaoResponseDTO() {
    }

    public ManutencaoResponseDTO(
        Long id, LocalDate dataInicioManutencao, LocalDate dataFimManutencao, ManutencaoTipos tipoManutencao,String responsavel, Double custo,ManutencaoStatus statusManutencao, String observacoes) {
       
        this.id = id;
        this.dataInicioManutencao = dataInicioManutencao;
        this.dataFimManutencao = dataFimManutencao;
        this.tipoManutencao = tipoManutencao;
        this.responsavel = responsavel;
        this.custo = custo;
        this.statusManutencao = statusManutencao;
        this.observacoes = observacoes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicioManutencao() {
        return dataInicioManutencao;
    }

    public void setDataInicioManutencao(LocalDate dataInicioManutencao) {
        this.dataInicioManutencao = dataInicioManutencao;
    }

    public LocalDate getDataFimManutencao() {
        return dataFimManutencao;
    }

    public void setDataFimManutencao(LocalDate dataFimManutencao) {
        this.dataFimManutencao = dataFimManutencao;
    }

    public ManutencaoTipos getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(ManutencaoTipos tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public ManutencaoStatus getStatusManutencao() {
        return statusManutencao;
    }

    public void setStatusManutencao(ManutencaoStatus statusManutencao) {
        this.statusManutencao = statusManutencao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    

}