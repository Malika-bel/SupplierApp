package com.example.apptestfirebase;

public class Fournisseur {

    int idfournissuer;
    String nom, prenom;

    public Fournisseur(int idEtudiant, String nom, String prenom) {
        this.idfournissuer = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getidfournissuer() {
        return idfournissuer;
    }

    public void setidfournissuer(int idEtudiant) {
        this.idfournissuer = idEtudiant;
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

    public Fournisseur() {

    }
}
