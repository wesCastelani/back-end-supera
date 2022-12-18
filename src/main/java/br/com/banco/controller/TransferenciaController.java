package br.com.banco.controller;


import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping(value = "/transferencias/{id}")
    public ResponseEntity<List<Transferencia>> listarTransferenciasConta(@PathVariable Long id){
        List<Transferencia> transferencias = transferenciaService.transferenciasPorConta(id);
        return ResponseEntity.ok().body(transferencias);
    }
}
