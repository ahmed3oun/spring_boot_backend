package com.spring.recrutement.controller;
import com.spring.recrutement.Service.StatutService;
import com.spring.recrutement.model.Statut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statut")
public class StatutController {

    private final StatutService statutService;

    public StatutController(StatutService statutService) {
        this.statutService = statutService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Statut>> getAllStatuts () {

        List<Statut> statuts = statutService.findAllStatuts();
        return new ResponseEntity<>(statuts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Statut> getStatutById (@PathVariable("id") Long id) {
        Statut statut = statutService.findStatutById(id);
        return new ResponseEntity<>(statut, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Statut> addStatut(@RequestBody Statut statut) {
        Statut newStatut = statutService.addStatut(statut);
        return new ResponseEntity<>(newStatut, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Statut> updateStatut(@RequestBody Statut statut) {
        Statut updateStatut = statutService.updateStatut(statut);
        return new ResponseEntity<>(updateStatut, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStatut(@PathVariable("id") Long id) {
        statutService.deleteStatut(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
