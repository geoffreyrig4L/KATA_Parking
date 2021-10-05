package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public abstract class Vehicle {

    protected double durationToPay;
    protected LocalDateTime checkin;
    protected LocalDateTime checkout;
    protected boolean payedPrice;
    protected boolean payedSecurity;
    protected float price;
    protected int places;


    public Vehicle(LocalDateTime checkin, LocalDateTime checkout, boolean payedPrice, boolean payedSecurity, float price, int places) {
        this.durationToPay = 0;
        this.checkin = checkin;
        this.checkout = checkout;
        this.payedPrice = payedPrice;
        this.payedSecurity = payedSecurity;
        this.price = price;
        this.places = places;
    }

    public abstract int getPriceHourly();

    public void toPayPrice(){
        if(!this.payedPrice){
            this.price += this.getPriceHourly() * this.durationToPay;
            this.setPayPrice(true);
        }
    }

    public void toPaySecurity() {
        if (!this.payedSecurity) {
            this.price += 5;
            this.setPaySecurity(true);
        }
    }

    public void setDurationToPay(int newNb){this.durationToPay = newNb;}

    public void setPayPrice(boolean b) {this.payedPrice = b;}

    public void setPaySecurity(boolean b) {this.payedSecurity = b;}

    public float getPrice() {return this.price;}

    public boolean getPayedSecurity(){ return payedSecurity; }

    public int getPlaces() {return this.places;}

    public void setPlaces(int newPlaces) { this.places = newPlaces; }

    public boolean getPayedPrice() { return this.payedPrice; }

    public void setCheckin(LocalDateTime now) { this.checkin = now;}

    public void setCheckout(LocalDateTime now) { this.checkout = now;}

    public int getDurationToPay(){ return this.getDurationToPay(); };

    public LocalDateTime getCheckin() {return this.checkin;}

    public LocalDateTime getCheckout() {return this.checkout;}
}