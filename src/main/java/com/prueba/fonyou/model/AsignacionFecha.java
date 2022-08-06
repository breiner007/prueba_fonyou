package com.prueba.fonyou.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionFecha {

    @NotNull
    @NotEmpty(message = "La fecha de presentacion del examen no puede ser vacio")
    private LocalDateTime fechaPresentacion;
    @NotNull
    @NotEmpty(message = "El id del examen no puede ser vacio")
    private Integer idExamen;
    @NotNull
    @NotEmpty(message = "Debe contener por lo menos un estudiante")
    private List<Integer> idsEstudiantes;

}
