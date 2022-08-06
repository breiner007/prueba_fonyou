package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.PreguntaxEstudianteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PreguntaxEstudianteRepository extends CrudRepository<PreguntaxEstudianteEntity, Integer> {


}
