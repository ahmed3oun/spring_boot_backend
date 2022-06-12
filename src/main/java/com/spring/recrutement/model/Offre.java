package com.spring.recrutement.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Offre")
public class Offre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    // relation many to one Gouvernement
    @ManyToOne
    private Gouvernement Gouvernement;

    // relation many to one projet
    @ManyToOne
    private Projet projet;

    @Column
    private String profil ;
    private int nb_etp ;
    private int dispo ;
    private int proba ;
    private Date date_demarrage ;
    private Date date_soumission ;
    private int durée_mission ;
    private String statut ;
    private int tjm ;
    private String commentaire ;

    // relation many to one candidature
    @OneToMany(mappedBy = "offre")
    Set<Candidature> candidature;




    public Offre() {
    }

    public Offre(long id, Gouvernement Gouvernement, Projet projet, String profil, int nb_etp, int dispo, int proba, Date date_demarrage, Date date_soumission, int durée_mission, String statut, int tjm , String commentaire) {
        this.id = id;
        this.Gouvernement = Gouvernement;
        this.projet = projet;
        this.profil = profil;
        this.nb_etp = nb_etp;
        this.dispo = dispo;
        this.proba = proba;
        this.date_demarrage = date_demarrage;
        this.date_soumission = date_soumission;
        this.durée_mission = durée_mission;
        this.statut = statut;
        this.tjm = tjm;
        this.commentaire = commentaire ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gouvernement getGouvernement() {
        return Gouvernement;
    }

    public void setGouvernement(Gouvernement Gouvernement) {
        this.Gouvernement = Gouvernement;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public int getNb_etp() {
        return nb_etp;
    }

    public void setNb_etp(int nb_etp) {
        this.nb_etp = nb_etp;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public int getProba() {
        return proba;
    }

    public void setProba(int proba) {
        this.proba = proba;
    }

    public Date getDate_demarrage() {
        return date_demarrage;
    }

    public void setDate_demarrage(Date date_demarrage) {
        this.date_demarrage = date_demarrage;
    }

    public Date getDate_soumission() {
        return date_soumission;
    }

    public void setDate_soumission(Date date_soumission) {
        this.date_soumission = date_soumission;
    }

    public int getDurée_mission() {
        return durée_mission;
    }

    public void setDurée_mission(int durée_mission) {
        this.durée_mission = durée_mission;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getTjm() {
        return tjm;
    }

    public void setTjm(int tjm) {
        this.tjm = tjm;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", Gouvernement=" + Gouvernement +
                ", projet=" + projet +
                ", profil='" + profil + '\'' +
                ", nb_etp=" + nb_etp +
                ", dispo=" + dispo +
                ", proba=" + proba +
                ", date_demarrage=" + date_demarrage +
                ", date_soumission=" + date_soumission +
                ", durée_mission=" + durée_mission +
                ", statut='" + statut + '\'' +
                ", tjm=" + tjm +
                ", commentaire=" + commentaire +
                '}';
    }
}
