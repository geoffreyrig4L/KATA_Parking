package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class Car extends Vehicle {

    public Car(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price, int places) {
        super(checkin, checkout, payedPrice, payedSecurity, price, places);
    }

    @Override
    public int getPriceHourly(){
        return 2;
    }

}
