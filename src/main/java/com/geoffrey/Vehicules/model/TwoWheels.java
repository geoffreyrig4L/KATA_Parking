package com.geoffrey.Vehicules.model;

import java.time.LocalDateTime;

public class TwoWheels extends Vehicle{

    public TwoWheels(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price, int places) {
        super(checkin, checkout, payedPrice, payedSecurity, price, places);
    }

    public void toPayPrice() {
        if (!this.payedPrice) {
            this.price += this.durationToPay;
            this.setPayPrice(true);
        }
    }
}
