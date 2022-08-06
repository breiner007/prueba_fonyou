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
public class Respuesta {

    @NotNull
    @NotEmpty(message = "El id de la pregunta no puede ser vacio")
    private Integer idPregunta;
    @NotNull
    @NotEmpty(message = "La respuesta no puede ser vacia")
    private String respuesta;

}
