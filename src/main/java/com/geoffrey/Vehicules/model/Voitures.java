package com.geoffrey.Vehicules.model;

public class Voitures extends Vehicules{

    public Voitures(int nbHours, boolean payedPrice, boolean payedSecurity, float price, int places){
        super(nbHours, payedPrice, payedSecurity, price, places);
    }

    @Override
    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += 2*this.nbHours;
            this.setPayPrice(true);
        }
    }

    private void setPayPrice(boolean b) {this.payedPrice = b;}
}
