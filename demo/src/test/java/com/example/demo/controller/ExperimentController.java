package com.example.demo.controller;



import com.example.demo.model.Experiment;
import com.example.demo.repository.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiments")
public class ExperimentController {

    @Autowired
    private ExperimentRepository experimentRepository;

    @GetMapping
    public List<Experiment> getAllExperiments() {
        return experimentRepository.findAll();
    }

    @PostMapping("/{id}/run")
    public ResponseEntity<String> runExperiment(@PathVariable Long id) {
        Experiment experiment = experimentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiment not found"));
        String result = "You ran the " + experiment.getName() + ": " + experiment.getDescription();
        return ResponseEntity.ok(result);
    }
}
