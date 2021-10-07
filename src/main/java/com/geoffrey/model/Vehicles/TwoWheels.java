package com.geoffrey.model.Vehicles;

import java.time.LocalDateTime;

public class TwoWheels extends Vehicle{

    public TwoWheels() {
        super();
    }

    @Override
    public int getPriceHourly(){
        return 1;
    }
}
