package com.ai.ml.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.ml.entity.DataEntity;
import com.ai.ml.repository.DataRepository;

@Service
public class DataService {

	private final DataRepository dataRepository;

	public DataService(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	public DataEntity saveData(DataEntity dataEntity) {
		return dataRepository.save(dataEntity);
	}

	public List<DataEntity> getAllData() {
		return (List<DataEntity>) dataRepository.findAll();
	}
}