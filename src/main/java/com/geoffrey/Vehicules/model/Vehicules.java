package com.geoffrey.Vehicules.model;

public class Vehicules {

    protected int nbHours;
    protected boolean payedPrice;
    protected boolean payedSecurity;
    protected float price;
    protected int places ;

    public Vehicules(int nbHours, boolean payedPrice, boolean payedSecurity, float price, int places) {
        this.nbHours = nbHours;
        this.payedPrice = payedPrice;
        this.payedSecurity = payedSecurity;
        this.price = price;
        this.places = places;
    }

    public void toPayPrice() {
        if (!this.payedPrice) {
            this.price += this.nbHours;
            this.setPayPrice(true);
        }
    }

    public void toPaySecurity() {
        if (!this.payedSecurity) {
            this.price += 5;
            this.setPaySecurity(true);
        }
    }

    private void setPayPrice(boolean b) {
        this.payedPrice = b;
    }

    private void setPaySecurity(boolean b) {
        this.payedSecurity = b;
    }

    public int getNbHours() {return nbHours;}

    public float getPrice() {
        return this.price;
    }

    public boolean getPayedSecurity(){ return payedSecurity; }

    public int getPlaces() {return this.places;}

    public void setPlaces(int newPlaces) { this.places = newPlaces; }

    public boolean getPayedPrice() { return this.payedPrice; }
}