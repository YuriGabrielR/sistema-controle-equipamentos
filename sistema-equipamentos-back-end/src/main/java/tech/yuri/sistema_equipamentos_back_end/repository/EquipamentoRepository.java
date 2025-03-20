package tech.yuri.sistema_equipamentos_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.yuri.sistema_equipamentos_back_end.entity.Equipamento;


@Repository
public interface EquipamentoRepository extends  JpaRepository<Equipamento, Long>{}