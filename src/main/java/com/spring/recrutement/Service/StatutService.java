package com.spring.recrutement.Service;

import com.spring.recrutement.exception.StatutNotFoundException;
import com.spring.recrutement.model.Statut;
import com.spring.recrutement.repo.StatutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatutService {
    private final StatutRepo statutRepo;

    @Autowired
    public StatutService(StatutRepo statutRepo) {
        this.statutRepo = statutRepo;
    }

    public Statut addStatut(Statut statut) {

        return statutRepo.save(statut);
    }

    public List<Statut> findAllStatuts() {
        return statutRepo.findAll();
    }

    public Statut updateStatut(Statut statut) {
        return statutRepo.save(statut);
    }

    public Statut findStatutById(Long id) {
        return statutRepo.findStatutById(id)
                .orElseThrow(() -> new StatutNotFoundException("Statut by id " + id + " was not found"));
    }

    public void deleteStatut(Long id){
        statutRepo.deleteStatutById(id);
    }

}
