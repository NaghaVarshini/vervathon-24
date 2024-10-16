package com.example.demo;



import com.example.demo.model.Experiment;
import com.example.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ExperimentRepository experimentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		experimentRepository.save(new Experiment("Physics Experiment", "Learn about gravity by dropping objects."));
		experimentRepository.save(new Experiment("Chemistry Experiment", "Mix vinegar and baking soda."));
		experimentRepository.save(new Experiment("Biology Experiment", "Observe plant growth under different lights."));
	}
}
