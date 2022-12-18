package br.com.banco.model.auxiliares;

import br.com.banco.model.Transferencia;
import lombok.Data;

import java.util.List;

@Data
public class TransferenciasSaldo {

    private List<Transferencia> transferencias;
    private Float Saldo = 0f;

}
