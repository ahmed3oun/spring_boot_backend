package com.spring.recrutement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "candidature")
@Getter
@Setter
public class Candidature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String code  ;
    private String evaluateur ;
    private Date eo_bd ;
    private Date eo_client ;
    private Date test ;
    private String commentaire ;
    private int eval_com1 ;
    private int eval_com2 ;
    private int eval_com3 ;
    private int eval_com4 ;
    private int eval_com5 ;
    private int eval_com6 ;
    private int eval_com7 ;
    private String commentaire_tech ;
    private int eval_ang ;
    private  int eval_fran ;
    private  String commentaire_ss ;
    private String synthese ;
    private  String conclusion ;
    private String commentaire_conls ;



    // relation many to many ( offre + condidat )
    @ManyToOne
    @JoinColumn(name = "offre_id")
    Offre offre;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    SiteRadio candidat;

    @ManyToOne
    private Statut statut_bd;

    @ManyToOne
    private Statut statut_client;

    @ManyToOne
    private Statut statut_test;

    @ManyToOne
    private Statut statut_glob;

    @ManyToOne
    private Gouvernement Gouvernement1;

    @ManyToOne
    private Gouvernement Gouvernement2;

    @ManyToOne
    private Gouvernement Gouvernement3;

    @ManyToOne
    private Gouvernement Gouvernement4;

    @ManyToOne
    private Gouvernement Gouvernement5;

    @ManyToOne
    private Gouvernement Gouvernement6;

    @ManyToOne
    private Gouvernement Gouvernement7;

    public Candidature() {
    }

    public Candidature(long id, String code, String evaluateur, Date eo_bd, Date eo_client, Date test, String commentaire, int eval_com1, int eval_com2, int eval_com3, int eval_com4, int eval_com5, int eval_com6, int eval_com7, String commentaire_tech, int eval_ang, int eval_fran, String commentaire_ss, String synthese, String conclusion, String commentaire_conclusion, Offre offre, SiteRadio candidat, Statut statut_bd, Statut statut_client, Statut statut_test, Statut statut_glob, Gouvernement Gouvernement1, Gouvernement Gouvernement2, Gouvernement Gouvernement3, Gouvernement Gouvernement4, Gouvernement Gouvernement5, Gouvernement Gouvernement6, Gouvernement Gouvernement7) {
        this.id = id;
        this.code = code;
        evaluateur = evaluateur;
        this.eo_bd = eo_bd;
        this.eo_client = eo_client;
        this.test = test;
        this.commentaire = commentaire;
        this.eval_com1 = eval_com1;
        this.eval_com2 = eval_com2;
        this.eval_com3 = eval_com3;
        this.eval_com4 = eval_com4;
        this.eval_com5 = eval_com5;
        this.eval_com6 = eval_com6;
        this.eval_com7 = eval_com7;
        this.commentaire_tech = commentaire_tech;
        this.eval_ang = eval_ang;
        this.eval_fran = eval_fran;
        this.commentaire_ss = commentaire_ss;
        this.synthese = synthese;
        this.conclusion = conclusion;
        this.commentaire_conls = commentaire_conls;
        this.offre = offre;
        this.candidat = candidat;
        this.statut_bd = statut_bd;
        this.statut_client = statut_client;
        this.statut_test = statut_test;
        this.statut_glob = statut_glob;
        this.Gouvernement1 = Gouvernement1;
        this.Gouvernement2 = Gouvernement2;
        this.Gouvernement3 = Gouvernement3;
        this.Gouvernement4 = Gouvernement4;
        this.Gouvernement5 = Gouvernement5;
        this.Gouvernement6 = Gouvernement6;
        this.Gouvernement7 = Gouvernement7;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", evaluateur='" + evaluateur + '\'' +
                ", eo_bd=" + eo_bd +
                ", eo_client=" + eo_client +
                ", test=" + test +
                ", commentaire='" + commentaire + '\'' +
                ", eval_com1=" + eval_com1 +
                ", eval_com2=" + eval_com2 +
                ", eval_com3=" + eval_com3 +
                ", eval_com4=" + eval_com4 +
                ", eval_com5=" + eval_com5 +
                ", eval_com6=" + eval_com6 +
                ", eval_com7=" + eval_com7 +
                ", commentaire_tech='" + commentaire_tech + '\'' +
                ", eval_ang=" + eval_ang +
                ", eval_fran=" + eval_fran +
                ", commentaire_ss='" + commentaire_ss + '\'' +
                ", synthese='" + synthese + '\'' +
                ", conclusion='" + conclusion + '\'' +
                ", commentaire_conls='" + commentaire_conls + '\'' +
                ", offre=" + offre +
                ", candidat=" + candidat +
                ", statut_bd=" + statut_bd +
                ", statut_client=" + statut_client +
                ", statut_test=" + statut_test +
                ", statut_glob=" + statut_glob +
                ", Gouvernement1=" + Gouvernement1 +
                ", Gouvernement2=" + Gouvernement2 +
                ", Gouvernement3=" + Gouvernement3 +
                ", Gouvernement4=" + Gouvernement4 +
                ", Gouvernement5=" + Gouvernement5 +
                ", Gouvernement6=" + Gouvernement6 +
                ", Gouvernement7=" + Gouvernement7 +
                '}';
    }
}
