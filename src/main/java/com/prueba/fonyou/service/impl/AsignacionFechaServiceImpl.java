package com.prueba.fonyou.service.impl;

import com.prueba.fonyou.converter.Converter;
import com.prueba.fonyou.model.AsignacionFecha;
import com.prueba.fonyou.persistence.entity.ExamenxEstudianteEntity;
import com.prueba.fonyou.persistence.repository.ExamenxEstudianteRepository;
import com.prueba.fonyou.service.AsignacionFechaService;
import com.prueba.fonyou.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionFechaServiceImpl implements AsignacionFechaService {

    @Autowired
    private ExamenxEstudianteRepository examenxEstudianteRepository;

    @Autowired
    private Converter converter;

    @Autowired
    private ValidatorUtils validatorUtils;

    @Override
    public void asignacionFecha(AsignacionFecha asignacionFecha) {

        validatorUtils.validarFecha(asignacionFecha.getFechaPresentacion());

        for (Integer idEstudiante : asignacionFecha.getIdsEstudiantes()) {

            ExamenxEstudianteEntity examenxEstudianteEntity = new ExamenxEstudianteEntity();
            examenxEstudianteEntity.setFkIdExamen(asignacionFecha.getIdExamen());
            examenxEstudianteEntity.setFkIdEstudiante(idEstudiante);
            examenxEstudianteEntity.setFechaPresentacion(asignacionFecha.getFechaPresentacion().toString());

            examenxEstudianteRepository.save(examenxEstudianteEntity);
        }
    }


}
