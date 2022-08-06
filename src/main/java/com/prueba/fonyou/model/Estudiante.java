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
public class Estudiante {

    @NotNull
    @NotEmpty(message = "El nombre del estudiante no puede ser vacio")
    private String nombre;
    @NotNull
    @NotEmpty(message = "La edad del estudiante no puede ser vacia")
    private String edad;
    @NotNull
    @NotEmpty(message = "La ciudad del estudiante no puede ser vacia")
    private String ciudad;
}
