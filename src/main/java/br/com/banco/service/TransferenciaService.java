package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Transactional
    public List<Transferencia> transferenciasPorConta(Long id){
        List<Transferencia> transferencias = transferenciaRepository.findByConta(id);
        return transferencias;
    }

    @Transactional
    public List<Transferencia> transferenciasPorPeriodo(Long id, LocalDate inicio, LocalDate fim){
        List<Transferencia> transferencias = transferenciaRepository.findByPeriodo(id ,inicio, fim);
        return transferencias;
    }

    @Transactional
    public List<Transferencia> transferenciasPorOperador(Long id, String nomeOperador){
        List<Transferencia> transferencias = transferenciaRepository.findByOperador(id, nomeOperador);
        return transferencias;
    }

    public List<Transferencia> transferenciasPorPeriodoEOperador(Long id, LocalDate inicio, LocalDate fim, String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository.findByPeriodoEOperador(id, inicio, fim, nomeOperador);
        return transferencias;
    }
}
