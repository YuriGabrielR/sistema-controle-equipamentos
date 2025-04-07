package tech.yuri.sistema_equipamentos_back_end.dtos.request; 

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.yuri.sistema_equipamentos_back_end.enums.ManutencaoStatus;
import tech.yuri.sistema_equipamentos_back_end.enums.ManutencaoTipos;



public class ManutencaoCriarRequestDTO {

    @NotNull(message="O campo Data Início da Manutenção não pode ser vazio ")
    @NotBlank(message="O campo Data Início da Manutenção não pode conter espaços vazios ")
    private LocalDate dataInicioManutencao;

    
    @NotNull(message="O campo Data Fim da Manutenção não pode ser vazio ")
    @NotBlank(message="O campo Data Fim da Manutenção não pode conter espaços vazios ")
    private LocalDate dataFimManutencao;


    @NotNull(message="O campo Tipo de Manutenção não pode ser vazio")
    private ManutencaoTipos tipoManutencao; 

    @NotNull(message="O campo RESPONSÁVEL pela Manutenção não pode ser vazio")
    private String responsavel; 

    @NotNull(message="O campo CUSTO da manutenção não pode ser vazio")
    private Double custo; 

    @NotNull(message="O campo Status da manutenção não pode ser vazio")
    private ManutencaoStatus statusManutencao; 

    private String observacoes; 


    public ManutencaoCriarRequestDTO() {}

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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


}