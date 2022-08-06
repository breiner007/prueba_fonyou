package com.prueba.fonyou.service.impl;

import com.prueba.fonyou.converter.Converter;
import com.prueba.fonyou.model.Estudiante;
import com.prueba.fonyou.persistence.repository.EstudianteRepository;
import com.prueba.fonyou.service.CrearEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearEstudianteServiceImpl implements CrearEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private Converter converter;

    @Override
    public void crearEstudiante(Estudiante estudiante) {

        estudianteRepository.save(converter.converterEstudianteToEstudianteEntity(estudiante, ""));

    }

}
