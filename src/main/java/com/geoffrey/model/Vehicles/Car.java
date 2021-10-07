package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class Car extends Vehicle {

    public Car() {
        super();
    }

    @Override
    public int getPriceHourly(){
        return 2;
    }

}
