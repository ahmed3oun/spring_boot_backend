package com.spring.recrutement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "siteRadio")
public class SiteRadio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String access;
    @Column
    private String fournisseur;
    @Column
    private String HBA;
    @Column
    private String site;
    @Column
    private String surfaceDisponible;
    @Column
    private String surfaceSite;
    @Column
    private String surfaceUtilise;
    @Column
    private String technologie;
    @Column
    private String typeStation;
    @Column
    private String date_mise_en_service;
    @Column
    private String loyer_actuel;
    @Column
    private String locateur;
    @ManyToMany/* (mappedBy = "siteRadio", cascade = CascadeType.ALL, orphanRemoval = true) */
    @JoinTable(name = "siteRadio_cellules", joinColumns = @JoinColumn(name = "siteRadio_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cellule_id", referencedColumnName = "id"))
    private Set<Cellule> cellules;
    @ManyToOne
    private Gouvernement gouvernement;

    public long getId() {
        return id;
    }

    public SiteRadio(long id, String access, String fournisseur, String hBA, String site,
            String surfaceDisponible,
            String surfaceSite, String surfaceUtilise, String technologie, String typeStation,
            String date_mise_en_service, String loyer_actuel, String locateur,
            Set<Cellule> cellules, Gouvernement gouvernement) {
        this.id = id;
        this.access = access;
        this.fournisseur = fournisseur;
        HBA = hBA;
        this.site = site;
        this.surfaceDisponible = surfaceDisponible;
        this.surfaceSite = surfaceSite;
        this.surfaceUtilise = surfaceUtilise;
        this.technologie = technologie;
        this.typeStation = typeStation;
        this.date_mise_en_service = date_mise_en_service;
        this.loyer_actuel = loyer_actuel;
        this.locateur = locateur;
        this.cellules = cellules;
        this.gouvernement = gouvernement;
    }

    public SiteRadio(String access, String fournisseur, String hBA, String site, String surfaceDisponible,
            String surfaceSite, String surfaceUtilise, String technologie, String typeStation,
            String date_mise_en_service, String loyer_actuel, String locateur, Set<Cellule> cellules,
            Gouvernement gouvernement) {
        this.access = access;
        this.fournisseur = fournisseur;
        HBA = hBA;
        this.site = site;
        this.surfaceDisponible = surfaceDisponible;
        this.surfaceSite = surfaceSite;
        this.surfaceUtilise = surfaceUtilise;
        this.technologie = technologie;
        this.typeStation = typeStation;
        this.date_mise_en_service = date_mise_en_service;
        this.loyer_actuel = loyer_actuel;
        this.locateur = locateur;
        this.cellules = cellules;
        this.gouvernement = gouvernement;
    }

    public SiteRadio() {
    }

    public Gouvernement getGouvernement() {
        return gouvernement;
    }

    public void setGouvernement(Gouvernement gouvernement) {
        this.gouvernement = gouvernement;
    }

    public void setId(long id) {
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

    public Set<Cellule> getCellules() {
        return cellules;
    }

    public void setCellules(Set<Cellule> cellules) {
        this.cellules = cellules;
    }

}
