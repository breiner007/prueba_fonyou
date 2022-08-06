package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.OpcionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OpcionRepository extends CrudRepository<OpcionEntity, Integer> {

    @Query(value = "SELECT * FROM \"opciones\" WHERE \"fk_id_pregunta\"=:fk_idPregunta AND \"es_correcta\"=true", nativeQuery = true)
    OpcionEntity findByIdPreguntaIsCorrecta(@Param("fk_idPregunta") Integer idPregunta);

}
