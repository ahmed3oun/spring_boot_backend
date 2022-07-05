package com.spring.recrutement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.recrutement.model.Intervention;

@Repository
public interface InterventionRepo extends JpaRepository<Intervention , Long> {

    //void deleteInterventionById(long id) ;

    //Optional<Intervention> findInterventionById(long id);
    @Query(value = "SELECT * FROM intervention" , nativeQuery = true)
    Optional<List<Intervention>> findAllInterventions();
}
