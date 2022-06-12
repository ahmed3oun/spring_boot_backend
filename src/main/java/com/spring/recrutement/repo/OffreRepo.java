package com.spring.recrutement.repo;

import com.spring.recrutement.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OffreRepo extends JpaRepository<Offre , Long> {
    Optional<Offre> findOffreById(Long id);

    void deleteOffreById(Long id);
}
