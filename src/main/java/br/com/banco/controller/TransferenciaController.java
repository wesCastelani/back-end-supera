package br.com.banco.controller;


import br.com.banco.model.Transferencia;
import br.com.banco.model.auxiliares.FiltroForm;
import br.com.banco.model.auxiliares.TransferenciasSaldo;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping(value = "/transferencias/{id}/periodo")
    public ResponseEntity<TransferenciasSaldo> listarTransferenciasPorPeriodo(@PathVariable Long id, @RequestBody FiltroForm filtro){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorPeriodo(id, filtro.getInicio(), filtro.getFim());
        TransferenciasSaldo transferenciasSaldo = somaSaldo(transferencias);
        return ResponseEntity.ok().body(transferenciasSaldo);
    }

    @PostMapping(value = "/transferencias/{id}/operador")
    public ResponseEntity<TransferenciasSaldo> listarTransferenciasPorOperador(@PathVariable Long id, @RequestBody FiltroForm filtro){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorOperador(id, filtro.getNomeOperador());
        TransferenciasSaldo transferenciasSaldo = somaSaldo(transferencias);
        return ResponseEntity.ok().body(transferenciasSaldo);
    }

    @PostMapping(value = "/transferencias/{id}/periodo/operador")
    public ResponseEntity<TransferenciasSaldo> listarTransferenciasPorPeriodoEOperador(@PathVariable Long id, @RequestBody FiltroForm filtro){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorPeriodoEOperador(id, filtro.getInicio(), filtro.getFim(), filtro.getNomeOperador());
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
