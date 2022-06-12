package com.spring.recrutement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cellule")
public class Cellule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nom;
    @Column
    private String antene;
    @Column
    private String power;
    @Column
    private String bande;
    @Column
    private String bsc;
    @Column
    private String rnc;
    @Column
    private String bcch;
    @Column
    private String tch;
    @Column
    private String lac;
    @Column
    private String psc;
    @ManyToOne
    @JoinColumn(name = "site_radio_id")
    private SiteRadio siteRadio;

    public Cellule() {
    }

    public Cellule(long id, String nom, String antene, String power,
            String bande, String bsc, String rnc, String bcch,
            String tch, String lac, String psc, SiteRadio siteRadio) {
        this.id = id;
        this.nom = nom;
        this.antene = antene;
        this.power = power;
        this.bande = bande;
        this.bsc = bsc;
        this.rnc = rnc;
        this.bcch = bcch;
        this.tch = tch;
        this.lac = lac;
        this.psc = psc;
        this.siteRadio = siteRadio;
    }

    public Cellule(String nom, String antene, String power, String bande,
            String bsc, String rnc, String bcch,
            String tch, String lac, String psc, SiteRadio siteRadio) {
        this.nom = nom;
        this.antene = antene;
        this.power = power;
        this.bande = bande;
        this.bsc = bsc;
        this.rnc = rnc;
        this.bcch = bcch;
        this.tch = tch;
        this.lac = lac;
        this.psc = psc;
        this.siteRadio = siteRadio;
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAntene() {
        return antene;
    }

    public void setAntene(String antene) {
        this.antene = antene;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getBande() {
        return bande;
    }

    public void setBande(String bande) {
        this.bande = bande;
    }

    public String getBsc() {
        return bsc;
    }

    public void setBsc(String bsc) {
        this.bsc = bsc;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public String getBcch() {
        return bcch;
    }

    public void setBcch(String bcch) {
        this.bcch = bcch;
    }

    public String getTch() {
        return tch;
    }

    public void setTch(String tch) {
        this.tch = tch;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public SiteRadio getSiteRadio() {
        return siteRadio;
    }

    public void setSiteRadio(SiteRadio siteRadio) {
        this.siteRadio = siteRadio;
    }

}
