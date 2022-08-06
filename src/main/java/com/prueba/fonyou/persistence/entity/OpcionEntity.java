package com.prueba.fonyou.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "opciones")
public class OpcionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "letra")
    private String letra;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "es_correcta")
    private boolean esCorrecta;

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_pregunta"))
    private Integer fkIdPregunta;

}
