package com.spring.recrutement.controller;

import com.spring.recrutement.Service.GouvernementService;
import com.spring.recrutement.Service.TechnologieService;
import com.spring.recrutement.model.Technologie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologie")
public class TechnologieController {

    private final TechnologieService technologieService;

    public TechnologieController(TechnologieService technologieService) {
        this.technologieService= technologieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Technologie>> getAllTechnologie () {

        List<Technologie> technologies = technologieService.findAllTechnologie();
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Technologie> getTechnologieById (@PathVariable("id") Long id) {
        Technologie technologie = technologieService.findTechnologieById(id);
        return new ResponseEntity<>(technologie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Technologie> addCompetence(@RequestBody Technologie technologie) {
        Technologie newtechnologie = technologieService.addTechnologie(technologie);
        return new ResponseEntity<>( newtechnologie, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Technologie> updateTechnologie(@RequestBody Technologie technologie) {
        Technologie updateTechnologie = technologieService.updateTechnologie(technologie);
        return new ResponseEntity<>(updateTechnologie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTechnologie(@PathVariable("id") Long id) {
        technologieService.deleteTechnologie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
