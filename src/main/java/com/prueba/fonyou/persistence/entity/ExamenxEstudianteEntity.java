package com.prueba.fonyou.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "examenx_estudiante")
public class ExamenxEstudianteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_examen"))
    private Integer fkIdExamen;

    @Column(name = "fecha_presentacion")
    private String fechaPresentacion;

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_estudiante"))
    private Integer fkIdEstudiante;

    @Column(name = "calificacion")
    private String calificacion;
}
