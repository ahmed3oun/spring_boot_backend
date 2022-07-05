package com.spring.recrutement.repo;

import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.model.SiteRadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SiteRadioRepo extends JpaRepository<SiteRadio , Long> {

    @Query(value = "DELETE FROM siteRadio WHERE id=:id" , nativeQuery = true)
    void deleteSiteRadioById(@Param("id") Long id);
    
    Optional<SiteRadio> findSiteRadioById(Long id);

    Optional<List<SiteRadio>> findSiteRadioByGouvernement(Gouvernement gouvernement);
}
