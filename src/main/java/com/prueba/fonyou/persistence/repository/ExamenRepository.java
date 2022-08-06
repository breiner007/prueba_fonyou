package com.prueba.fonyou.persistence.repository;

import com.prueba.fonyou.persistence.entity.ExamenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends CrudRepository<ExamenEntity, Integer> {

}
