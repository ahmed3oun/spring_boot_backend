package com.spring.recrutement.Service;

import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.repo.GouvernementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GouvernementService {

    private  GouvernementRepo gouvernementRepo;

    
    public GouvernementService(GouvernementRepo gouvernementRepo) {
        this.gouvernementRepo = gouvernementRepo;
    }

    public Gouvernement addGouvernement(Gouvernement Gouvernement) {

        return gouvernementRepo.save(Gouvernement);
    }

    public List<Gouvernement> findAllGouvernements() {
        return gouvernementRepo.findAll();
    }

    public Gouvernement updateGouvernement(Gouvernement gouvernement) {
        return gouvernementRepo.save(gouvernement);
    }

    public Gouvernement findGouvernementById(Long id) {
        return gouvernementRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Gouvernement by id " + id + " was not found"));
    }
    public Gouvernement findGouvernementByNom(String nom) {
        return gouvernementRepo.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Gouvernement by nom " + nom + " was not found"));
    }

}
