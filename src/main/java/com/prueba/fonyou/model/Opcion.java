package com.prueba.fonyou.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Opcion {

    @NotNull
    @NotEmpty(message = "El valor de la letra no puede ser vacio")
    private String letra;

    @NotNull
    @NotEmpty(message = "El valor de la opcion de la pregunta no puede ser vacio")
    private String valor;

    @NotNull
    private boolean opcionCorrecta;
}
