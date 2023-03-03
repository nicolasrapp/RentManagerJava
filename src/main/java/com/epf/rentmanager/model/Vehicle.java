package com.epf.rentmanager.model;

public class Vehicle {

    private long id;

    private String constructeur;
    private String modele;
    private int nbplace;

    public Vehicle (long id, String constructeur, int nbplace) {
        this.id = id;
        this.constructeur = constructeur;
        this.nbplace = nbplace;
    }

    @Override
    public String toString() {
        return "Vehicle" +
                "id= " + id +
                ", constructeur= " + constructeur +
                ", nbplace= " + nbplace + "\n";
    }

    public Vehicle () {
        this(0, "constructeur", 4);
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getNbplace() {
        return nbplace;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public String getModele() {
        return modele;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

}
