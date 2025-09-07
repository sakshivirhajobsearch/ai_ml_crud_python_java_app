package com.ai.ml.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ai.ml.entity.DataEntity;

@Repository
public interface DataRepository extends CrudRepository<DataEntity, Integer> {
}