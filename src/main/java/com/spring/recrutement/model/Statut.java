package com.spring.recrutement.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "statut")
public class Statut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String  titre ;
    private String type ;



    public Statut() {
    }

    public Statut(long id, String titre) {
        this.id = id;
        this.titre = titre;
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

    @Override
    public String toString() {
        return "Statut{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                '}';
    }
}
