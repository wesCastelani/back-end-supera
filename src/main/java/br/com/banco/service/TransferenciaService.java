package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
