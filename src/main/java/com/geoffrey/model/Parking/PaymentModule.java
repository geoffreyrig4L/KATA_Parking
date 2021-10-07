package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class PaymentModule {

    private HashMap<Vehicle,LocalDateTime> vehiclesMustPay;
    private HashMap<Vehicle,Float> vehiclesPayed;

    public PaymentModule(HashMap<Vehicle,LocalDateTime> vehicles){
        this.vehiclesMustPay = vehicles;
        this.vehiclesPayed = new HashMap<>();
    }

    public void vehiculeEnter(Vehicle vehicle, LocalDateTime checkin) {
        if (!checkin.equals(null)) {
            vehiclesMustPay.put(vehicle, checkin);
        } else {
            vehiclesMustPay.put(vehicle, LocalDateTime.now());
        }
    }

    public void toPay(Vehicle vehicle) {
        if (vehiclesMustPay.containsKey(vehicle)) {
            for (Vehicle oneVehicle : vehiclesMustPay.keySet()) {
                if (vehiclesMustPay.containsKey(vehicle)) {
                    LocalDateTime checkin = vehiclesMustPay.get(oneVehicle);
                    Duration nbHours = Duration.between(checkin, LocalDateTime.now());
                    float price = oneVehicle.getPriceHourly() * nbHours.toHoursPart() + 5;
                    System.out.println(price);
                    vehiclesPayed.put(oneVehicle, price);
                    vehiclesMustPay.remove(oneVehicle, checkin);
                }
            }
        }
    }

    public HashMap<Vehicle, Float> getVehiclePayed() {return this.vehiclesPayed;    }
}