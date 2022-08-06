package com.prueba.fonyou.converter;

import com.prueba.fonyou.model.Estudiante;
import com.prueba.fonyou.model.Examen;
import com.prueba.fonyou.model.Opcion;
import com.prueba.fonyou.model.Pregunta;
import com.prueba.fonyou.persistence.entity.EstudianteEntity;
import com.prueba.fonyou.persistence.entity.ExamenEntity;
import com.prueba.fonyou.persistence.entity.OpcionEntity;
import com.prueba.fonyou.persistence.entity.PreguntaEntity;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public ExamenEntity converterExamenToExamenEntity(Examen examen) {

        ExamenEntity examenEntity = new ExamenEntity();
        examenEntity.setNombre(examen.getNombre());

        return examenEntity;
    }

    public PreguntaEntity converterPreguntaToPreguntaEntity(Pregunta pregunta, Integer idExamen) {

        PreguntaEntity preguntaEntity = new PreguntaEntity();
        preguntaEntity.setPregunta(pregunta.getEnunciado());
        preguntaEntity.setFkIdExamen(idExamen);

        return preguntaEntity;
    }

    public OpcionEntity converterOpcionToOpcionEntity(Opcion opcion, Integer idPregunta) {

        OpcionEntity opcionEntity = new OpcionEntity();
        opcionEntity.setOpcion(opcion.getValor());
        opcionEntity.setLetra(opcion.getLetra());
        opcionEntity.setEsCorrecta(opcion.isOpcionCorrecta());
        opcionEntity.setFkIdPregunta(idPregunta);

        return opcionEntity;
    }

    public EstudianteEntity converterEstudianteToEstudianteEntity(Estudiante estudiante, String zonaHoraria) {

        EstudianteEntity estudianteEntity = new EstudianteEntity();
        estudianteEntity.setNombre(estudiante.getNombre());
        estudianteEntity.setEdad(estudiante.getEdad());
        estudianteEntity.setCiudad(estudiante.getCiudad());
        estudianteEntity.setZonaHoraria(zonaHoraria);

        return estudianteEntity;
    }


}
