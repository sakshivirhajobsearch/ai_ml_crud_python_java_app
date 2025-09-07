package com.ai.ml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//GET     http://localhost:8080/api/data
//POST    http://localhost:8080/api/data
//PUT     http://localhost:8080/api/data/{id}
//DELETE  http://localhost:8080/api/data/{id}

@SpringBootApplication
public class AiMlCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(AiMlCrudApplication.class, args);
	}
}
