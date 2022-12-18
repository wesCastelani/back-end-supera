package br.com.banco.model.auxiliares;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FiltroForm {

    private LocalDate inicio;
    private LocalDate fim;
    private String nomeOperador;
}
