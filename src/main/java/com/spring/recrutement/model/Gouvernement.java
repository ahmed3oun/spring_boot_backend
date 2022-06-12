package com.spring.recrutement.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gouvernement")
public class Gouvernement implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String nom  ;

    

    public Gouvernement() {
    }

    public Gouvernement(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    
}
