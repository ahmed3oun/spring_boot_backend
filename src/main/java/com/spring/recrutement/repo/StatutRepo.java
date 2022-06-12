package com.spring.recrutement.repo;

import com.spring.recrutement.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatutRepo extends JpaRepository <Statut , Long> {
    Optional<Statut> findStatutById(Long id);

    void deleteStatutById(Long id);
}
