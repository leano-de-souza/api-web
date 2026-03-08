package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long persId;

    private String nom;
    private String prenom;

    public long getPersId() {
        return persId;
    }

    public void setPersId(long persId) {
        this.persId = persId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
