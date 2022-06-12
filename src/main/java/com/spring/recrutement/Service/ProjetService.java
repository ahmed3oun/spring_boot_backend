package com.spring.recrutement.Service;


import com.spring.recrutement.exception.ProjetNotFoundException;
import com.spring.recrutement.model.Projet;
import com.spring.recrutement.repo.ProjetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjetService {
    private final ProjetRepo projetRepo;

    @Autowired
    public ProjetService(ProjetRepo projetRepo) {
        this.projetRepo = projetRepo;
    }

    public Projet addProjet(Projet projet) {

        return projetRepo.save(projet);
    }

    public List<Projet> findAllProjets() {
        return projetRepo.findAll();
    }

    public Projet updateProjet(Projet projet) {
        return projetRepo.save(projet);
    }

    public Projet findProjetById(Long id) {
        return projetRepo.findProjetById(id)
                .orElseThrow(() -> new ProjetNotFoundException("Projet by id " + id + " was not found"));
    }

    public void deleteProjet(Long id){
        projetRepo.deleteProjetById(id);
    }
}
