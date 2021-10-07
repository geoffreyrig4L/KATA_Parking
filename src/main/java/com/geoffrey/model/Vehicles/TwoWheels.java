package com.geoffrey.model.Vehicles;

public class TwoWheels extends Vehicle{

    public TwoWheels(String registrationNb) {
        super(registrationNb);
    }

    @Override
    public int getPriceHourly() {
        return 1;
    }
}
