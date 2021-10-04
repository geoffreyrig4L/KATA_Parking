package com.geoffrey.Vehicules.model;

public class Voitures extends Vehicules{

    public Voitures(int nbHours, boolean payedPrice, boolean payedSecurity, float price){
        super(nbHours, payedPrice, payedSecurity, price);
    }

    @Override
    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += 2*this.nbHours;
            this.setPayPrice(true);
        }
    }

    private void setPayPrice(boolean b) {
        this.payedPrice = b;
    }
}
