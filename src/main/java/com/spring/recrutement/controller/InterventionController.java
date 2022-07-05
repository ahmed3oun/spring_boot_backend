package com.spring.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.recrutement.model.Intervention;
import com.spring.recrutement.repo.InterventionRepo;

@RestController
@RequestMapping("/intervention")
public class InterventionController {

    @Autowired
    InterventionRepo interventionRepo;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCandidatures() {

        // List<Intervention> intervention =
        // interventionRepo.findAllInterventions().orElseThrow(
        // ()-> new RuntimeException("Something gone wrong"));

        return new ResponseEntity<List<Intervention>>(interventionRepo.findAllInterventions().get(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Intervention> getCandidatureById(@PathVariable("id") Long id) {
        Intervention intervention = interventionRepo.findById(id).get();
        return new ResponseEntity<Intervention>(intervention, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Intervention> addCandidature(@RequestBody Intervention intervention) {
        Intervention _intervention = interventionRepo.save(intervention);
        return new ResponseEntity<>(_intervention, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidature(@PathVariable("id") Long id) {
        interventionRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
