package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Vehicle;

import javax.swing.*;
import java.time.LocalDateTime;

public class Bill {

    private final LocalDateTime dateWriting;
    private final Vehicle vehicle;
    private final float price;
    private final int nbHours;

    public Bill(LocalDateTime dateWriting, Vehicle vehicle, float price, int nbHours) {
        this.dateWriting = dateWriting;
        this.vehicle = vehicle;
        this.price = price;
        this.nbHours = nbHours;
    }

    @Override
    public String toString(){
        return ("\n-FACTURE PARKING- \nDate d'impression : " +this.getDateWriting()+
                "\nVotre vehicule : " +this.getVehicle()+
                "\nPrix : " +this.getPrice()+
                "€\nDurée du stationnement : " +this.getNbHours()+" heure(s)\n");
    }

    public LocalDateTime getDateWriting() {
        return dateWriting;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public float getPrice() {
        return price;
    }

    public int getNbHours() {
        return nbHours;
    }
}
