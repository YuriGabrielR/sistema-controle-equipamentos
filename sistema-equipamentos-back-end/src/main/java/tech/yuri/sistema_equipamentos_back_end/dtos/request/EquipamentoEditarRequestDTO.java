package tech.yuri.sistema_equipamentos_back_end.dtos.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.yuri.sistema_equipamentos_back_end.enums.EquipamentoStatus;

public class EquipamentoEditarRequestDTO {

    @Size(min=4, message="O campo NOME deve conter pelo menos 4 caracteres.")
    private String nome;

    @Size(min=4, message="O campo LOCALIZAÇÃO ESTOQUE deve conter pelo menos 4 caracteres.")
    private String localizacaoEstoque;

    @NotNull(message="O campo STATUS não pode ser vazio")
    private EquipamentoStatus status;

    @Size(min=4, message="O campo MODELO deve conter pelo menos 4 caracteres.")
    private String modelo;

    @Size(min=4, message="O campo NUMÉRO DE SÉRIE deve conter pelo menos 4 caracteres.")
    private String numeroSerie;


    public  String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacaoEstoque() {
        return localizacaoEstoque;
    }

    public void setLocalizacaoEstoque( String localizacaoEstoque) {
        this.localizacaoEstoque = localizacaoEstoque;
    }

    public EquipamentoStatus getStatus() {
        return status;
    }

    public void setStatus (EquipamentoStatus status) {
        this.status = status;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
