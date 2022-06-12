package com.spring.recrutement.Service;

import com.spring.recrutement.exception.CandidatureNotFoundException;
import com.spring.recrutement.model.Candidature;
import com.spring.recrutement.repo.CandidatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CandidatureService {
    private final CandidatureRepo candidatureRepo;

    @Autowired
    public CandidatureService(CandidatureRepo candidatureRepo) {
        this.candidatureRepo = candidatureRepo;
    }

    public Candidature addCandidature(Candidature candidature) {

        return candidatureRepo.save(candidature);
    }

    public List<Candidature> findAllCandidatures() {
        return candidatureRepo.findAll();
    }

    public Candidature updateCandidature(Candidature candidature) {
        return candidatureRepo.save(candidature);
    }

    public Candidature findCandidatureById(Long id) {
        return candidatureRepo.findCandidatureById(id)
                .orElseThrow(() -> new CandidatureNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCandidature(Long id){
        candidatureRepo.deleteCandidatureById(id);
    }

}
