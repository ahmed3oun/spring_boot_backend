package com.spring.recrutement.Service;

import com.spring.recrutement.exception.CompetenceNotFoundException;
import com.spring.recrutement.model.Technologie;
import com.spring.recrutement.repo.GouvernementRepo;
import com.spring.recrutement.repo.TechnologieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechnologieService {

    private final TechnologieRepo technologieRepo;

    @Autowired
    public TechnologieService(TechnologieRepo technologieRepo) {
        this.technologieRepo= technologieRepo;
    }

    public Technologie addTechnologie(Technologie technologie) {

        return technologieRepo.save(technologie);
    }

    public List<Technologie> findAllTechnologie() {
        return technologieRepo.findAll();
    }

    public Technologie updateTechnologie(Technologie technologie) {
        return technologieRepo.save(technologie);
    }

    public Technologie findTechnologieById(Long id) {
        return technologieRepo.findTechnologieById(id)
                .orElseThrow(() -> new CompetenceNotFoundException("Technologie by id " + id + " was not found"));
    }

    public void deleteTechnologie(Long id){
        technologieRepo.deleteTechnologieById(id);
    }
}
