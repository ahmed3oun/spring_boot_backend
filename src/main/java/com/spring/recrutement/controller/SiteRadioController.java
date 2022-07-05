package com.spring.recrutement.controller;

import com.spring.recrutement.Service.GouvernementService;
import com.spring.recrutement.Service.SiteRadioService;
import com.spring.recrutement.model.Cellule;
import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.model.SiteRadio;
import com.spring.recrutement.payload.SiteRadioRequest;
import com.spring.recrutement.repo.CelluleRepo;
import com.spring.recrutement.repo.GouvernementRepo;
import com.spring.recrutement.repo.SiteRadioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/siteradio")
public class SiteRadioController {
    @Autowired
    SiteRadioService siteRadioService;
    @Autowired
    SiteRadioRepo siteRadioRepo;
    @Autowired
    CelluleRepo celluleRepo;
    @Autowired
    GouvernementService gouvernementService;
    @Autowired
    GouvernementRepo gouvernementRepo;

    /* @PreAuthorize("hasRole('ADMIN')") */
    @GetMapping("/all")
    public ResponseEntity<List<SiteRadio>> getAllCandidats() {

        List<SiteRadio> siteradios = siteRadioService.findAllSiteRadios();
        siteradios.forEach(_sr -> {
            _sr.getCellules().forEach(cel -> {
                cel.setSiteRadio(null);
            });
        });
        return new ResponseEntity<>(siteradios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SiteRadio> getCandidatById(@PathVariable("id") Long id) {
        // SiteRadio candidat = siteRadioService.findSiteRadioById(id);
        SiteRadio siteRadio = siteRadioRepo.findSiteRadioById(id).get();
        siteRadio.getCellules().forEach(cel -> {
            cel.setSiteRadio(null);
        });
        System.out.println(siteRadio);
        return new ResponseEntity<>(siteRadio, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCandidat(@RequestBody SiteRadioRequest siteRadioRequest) {

        final Gouvernement _gouvernement = gouvernementRepo
                .findByNom(siteRadioRequest.getGouvernement()).get();
        final Set<Cellule> celluleSet = new HashSet<Cellule>();
        final Set<Long> cellules = siteRadioRequest.getCellules_id();
        if (cellules != null) {
            cellules.forEach(cellule_id -> {
                Cellule _cellule = celluleRepo.findById(cellule_id).get();

                celluleSet.add(_cellule);
            });
        }
        final SiteRadio _newSiteRadio = new SiteRadio(siteRadioRequest.getAccess(),
                siteRadioRequest.getFournisseur(),
                siteRadioRequest.getHBA(), siteRadioRequest.getSite(), siteRadioRequest.getSurfaceDisponible(),
                siteRadioRequest.getSurfaceSite(), siteRadioRequest.getSurfaceUtilise(),
                siteRadioRequest.getTechnologie(),
                siteRadioRequest.getTypeStation(), siteRadioRequest.getDate_mise_en_service(),
                siteRadioRequest.getLoyer_actuel(), siteRadioRequest.getLocateur(),
                celluleSet, _gouvernement);

        SiteRadio _siteRadio = siteRadioRepo.save(_newSiteRadio); // =
        if (celluleSet != null) {
            Set<Cellule> setCell = new HashSet<>();
            celluleSet.forEach(cellule -> {

                cellule.setSiteRadio(_newSiteRadio);
                Cellule c = celluleRepo.save(cellule);
                setCell.add(c);
            });
            _siteRadio.setCellules(setCell);
            _siteRadio = siteRadioRepo.save(_siteRadio);
        } // siteRadioService.addSiteRadio(_newSiteRadio);

        return new ResponseEntity<String>("Site Radio Added Successfully !", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SiteRadio> updateCandidat(@RequestBody SiteRadioRequest siteRadioRequest) {
        final Long _id = siteRadioRequest.getId();
        final SiteRadio _siteRadio = siteRadioRepo.findSiteRadioById(_id).get();
        _siteRadio.getCellules().forEach(cel->{
            cel.setSiteRadio(null);
        });
        _siteRadio.setAccess(siteRadioRequest.getAccess());
        if (siteRadioRequest.getDate_mise_en_service() != null) {
            _siteRadio.setDate_mise_en_service(siteRadioRequest.getDate_mise_en_service());
        }
        _siteRadio.setFournisseur(siteRadioRequest.getFournisseur());
        Gouvernement _gouvernement = gouvernementRepo.findByNom(siteRadioRequest.getGouvernement()).get();
        _siteRadio.setGouvernement(_gouvernement);
        _siteRadio.setHBA(siteRadioRequest.getHBA());
        _siteRadio.setLocateur(siteRadioRequest.getLocateur());
        _siteRadio.setLoyer_actuel(siteRadioRequest.getLoyer_actuel());
        _siteRadio.setSite(siteRadioRequest.getSite());
        _siteRadio.setSurfaceDisponible(siteRadioRequest.getSurfaceDisponible());
        _siteRadio.setSurfaceSite(siteRadioRequest.getSurfaceSite());
        _siteRadio.setSurfaceUtilise(siteRadioRequest.getSurfaceUtilise());
        _siteRadio.setTechnologie(siteRadioRequest.getTechnologie());
        _siteRadio.setTypeStation(siteRadioRequest.getTypeStation());
        final Set<Cellule> celluleSet = new HashSet<Cellule>();
        final Set<Long> cellules = siteRadioRequest.getCellules_id();
        if (cellules != null) {
            cellules.forEach(cellule_id -> {
                Cellule _cellule = celluleRepo.findById(cellule_id).get();

                celluleSet.add(_cellule);
            });
            _siteRadio.setCellules(celluleSet);
            if (celluleSet != null) {
                Set<Cellule> setCell = new HashSet<>();
                celluleSet.forEach(cellule -> {
    
                    cellule.setSiteRadio(null);
                    Cellule c = celluleRepo.save(cellule);
                    setCell.add(c);
    
                });
                _siteRadio.setCellules(setCell);
    
            }
        }
        return new ResponseEntity<>(siteRadioRepo.save(_siteRadio), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidat(@PathVariable("id") Long id) {
        // siteRadioService.deleteSiteRadio(id);
        /* SiteRadio _siteRadio = siteRadioRepo.findById(id).get();

        _siteRadio.getCellules().forEach(cel->{
            Cellule _cel = celluleRepo.findById(cel.getId()).get();
            _cel.setSiteRadio(null);
            celluleRepo.save(_cel);
            cel.setSiteRadio(null);
        });
        _siteRadio.setGouvernement(null);
        _siteRadio.setCellules(null);
        siteRadioRepo.save(_siteRadio); */
        siteRadioRepo.deleteSiteRadioById(id);
        return new ResponseEntity<String>("Site radio deleted", HttpStatus.OK);
    }

}
