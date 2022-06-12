package com.spring.recrutement.repo;
import com.spring.recrutement.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetRepo extends JpaRepository<Projet, Long > {

    Optional<Projet> findProjetById(Long id);

    void deleteProjetById(Long id);
}
