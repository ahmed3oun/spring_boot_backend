package com.spring.recrutement.repo;

import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.model.SiteRadio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SiteRadioRepo extends JpaRepository<SiteRadio , Long> {

    void deleteSiteRadioById(Long id);
    
    Optional<SiteRadio> findSiteRadioById(Long id);

    Optional<List<SiteRadio>> findSiteRadioByGouvernement(Gouvernement gouvernement);
}
