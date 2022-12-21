package br.com.banco.model;


import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@Table(name="transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_transferencia", nullable = false)
    private Date dataTransferencia;
    @Column(name = "valor", nullable = false)
    private Float valor;
    @Column(name="tipo", nullable = false)
    private String tipo;
    @Column(name = "nome_operador_transacao", nullable = false)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name="conta_id")
    private Conta Conta;




}
