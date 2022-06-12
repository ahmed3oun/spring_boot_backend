package com.spring.recrutement.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Technologie")
public class Technologie {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id ;
        @Column
        private String technologie  ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTechnologie() {
        return technologie;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    @Override
        public String toString() {
            return "Technologie{" +
                    "id=" + id +
                    ", Technologie='" + technologie + '\'' +
                    '}';
        }


}
