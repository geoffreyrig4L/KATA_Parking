package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class Scooter extends TwoWheels {

    public Scooter(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price, int places) {
        super(checkin, checkout, payedPrice, payedSecurity, price, places);
    }
}
