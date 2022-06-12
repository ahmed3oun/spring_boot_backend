package com.spring.recrutement.Service;

import com.spring.recrutement.model.SiteRadio;
import com.spring.recrutement.repo.SiteRadioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SiteRadioService {
    private final SiteRadioRepo siteRadioRepo;

    @Autowired
    public SiteRadioService(SiteRadioRepo SiteRadioRepo) {
        this.siteRadioRepo = SiteRadioRepo;
    }

    public SiteRadio addSiteRadio(SiteRadio SiteRadio) {

        return siteRadioRepo.save(SiteRadio);
    }

    public List<SiteRadio> findAllSiteRadios() {
        return siteRadioRepo.findAll();
    }

    public SiteRadio updateSiteRadio(SiteRadio SiteRadio) {
        return siteRadioRepo.save(SiteRadio);
    }

    public SiteRadio findSiteRadioById(Long id) {
        return siteRadioRepo.findSiteRadioById(id)
                .orElseThrow(() -> new RuntimeException("SiteRadio by id " + id + " was not found"));
    }

    public void deleteSiteRadio(Long id){
        siteRadioRepo.deleteSiteRadioById(id);
    }
}
