package com.prueba.fonyou.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Examen {

    @NotNull
    private String nombre;

    @NotNull
    private List<Pregunta> preguntas;
}
