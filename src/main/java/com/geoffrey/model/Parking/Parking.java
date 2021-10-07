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

    // -------------------------------------- METHODE SOUVENT UTILISE --------------------------------------

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

    // -------------------------------------- METHODE FONCTIONNELLE --------------------------------------

    //si il y a de la place le vehicule se gare
    public String canYouPark(Vehicle vehicle) {
        String typeVehicle = distinctVehicle(vehicle);
        TypePark theGoodType = selectTheGoodType(typeVehicle);
        boolean acceptPark = theGoodType.park();
        if (acceptPark) {
            return "Vous pouvez vous garer.";
        }
        return "Parking plein !";
    }

    /*
    //Si le vehicule a paye, elle sort et laisse une place libre
    public String canYouOut(Vehicle vehicle) {
        if (vehicle.getPayedPrice()) {
            if (vehicle.getPayedSecurity()) {
                String typeVehicle = distinctVehicle(vehicle);
                TypePark theGoodType = selectTheGoodType(typeVehicle);
                boolean acceptPark = theGoodType.park();
                return "Le vehicule sort...";
            } else {
                return "Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.";
            }
        }
        return "Vous n'avez pas paye le stationnement.";
    }*/

    public String canYouOut(Vehicle vehicle, PaymentModule paymentModule) {
        if (paymentModule.getVehiclePayed().containsKey(vehicle)) {
            return "Vous pouvez sortir.";
        }
        return "Vous n'avez pas paye le stationnement.";
    }
}
