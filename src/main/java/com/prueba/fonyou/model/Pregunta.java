package com.prueba.fonyou.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    @NotNull
    @NotEmpty(message = "El enunciado de la pregunta no puede ser vacio")
    private String enunciado;

    @NotNull
    @NotEmpty(message = "Las opciones de la pregunta no pueden ser vacias")
    private List<Opcion> opcion;
}
