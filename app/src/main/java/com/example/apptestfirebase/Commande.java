package com.example.apptestfirebase;

public class Commande {
    private String Commande;
    private String TypeProduit;
    private String DateLivraison;
    private String Client ;
    private String Consigne ;
    private String key ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Commande() {

    }

    public String getCommande() {
        return Commande;
    }

    public String getTypeProduit() {
        return TypeProduit;
    }

    public String getDateLivraison() {
        return DateLivraison;
    }

    public String getClient() {
        return Client;
    }

    public String getConsigne() {
        return Consigne;
    }


    public void setCommande(String commande) {
        Commande = commande;
    }

    public void setTypeProduit(String typeProduit) {
        TypeProduit = typeProduit;
    }

    public void setDateLivraison(String dateLivraison) {
        DateLivraison = dateLivraison;
    }

    public void setClient(String client) {
        Client = client;
    }

    public void setConsigne(String consigne) {
        Consigne = consigne;
    }
}
