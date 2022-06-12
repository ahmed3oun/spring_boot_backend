package com.spring.recrutement.controller;

import com.spring.recrutement.Service.GouvernementService;
import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.repo.GouvernementRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gouvernement")
public class GouvernementController {


    
    @Autowired
    GouvernementService gouvernementService ;
    @Autowired
    GouvernementRepo gouvernementRepo;

    @GetMapping("/all")
    public ResponseEntity<List<Gouvernement>> getAllGouvernements() {
        List<Gouvernement> _gouvernements = new ArrayList<Gouvernement>();
        gouvernementRepo.findAll().forEach(_gouvernements::add);
        return new ResponseEntity<>(_gouvernements, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Gouvernement> getGouvernementById(@PathVariable("id") Long id) {
        Gouvernement Gouvernement = gouvernementService.findGouvernementById(id);
        return new ResponseEntity<>(Gouvernement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gouvernement> addGouvernement(@RequestBody Gouvernement Gouvernement) {
        Gouvernement newGouvernement = gouvernementService.addGouvernement(Gouvernement);
        return new ResponseEntity<>(newGouvernement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Gouvernement> updateGouvernement(@RequestBody Gouvernement Gouvernement) {
        Gouvernement updateGouvernement = gouvernementService.updateGouvernement(Gouvernement);
        return new ResponseEntity<>(updateGouvernement, HttpStatus.OK);
    }

    /*
     * @DeleteMapping("/delete/{id}")
     * public ResponseEntity<?> deleteGouvernement(@PathVariable("id") Long id) {
     * GouvernementService.(id);
     * return new ResponseEntity<>(HttpStatus.OK);
     * }
     */

}
