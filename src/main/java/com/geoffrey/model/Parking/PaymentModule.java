package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class PaymentModule {

    private HashMap<Vehicle,LocalDateTime> vehiclesMustPay;
    private HashMap<Vehicle,Float> vehiclesPayed;

    public PaymentModule(HashMap<Vehicle,LocalDateTime> vehiclesMustPay){
        this.vehiclesMustPay = vehiclesMustPay;
        this.vehiclesPayed = new HashMap<>();
    }

    public void vehiculeEnter(Vehicle vehicle, LocalDateTime checkin) {
        if (checkin == null) {
            vehiclesMustPay.put(vehicle, LocalDateTime.now());
        } else {
            vehiclesMustPay.put(vehicle, checkin);
        }
    }

    public void toPay(Vehicle vehicle) {
        if (vehiclesMustPay.containsKey(vehicle)) {
            for (Vehicle oneVehicle : vehiclesMustPay.keySet()) {
                if (vehiclesMustPay.containsKey(vehicle)) {
                    LocalDateTime checkin = vehiclesMustPay.get(oneVehicle);
                    Duration nbHours = Duration.between(checkin, LocalDateTime.now());
                    float price = oneVehicle.getPriceHourly() * nbHours.toHoursPart() + 5;
                    vehiclesPayed.put(oneVehicle, price);
                    vehiclesMustPay.remove(oneVehicle, checkin);
                }
            }
        }
    }

    public HashMap<Vehicle, Float> getVehiclePayed() {return this.vehiclesPayed;}
}