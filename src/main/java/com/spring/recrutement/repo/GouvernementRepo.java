package com.spring.recrutement.repo;
import com.spring.recrutement.model.Gouvernement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GouvernementRepo extends JpaRepository<Gouvernement , Long> {
    //Optional<Gouvernement> findGouvernementById(Long id);
    Optional<Gouvernement> findByNom(String nom);

    //@Query(value = "SELECT * FROM gouvernement" , nativeQuery = true)
    //Optional<List<Gouvernement>> getAll();

    
}
