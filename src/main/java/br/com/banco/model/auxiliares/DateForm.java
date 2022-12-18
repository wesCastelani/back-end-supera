package br.com.banco.model.aux;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateForm {

    private LocalDate inicio;
    private LocalDate fim;
}
