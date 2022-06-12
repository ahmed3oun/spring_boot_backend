package com.spring.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.recrutement.model.Cellule;
import com.spring.recrutement.model.SiteRadio;
import com.spring.recrutement.payload.CelluleRequest;
import com.spring.recrutement.repo.CelluleRepo;
import com.spring.recrutement.repo.SiteRadioRepo;

@RestController
@RequestMapping("/cellule")
public class CelluleController {

    @Autowired
    private CelluleRepo celluleRepo;
    @Autowired
    private SiteRadioRepo siteradioRepo;

    @GetMapping("/all")
    public ResponseEntity<List<Cellule>> getAllCellules() {

        List<Cellule> cellules = celluleRepo.findAll();
        cellules.forEach(_cel -> {
            if (_cel.getSiteRadio() != null) {
                /* if (_cel.getSiteRadio().getCellules() != null) {
                    _cel.getSiteRadio().getCellules().forEach(cel -> {
                        cel.setSiteRadio(null);
                    });
                } */
                _cel.getSiteRadio().setCellules(null);
            }
        });
        return new ResponseEntity<>(cellules, HttpStatus.OK);
    }

    @GetMapping("/notUsed")
    public ResponseEntity<List<Cellule>> getAllCellulesNotUsed() {

        List<Cellule> Cellules = celluleRepo.findCelluleUnrelatedWithSite().get();
        return new ResponseEntity<>(Cellules, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCellule(@RequestBody Cellule cellule) {
        Cellule _cellule = celluleRepo.save(cellule);
        if (_cellule != null) {
            return new ResponseEntity<>(_cellule, HttpStatus.CREATED);

        } else {

            return new ResponseEntity<>("l'instance n'est pas crée", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCellule(@RequestBody CelluleRequest celluleRequest,
            @PathVariable("id") Long id) {
        Cellule __cellule = celluleRepo.findById(id).get();
        SiteRadio _siteRadio = null;
        if (celluleRequest.getSiteRadio() != null) {
            _siteRadio = siteradioRepo.findById(celluleRequest.getSiteRadio()).get();
        }
        /*
         * Cellule newCellule = new Cellule(id,
         * celluleRequest.getNom(), celluleRequest.getAntene(),
         * celluleRequest.getPower(),
         * celluleRequest.getBande(), celluleRequest.getBsc(), celluleRequest.getRnc(),
         * celluleRequest.getBcch(), celluleRequest.getTch(), celluleRequest.getLac(),
         * celluleRequest.getPsc(), _siteRadio);
         */
        __cellule.setNom(celluleRequest.getNom());
        __cellule.setAntene(celluleRequest.getAntene());
        __cellule.setPower(celluleRequest.getPower());
        __cellule.setBande(celluleRequest.getBande());
        __cellule.setBsc(celluleRequest.getBsc());
        __cellule.setRnc(celluleRequest.getRnc());
        __cellule.setBcch(celluleRequest.getBcch());
        __cellule.setTch(celluleRequest.getTch());
        __cellule.setLac(celluleRequest.getLac());
        __cellule.setPsc(celluleRequest.getPsc());
        __cellule.setSiteRadio(_siteRadio);

        // cellule.setId(__cellule.getId());
        Cellule _cellule = celluleRepo.save(__cellule);
        // if (_cellule != null) {
        return new ResponseEntity<>(_cellule, HttpStatus.OK);

        /*
         * } else {
         * 
         * return new ResponseEntity<>("l'instance n'est pas modifié",
         * HttpStatus.INTERNAL_SERVER_ERROR);
         * }
         */
    }

}
