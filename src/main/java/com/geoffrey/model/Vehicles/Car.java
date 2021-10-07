package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class Car extends Vehicle {

    public Car(String registrationNb) {
        super(registrationNb);
    }

    @Override
    public int getPriceHourly() {
        return 2;
    }
}
