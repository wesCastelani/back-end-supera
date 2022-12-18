package br.com.banco.controller;


import br.com.banco.model.Transferencia;
import br.com.banco.model.aux.DateForm;
import br.com.banco.model.auxiliares.TransferenciasSaldo;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping(value = "/transferencias/{id}")
    public ResponseEntity<TransferenciasSaldo> listarTransferenciasConta(@PathVariable Long id){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorConta(id);
        TransferenciasSaldo transferenciasSaldo = somaSaldo(transferencias);
        return ResponseEntity.ok().body(transferenciasSaldo);
    }

    @GetMapping(value = "/transferencias/{id}/periodo")
    public ResponseEntity<TransferenciasSaldo> listarTransferenciasPorPeriodo(@PathVariable Long id, @RequestBody DateForm dateForm){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorPeriodo(id, dateForm);
        TransferenciasSaldo transferenciasSaldo = somaSaldo(transferencias);
        return ResponseEntity.ok().body(transferenciasSaldo);
    }

    private TransferenciasSaldo somaSaldo(List<Transferencia> transferencias){
        TransferenciasSaldo transferenciasSaldo = new TransferenciasSaldo();
        transferenciasSaldo.setTransferencias(transferencias);
        transferencias.forEach(transferencia -> {
            transferenciasSaldo.setSaldo(transferenciasSaldo.getSaldo() + transferencia.getValor());
        });
        return transferenciasSaldo;
    }
}
