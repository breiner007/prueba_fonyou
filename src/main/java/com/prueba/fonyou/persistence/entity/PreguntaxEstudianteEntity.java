package com.prueba.fonyou.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "preguntax_estudiante")
public class PreguntaxEstudianteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fk_idPregunta")
    private Integer fkIdPregunta;

    @Column(name = "fk_idEstudiante")
    private Integer idEstudiante;

    @Column(name = "respuesta")
    private String respuesta;
}
