package com.spring.recrutement.repo;

import com.spring.recrutement.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatureRepo extends JpaRepository<Candidature , Long> {
    void deleteCandidatureById(Long id);

    Optional<Candidature> findCandidatureById(Long id);
}
