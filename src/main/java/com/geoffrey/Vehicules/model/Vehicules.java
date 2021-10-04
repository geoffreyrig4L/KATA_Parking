package com.geoffrey.Vehicules.model;

public class Vehicules {

    private String type;
    private int nbHeures;
    private boolean aPaye;
    private float prix;

    public Vehicules(String type, int nbHeures, boolean aPaye, float prix){
        this.type = type ;
        this.nbHeures = nbHeures;
        this.aPaye = aPaye;
        this.prix = prix;
    }

    public void setaPaye(boolean aPaye) {
        this.aPaye = aPaye;
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
        return aPaye;
    }
}
