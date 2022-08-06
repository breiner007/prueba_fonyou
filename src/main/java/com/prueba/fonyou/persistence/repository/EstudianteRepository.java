package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.EstudianteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, Integer> {

}
