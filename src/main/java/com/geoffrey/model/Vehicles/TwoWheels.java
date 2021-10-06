package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class TwoWheels extends Vehicle{

    public TwoWheels(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price) {
        super(checkin, checkout, payedPrice, payedSecurity, price);
    }

    @Override
    public int getPriceHourly(){
        return 1;
    }
}
