package com.spring.recrutement.payload;

import java.util.Set;

public class SiteRadioRequest {
    private Long id ;
    private String access ;
    private String fournisseur ;
    private String HBA ;
    private String site ;
    private String surfaceDisponible ;
    private String surfaceSite ;
    private String surfaceUtilise ;
    private String technologie ;
    private String typeStation ;
    private String date_mise_en_service ;
    private String loyer_actuel ;
    private String locateur ;
    private Set<Long> cellules_id ;
    private String gouvernement ;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccess() {
        return access;
    }
    public void setAccess(String access) {
        this.access = access;
    }
    public String getFournisseur() {
        return fournisseur;
    }
    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }
    public String getHBA() {
        return HBA;
    }
    public void setHBA(String hBA) {
        HBA = hBA;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public String getSurfaceDisponible() {
        return surfaceDisponible;
    }
    public void setSurfaceDisponible(String surfaceDisponible) {
        this.surfaceDisponible = surfaceDisponible;
    }
    public String getSurfaceSite() {
        return surfaceSite;
    }
    public void setSurfaceSite(String surfaceSite) {
        this.surfaceSite = surfaceSite;
    }
    public String getSurfaceUtilise() {
        return surfaceUtilise;
    }
    public void setSurfaceUtilise(String surfaceUtilise) {
        this.surfaceUtilise = surfaceUtilise;
    }
    public String getTechnologie() {
        return technologie;
    }
    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }
    public String getTypeStation() {
        return typeStation;
    }
    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }
    public String getDate_mise_en_service() {
        return date_mise_en_service;
    }
    public void setDate_mise_en_service(String date_mise_en_service) {
        this.date_mise_en_service = date_mise_en_service;
    }
    public String getLoyer_actuel() {
        return loyer_actuel;
    }
    public void setLoyer_actuel(String loyer_actuel) {
        this.loyer_actuel = loyer_actuel;
    }
    public String getLocateur() {
        return locateur;
    }
    public void setLocateur(String locateur) {
        this.locateur = locateur;
    }
    public Set<Long> getCellules_id() {
        return cellules_id;
    }
    public void setCellules_id(Set<Long> cellules_id) {
        this.cellules_id = cellules_id;
    }
    public String getGouvernement() {
        return gouvernement;
    }
    public void setGouvernement_id(String gouvernement_id) {
        this.gouvernement = gouvernement_id;
    }

    
}
