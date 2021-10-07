package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public abstract class Vehicle {

    protected long nbHours;
    protected LocalDateTime checkin;
    protected LocalDateTime checkout;
    protected boolean payedPrice;
    protected boolean payedSecurity;
    protected float price;


    public Vehicle() {
        this.nbHours=0;
        this.checkin = null;
        this.checkout = null;
        this.payedPrice = false;
        this.payedSecurity = false;
        this.price = 0;
    }

    public abstract int getPriceHourly();

    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += this.getPriceHourly() * this.nbHours;
            this.setPayPrice(true);
        }
    }

    public void toPaySecurity() {
        if (!this.payedSecurity) {
            this.price += 5;
            this.setPaySecurity(true);
        }
    }

    public void setPayPrice(boolean b) {this.payedPrice = b;}

    public void setPaySecurity(boolean b) {this.payedSecurity = b;}

    public float getPrice() {return this.price;}

    public boolean getPayedSecurity(){ return payedSecurity; }

    public boolean getPayedPrice() { return this.payedPrice; }

    public void setCheckin(LocalDateTime now) { this.checkin = now;}

    public void setCheckout(LocalDateTime now) { this.checkout = now;}

    public LocalDateTime getCheckin() {return this.checkin;}

    public LocalDateTime getCheckout() {return this.checkout;}

    public long getNbHours() {return nbHours;}

    public void setNbHours(long nbHours) {this.nbHours = nbHours;}
}