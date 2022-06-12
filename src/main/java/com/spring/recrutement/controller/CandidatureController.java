package com.spring.recrutement.controller;


import com.spring.recrutement.Service.CandidatureService;
import com.spring.recrutement.model.Candidature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidature")
public class CandidatureController {
    private final CandidatureService candidatureService;

    public CandidatureController(CandidatureService candidatureService) {
        this.candidatureService = candidatureService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidature>> getAllCandidatures () {

        List<Candidature> candidatures = candidatureService.findAllCandidatures();
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidature> getCandidatureById (@PathVariable("id") Long id) {
        Candidature candidature = candidatureService.findCandidatureById(id);
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidature> addCandidature(@RequestBody Candidature candidature) {
        Candidature newCandidature = candidatureService.addCandidature(candidature);
        return new ResponseEntity<>(newCandidature, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Candidature> updateCandidature(@RequestBody Candidature candidature) {
        Candidature updateCandidature = candidatureService.updateCandidature(candidature);
        return new ResponseEntity<>(updateCandidature, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidature(@PathVariable("id") Long id) {
        candidatureService.deleteCandidature(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
