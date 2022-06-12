package com.spring.recrutement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.recrutement.model.Cellule;

public interface CelluleRepo extends JpaRepository<Cellule,Long>{
    
    //@Query("SELECT * FROM Cellule c RIGHT INNER JOIN siteRadio ON c.id = table2.fk_id")
    @Query(value =  "SELECT * FROM cellule WHERE cellule.site_radio_id ISNULL" , nativeQuery = true)
    Optional<List<Cellule>> findCelluleUnrelatedWithSite();

    void deleteCelluleById(Long id) ;

    

}
