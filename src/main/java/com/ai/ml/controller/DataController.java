package com.ai.ml.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.ml.entity.DataEntity;
import com.ai.ml.service.DataService;

@RestController
@RequestMapping("/api/data")
public class DataController {

	private final DataService dataService;

	public DataController(DataService dataService) {
		this.dataService = dataService;
	}

	@PostMapping
	public DataEntity saveData(@RequestBody DataEntity dataEntity) {
		return dataService.saveData(dataEntity);
	}

	@GetMapping
	public List<DataEntity> getAllData() {
		return dataService.getAllData();
	}

	@PutMapping("/{id}")
	public DataEntity updateData(@PathVariable Integer id, @RequestBody DataEntity dataEntity) {
		DataEntity existing = dataService.getAllData().stream().filter(d -> d.getId().equals(id)).findFirst()
				.orElseThrow(() -> new RuntimeException("Data not found"));

		existing.setFeature(dataEntity.getFeature());
		existing.setPrediction(dataEntity.getPrediction());

		return dataService.saveData(existing);
	}

	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable Integer id) {
		dataService.getAllData().removeIf(d -> d.getId().equals(id));
		return "Deleted id: " + id;
	}
}