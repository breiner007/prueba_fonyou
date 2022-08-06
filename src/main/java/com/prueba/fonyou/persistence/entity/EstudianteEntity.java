package com.prueba.fonyou.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private String edad;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "zona_horaria")
    private String zonaHoraria;
}
