package com.spring.recrutement.repo;

import com.spring.recrutement.model.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnologieRepo extends JpaRepository<Technologie, Long> {
    Optional<Technologie> findTechnologieById(Long id);

    void deleteTechnologieById(Long id);
}
