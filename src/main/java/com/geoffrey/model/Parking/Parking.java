package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Vehicles.Moto;
import com.geoffrey.model.Vehicles.Scooter;
import com.geoffrey.model.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parking {

    List<TypePark> parks = new ArrayList<>();

    public Parking(List<TypePark> parks) {
        this.parks = parks;
    }

    public TypePark selectTheGoodType(String name) {
        for (TypePark oneTypePark : parks) {
            if (oneTypePark.getForWho().equals(name)) {
                return oneTypePark;
            }
        }
        System.out.println("ERREUR !!! Parking incorrect !!!");
        return parks.get(0);
    }

    //distingue le type de vehicule
    public String distinctVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return "car";
        }
        if (vehicle instanceof Moto) {
            return "moto";
        }
        if (vehicle instanceof Scooter) {
            return "scooter";
        }
        return "any type";
    }

    //si il y a de la place le vehicule se gare
    //appelle les 2 methodes ci-dessus
    public String canYouPark(Vehicle vehicle) {
        String typeVehicle = distinctVehicle(vehicle);
        TypePark theGoodType = selectTheGoodType(typeVehicle);
        boolean acceptPark = theGoodType.park();
        if (acceptPark) {
            return "Vous pouvez vous garer.";
        }
        return "Parking plein !";
    }

    public String canYouOut(Vehicle vehicle, PaymentModule paymentModule) {
        if (paymentModule.getVehiclePayed().containsKey(vehicle)) {
            return "Vous pouvez sortir.";
        }
        return "Vous n'avez pas paye le stationnement.";
    }
}
