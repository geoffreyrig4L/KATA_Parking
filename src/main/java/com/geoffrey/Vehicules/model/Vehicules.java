package com.geoffrey.Vehicules.model;

public class Vehicules {

    private String type;
    private int nbHeures;
    private boolean aPayeTarif;
    private boolean aPayeSecurite;
    private float prix;

    public Vehicules(String type, int nbHeures, boolean aPaye, boolean aPayeSecurite, float prix){
        this.type = type ;
        this.nbHeures = nbHeures;
        this.aPayeTarif = aPaye;
        this.aPayeSecurite = aPayeSecurite;
        this.prix = prix;
    }

    public void setaPayeTarif(boolean aPayeTarif) {
        this.aPayeTarif = aPayeTarif;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public boolean getAPaye() {
        return aPayeTarif;
    }

    public float getPrix() {
        return prix;
    }

    public void setAPayeSecurite(boolean b) {
        this.aPayeSecurite = true;
    }

    public boolean getAPayeSecurite() {
        return aPayeSecurite;
    }
}
