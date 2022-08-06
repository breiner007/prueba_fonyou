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
public class EnvioRespuesta {

    @NotNull
    @NotEmpty(message = "El id del estudiante no puede ser vacio")
    private Integer idEstudiante;

    @NotNull
    @NotEmpty(message = "El id del examen no puede ser vacio")
    private Integer idExamen;

    private List<Respuesta> respuestas;

}
