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
    public String toString() {
        return ("\n-FACTURE PARKING- \nDate d'impression : " + dateWriting +
                "\nVotre vehicule : " + vehicle.getRegistrationNb() +
                "\nPrix : " + price +
                "€\nDurée du stationnement : " + nbHours + " heure(s)\n");
    }
}
