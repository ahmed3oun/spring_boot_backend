package com.spring.recrutement.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projet")
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String projet ;
    private String client ;
    private String agence ;
    private String region ;



    public Projet() {
    }

    public java.lang.String getProjet() {
        return projet;
    }

    public void setProjet(java.lang.String projet) {
        this.projet = projet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Projet(String projet , String client, String agence, String region) {
        this.projet = projet;
        this.client = client;
        this.agence = agence;
        this.region = region;
    }

    @Override
    public String toString() {
        return "projet{" +
                "id=" + id +
                ", projet='" + projet + '\'' +
                ", client='" + client + '\'' +
                ", agence='" + agence + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
