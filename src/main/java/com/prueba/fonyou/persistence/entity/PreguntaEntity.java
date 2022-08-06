package com.prueba.fonyou.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "preguntas")
public class PreguntaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "pregunta")
    private String pregunta;

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_examen"))
    private Integer fkIdExamen;

}
