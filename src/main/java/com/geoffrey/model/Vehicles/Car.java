package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class Car extends Vehicle {

    public Car(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price, int places) {
        super(checkin, checkout, payedPrice, payedSecurity, price, places);
    }

    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += 2*this.durationToPay;
            this.setPayPrice(true);
        }
    }
}
