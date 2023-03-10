package com.epf.rentmanager.model;
import java.time.LocalDate;

public class Client {

    private long id;
    private String prenom;
    private String nom;
    private String email;
    private LocalDate naissance;

    public Client (long id, String nom, String prenom, String email, LocalDate naissance){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.naissance = naissance;

    }

    public Client (String nom, String prenom, String email){
        this.id = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.naissance = LocalDate.now();

    }

    public Client (long id, String nom, String prenom, String email){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.naissance = LocalDate.now();

    }
    public Client () {
        this (0,"prenom", "nom", "email", LocalDate.parse("31/10/2000"));
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", naissance=" + naissance +
                '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
