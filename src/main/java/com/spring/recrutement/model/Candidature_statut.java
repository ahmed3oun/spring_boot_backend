package com.spring.recrutement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "candidature_statut")
public class Candidature_statut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String titre  ;
    private Date date ;


    // many to many (statut + candidature)
    @ManyToOne
    @JoinColumn(name = "candidature_id")

    Candidature candidature;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    Statut statut;

    public Candidature_statut() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Candidature_statut(long id, String titre, Date date, Candidature candidature, Statut statut) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.candidature = candidature;
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Candidature_statut{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", date=" + date +
                ", candidature=" + candidature +
                ", statut=" + statut +
                '}';
    }
}
