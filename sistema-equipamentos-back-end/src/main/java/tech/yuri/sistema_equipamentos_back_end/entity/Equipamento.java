package tech.yuri.sistema_equipamentos_back_end.entity;

import jakarta.persistence.*;
import tech.yuri.sistema_equipamentos_back_end.enums.EquipamentoStatus;

@Entity
@Table(name = "tb_equipamentos")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacaoEstoque;

    private EquipamentoStatus status;

    private String modelo;

    private String numeroSerie;


    public Equipamento() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacaoEstoque() {
        return localizacaoEstoque;
    }

    public void setLocalizacaoEstoque(String localizacaoEstoque) {
        this.localizacaoEstoque = localizacaoEstoque;
    }

    public EquipamentoStatus getStatus() {
        return status;
    }

    public void setStatus(EquipamentoStatus status) {
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
