package com.prueba.fonyou.service.impl;

import com.prueba.fonyou.model.CalificacionEstudiante;
import com.prueba.fonyou.model.EnvioRespuesta;
import com.prueba.fonyou.model.Respuesta;
import com.prueba.fonyou.persistence.entity.ExamenxEstudianteEntity;
import com.prueba.fonyou.persistence.entity.OpcionEntity;
import com.prueba.fonyou.persistence.entity.PreguntaEntity;
import com.prueba.fonyou.persistence.entity.PreguntaxEstudianteEntity;
import com.prueba.fonyou.persistence.repository.ExamenxEstudianteRepository;
import com.prueba.fonyou.persistence.repository.OpcionRepository;
import com.prueba.fonyou.persistence.repository.PreguntaRepository;
import com.prueba.fonyou.persistence.repository.PreguntaxEstudianteRepository;
import com.prueba.fonyou.service.EnvioRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioRespuestaServiceImpl implements EnvioRespuestaService {

    @Autowired
    private ExamenxEstudianteRepository examenxEstudianteRepository;

    @Autowired
    private PreguntaxEstudianteRepository preguntaxEstudianteRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private OpcionRepository opcionRepository;


    @Override
    public CalificacionEstudiante envioRespuesta(EnvioRespuesta envioRespuesta) {

        CalificacionEstudiante calificacionEstudiante = new CalificacionEstudiante();

        ExamenxEstudianteEntity examenxEstudianteEntity = examenxEstudianteRepository.findByIdExamenAndIdEstudiante(envioRespuesta.getIdExamen(), envioRespuesta.getIdEstudiante());

        if (examenxEstudianteEntity != null) {
            List<PreguntaEntity> preguntaEntityList = preguntaRepository.findByIdExamen(envioRespuesta.getIdExamen());

            int respuestasCorrectas = 0;

            if (envioRespuesta.getRespuestas() != null && !envioRespuesta.getRespuestas().isEmpty()) {
                for (Respuesta respuesta : envioRespuesta.getRespuestas()) {

                    PreguntaxEstudianteEntity preguntaxEstudianteEntity = new PreguntaxEstudianteEntity();
                    preguntaxEstudianteEntity.setIdEstudiante(envioRespuesta.getIdEstudiante());
                    preguntaxEstudianteEntity.setFkIdPregunta(respuesta.getIdPregunta());
                    preguntaxEstudianteEntity.setRespuesta(respuesta.getRespuesta());
                    preguntaxEstudianteRepository.save(preguntaxEstudianteEntity);

                    OpcionEntity opcionEntity = opcionRepository.findByIdPreguntaIsCorrecta(respuesta.getIdPregunta());
                    if (opcionEntity.getLetra().equalsIgnoreCase(respuesta.getRespuesta())) {
                        respuestasCorrectas++;
                    }
                }
            }
            int cantidadPreguntas = preguntaEntityList.size();
            float valorPorPregunta = (float) 100 / cantidadPreguntas;
            float calificacion = valorPorPregunta * respuestasCorrectas;

            examenxEstudianteRepository.updateCalificacionEstudiante(String.valueOf(calificacion), examenxEstudianteEntity.getId());

            calificacionEstudiante.setCalificacion(calificacion);
            calificacionEstudiante.setRespuestasCorrectas(String.valueOf(respuestasCorrectas));
            return calificacionEstudiante;
        }

        throw new IllegalStateException("Estudiante no tiene examen asignado");
    }

}
