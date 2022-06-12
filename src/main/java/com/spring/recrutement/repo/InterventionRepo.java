package com.spring.recrutement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.recrutement.model.Intervention;

public interface InterventionRepo extends JpaRepository<Intervention , Long> {

    void deleteInterventionById(long id) ;

    Optional<Intervention> findInterventionById(long id);
    
}
