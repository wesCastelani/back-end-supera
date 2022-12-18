package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(nativeQuery = true, value = "select * from transferencia where conta_id = :contaId")
    List<Transferencia> findByConta(@Param("contaId") Long contaId);

    @Query(nativeQuery = true, value="select * from transferencia where conta_id = :contaId and data_transferencia between :inicio and :fim")
    List<Transferencia> findByPeriodo(@Param("contaId")Long contaId, @Param("inicio")LocalDate inicio, @Param("fim") LocalDate fim);
    @Query(nativeQuery = true, value = "Select * from transferencia where conta_id = :contaId and nome_operador_transacao = :operador")
    List<Transferencia> findByOperador(@Param("contaId")Long contaId, @Param("operador")String operador);
    @Query(nativeQuery = true, value = "select * from transferencia where conta_id = :contaId and data_transferencia between :inicio and :fim and nome_operador_transacao = :operador")
    List<Transferencia> findByPeriodoEOperador(@Param("contaId")Long id, @Param("inicio")LocalDate inicio, @Param("fim")LocalDate fim, @Param("operador")String operador);
}
