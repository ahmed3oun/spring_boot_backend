package com.spring.recrutement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "document")
public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    private Gouvernement gouvernement;

    @ManyToOne
    private SiteRadio siteRadio;

    @Column
    private String typeDoc ;

    @Column
    private String fileUrl ;

    
    public Document(){}

    public Document(Gouvernement gouvernement, SiteRadio siteRadio, String typeDoc, String fileUrl) {
        this.gouvernement = gouvernement;
        this.siteRadio = siteRadio;
        this.typeDoc = typeDoc;
        this.fileUrl = fileUrl;
    }


    public Document(Long id, Gouvernement gouvernement, SiteRadio siteRadio, String typeDoc, String fileUrl) {
        this.id = id;
        this.gouvernement = gouvernement;
        this.siteRadio = siteRadio;
        this.typeDoc = typeDoc;
        this.fileUrl = fileUrl;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Gouvernement getgouvernement() {
        return gouvernement;
    }


    public void setgouvernement(Gouvernement gouvernement) {
        this.gouvernement = gouvernement;
    }


    public SiteRadio getSiteRadio() {
        return siteRadio;
    }


    public void setSiteRadio(SiteRadio siteRadio) {
        this.siteRadio = siteRadio;
    }


    public String getTypeDoc() {
        return typeDoc;
    }


    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }


    public String getFileUrl() {
        return fileUrl;
    }


    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    


    
    
}
