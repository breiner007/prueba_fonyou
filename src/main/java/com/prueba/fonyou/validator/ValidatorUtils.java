package com.prueba.fonyou.validator;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidatorUtils {

    public void validarFecha(LocalDateTime fecha) {
        if (fecha.isBefore(LocalDateTime.now()) || fecha.isEqual(LocalDateTime.now())) {
            throw new IllegalStateException("La fecha " + fecha + " no puede ser igual o anterior a la fecha actual");

        }
    }


}
