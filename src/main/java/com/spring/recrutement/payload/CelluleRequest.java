package com.spring.recrutement.payload;

public class CelluleRequest {
    private long id;
    private String nom;
    private String antene;
    private String power;
    private String bande;
    private String bsc;
    private String rnc;
    private String bcch;
    private String tch;
    private String lac;
    private String psc;
    private Long siteRadio;

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

    public Long getSiteRadio() {
        return siteRadio;
    }

    public void setSiteRadio(Long siteRadio) {
        this.siteRadio = siteRadio;
    }

}
