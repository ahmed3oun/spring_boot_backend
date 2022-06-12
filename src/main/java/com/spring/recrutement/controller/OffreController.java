package com.spring.recrutement.controller;



import com.spring.recrutement.Service.OffreService;

import com.spring.recrutement.model.Offre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
public class OffreController {
    private final OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Offre>> getAllOffres () {

        List<Offre> offres = offreService.findAllOffres();
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Offre> getOffreById (@PathVariable("id") Long id) {
        Offre offre = offreService.findOffreById(id);
        return new ResponseEntity<>(offre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Offre> addOffre(@RequestBody Offre offre) {
        Offre newOffre = offreService.addOffre(offre);
        return new ResponseEntity<>(newOffre, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Offre> updateOffre(@RequestBody Offre offre) {
        Offre updateOffre = offreService.updateOffre(offre);
        return new ResponseEntity<>(updateOffre, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffre(@PathVariable("id") Long id) {
        offreService.deleteOffre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
