package com.spring.recrutement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "intervention")
public class Intervention {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column
    private String problem ;
    @Column
    private String date ;
    @Column
    private String observation ;
    @Column
    private String fullname ;
    @Column
    private String option ;
    
    

    public Intervention(Long id, String problem, String date, String observation, String fullname, String option) {
        this.id = id;
        this.problem = problem;
        this.date = date;
        this.observation = observation;
        this.fullname = fullname;
        this.option = option;
    }

    

    public Intervention(String problem, String date, String observation, String fullname, String option) {
        this.problem = problem;
        this.date = date;
        this.observation = observation;
        this.fullname = fullname;
        this.option = option;
    }



    public Long getId() {
        return id;
    }

    public String getProblem() {
        return problem;
    }

    public String getDate() {
        return date;
    }

    public String getObservation() {
        return observation;
    }

    public String getFullname() {
        return fullname;
    }

    public String getOption() {
        return option;
    }

    


}
