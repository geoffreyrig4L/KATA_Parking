package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class PaymentModule {

    List<Vehicle> vehicles = new ArrayList<>();

    public PaymentModule(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    
}
