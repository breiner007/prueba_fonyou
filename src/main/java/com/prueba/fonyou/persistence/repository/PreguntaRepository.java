package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PreguntaRepository extends CrudRepository<PreguntaEntity, Integer> {

    @Query(value = "SELECT * FROM \"preguntas\" WHERE \"fk_id_examen\"=:fk_idExamen ", nativeQuery = true)
    List<PreguntaEntity> findByIdExamen(@Param("fk_idExamen") Integer idExamen);


}
