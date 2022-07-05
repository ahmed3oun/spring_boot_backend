package com.spring.recrutement.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "User_tbl")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String email ;
    private String username  ;
    private String password ;
    private String imageUrl ;
    private String token ;
    @ManyToOne
    private Role role;


    public User() {
    }

    

    

    public User(String email, String username, String password, String imageUrl, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.role = role;
    }





    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(long id, String email , String username, String password, String imageUrl, Role role , String token) {
        this.id = id;
        this.email = email ;
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.role = role;
        this.token = token ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", token='" + token + '\'' +
                ", role=" + role +
                '}';
    }
}
