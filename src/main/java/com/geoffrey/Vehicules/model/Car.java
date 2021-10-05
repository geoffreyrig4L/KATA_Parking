package com.geoffrey.Vehicules.model;

public class Car extends Vehicle {

    public Car(int nbHours, boolean payedPrice, boolean payedSecurity, float price, int places){
        super(nbHours, payedPrice, payedSecurity, price, places);
    }

    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += 2*this.nbHours;
            this.setPayPrice(true);
        }
    }
}
