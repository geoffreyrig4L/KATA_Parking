package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public abstract class Vehicle {

    protected String registrationNb;

    public Vehicle(String registrationNb) {
        this.registrationNb=registrationNb;
    }

    public abstract int getPriceHourly();

    public String getRegistrationNb(){return registrationNb; }
}