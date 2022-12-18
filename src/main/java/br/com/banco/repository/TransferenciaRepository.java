package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(nativeQuery = true, value = "select * from transferencia where conta_id = :contaId")
    List<Transferencia> findByConta(@Param("contaId") Long contaId);
}
