package com.geoffrey.Vehicules.model;

public class TwoWheels extends Vehicle{

    public TwoWheels(int nbHours, boolean payedPrice, boolean payedSecurity, float price, int places){
        super(nbHours, payedPrice, payedSecurity, price, places);
    }
    public void toPayPrice() {
        if (!this.payedPrice) {
            this.price += this.nbHours;
            this.setPayPrice(true);
        }
    }
}
