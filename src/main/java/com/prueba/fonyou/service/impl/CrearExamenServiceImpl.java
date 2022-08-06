package com.prueba.fonyou.service.impl;

import com.prueba.fonyou.converter.Converter;
import com.prueba.fonyou.model.Examen;
import com.prueba.fonyou.model.Opcion;
import com.prueba.fonyou.model.Pregunta;
import com.prueba.fonyou.persistence.entity.ExamenEntity;
import com.prueba.fonyou.persistence.entity.OpcionEntity;
import com.prueba.fonyou.persistence.entity.PreguntaEntity;
import com.prueba.fonyou.persistence.repository.ExamenRepository;
import com.prueba.fonyou.persistence.repository.OpcionRepository;
import com.prueba.fonyou.persistence.repository.PreguntaRepository;
import com.prueba.fonyou.service.CrearExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearExamenServiceImpl implements CrearExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private OpcionRepository opcionRepository;

    @Autowired
    private Converter converter;


    @Override
    public void crearExamen(Examen examen) {

        ExamenEntity examenEntity = examenRepository.save(converter.converterExamenToExamenEntity(examen));

        if (examen.getPreguntas() != null && !examen.getPreguntas().isEmpty()) {
            for (Pregunta pregunta : examen.getPreguntas()) {

                PreguntaEntity preguntaEntity =preguntaRepository.save(converter.converterPreguntaToPreguntaEntity(pregunta, examenEntity.getId()));

                for (Opcion opcion : pregunta.getOpcion()) {
                    opcionRepository.save(converter.converterOpcionToOpcionEntity(opcion, preguntaEntity.getId()));
                }

            }

        }

    }


}
