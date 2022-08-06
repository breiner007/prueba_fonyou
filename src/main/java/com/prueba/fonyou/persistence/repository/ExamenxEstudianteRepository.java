package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.ExamenxEstudianteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExamenxEstudianteRepository extends CrudRepository<ExamenxEstudianteEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE \"examenx_estudiante\" SET \"calificacion\"=:calificacion WHERE \"id\"=:id", nativeQuery = true)
    void updateCalificacionEstudiante(@Param("calificacion") String calificacion, @Param("id") Integer id);

    @Query(value = "SELECT * FROM \"examenx_estudiante\" WHERE \"fk_id_examen\"=:fk_idExamen AND \"fk_id_estudiante\"=:fk_idEstudiante", nativeQuery = true)
    ExamenxEstudianteEntity findByIdExamenAndIdEstudiante(@Param("fk_idExamen") Integer idExamen, @Param("fk_idEstudiante") Integer idEstudiante);


}
