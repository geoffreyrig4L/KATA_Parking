package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class PaymentModule {

    private HashMap<Vehicle, LocalDateTime> vehiclesMustPay;
    private HashMap<Vehicle, Float> vehiclesPayed;

    public PaymentModule(HashMap<Vehicle, LocalDateTime> vehiclesMustPay) {
        this.vehiclesMustPay = vehiclesMustPay;
        this.vehiclesPayed = new HashMap<>();
    }

    public void vehicleEnter(Vehicle vehicle, LocalDateTime checkin) {
        if (checkin == null) {
            vehiclesMustPay.put(vehicle, LocalDateTime.now());
        } else {
            vehiclesMustPay.put(vehicle, checkin);
        }
    }

    public Bill toPay(Vehicle vehicle) {
        if (vehiclesMustPay.containsKey(vehicle)) {
            Duration nbHours = computeNbHours(vehicle);
            float price = vehicle.getPriceHourly() * nbHours.toHoursPart() + 5;
            return vehicleHasPayed(vehicle, nbHours, price);
        }
        return null;
    }

    private Bill vehicleHasPayed(Vehicle vehicle, Duration nbHours, float price) {
        vehiclesPayed.put(vehicle, price);
        Bill bill = new Bill(LocalDateTime.now(), vehicle, price, nbHours.toHoursPart());
        System.out.println(bill);
        vehiclesMustPay.remove(vehicle);
        return bill;
    }

    private Duration computeNbHours(Vehicle vehicle) {
        LocalDateTime checkin = vehiclesMustPay.get(vehicle);
        return Duration.between(checkin, LocalDateTime.now());
    }

    public HashMap<Vehicle, Float> getVehiclePayed() {
        return this.vehiclesPayed;
    }
}