package com.prueba.fonyou.controller;

import com.prueba.fonyou.model.*;
import com.prueba.fonyou.service.AsignacionFechaService;
import com.prueba.fonyou.service.CrearEstudianteService;
import com.prueba.fonyou.service.CrearExamenService;
import com.prueba.fonyou.service.EnvioRespuestaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/service")
public class FonYouController {

    @Autowired
    private CrearExamenService crearExamenService;

    @Autowired
    private CrearEstudianteService crearEstudianteService;

    @Autowired
    private AsignacionFechaService asignacionFechaService;

    @Autowired
    private EnvioRespuestaService envioRespuestaService;


    @PostMapping(value = "/crearExamen",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void crearExamen(@RequestBody Examen examen) {
        crearExamenService.crearExamen(examen);
    }

    @PostMapping(value = "/crearEstudiante",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void crearEstudiante(@RequestBody Estudiante estudiante) {
        crearEstudianteService.crearEstudiante(estudiante);
    }

    @PostMapping(value = "/asignacionFecha",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void asignacionFecha(@RequestBody AsignacionFecha asignacionFecha) {
        asignacionFechaService.asignacionFecha(asignacionFecha);
    }

    @PostMapping(value = "/envioRespuesta",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionEstudiante envioRespuesta(@RequestBody EnvioRespuesta envioRespuesta) {
        return envioRespuestaService.envioRespuesta(envioRespuesta);
    }


}
