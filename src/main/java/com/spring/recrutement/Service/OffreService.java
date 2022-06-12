package com.spring.recrutement.Service;

import com.spring.recrutement.exception.OffreNotFoundException;
import com.spring.recrutement.model.Offre;
import com.spring.recrutement.repo.OffreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OffreService {
    private final OffreRepo offreRepo;

    @Autowired
    public OffreService(OffreRepo offreRepo) {
        this.offreRepo = offreRepo;
    }

    public Offre addOffre(Offre offre) {

        return offreRepo.save(offre);
    }

    public List<Offre> findAllOffres() {
        return offreRepo.findAll();
    }

    public Offre updateOffre(Offre offre) {
        return offreRepo.save(offre);
    }

    public Offre findOffreById(Long id) {
        return offreRepo.findOffreById(id)
                .orElseThrow(() -> new OffreNotFoundException("Offre by id " + id + " was not found"));
    }

    public void deleteOffre(Long id){
        offreRepo.deleteOffreById(id);
    }

}
