package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Scooter;
import com.geoffrey.model.Vehicles.TwoWheels;

import java.time.LocalDateTime;

public class ParkingScooter extends Parking {

    public static String canYouParkYourScooter(Scooter scooter) {
        String result = "Parking plein !";
        if (scooter.getPlaces() <= 6) {
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = scooter.getPlaces() + 1;
            scooter.setPlaces(newNumberVehicules);
            scooter.setCheckin(LocalDateTime.now());
        }
        return result;
    }

    public static void motoWantToLeave(Scooter scooter) {
        scooter.setCheckout(LocalDateTime.now());
    }

    public static float checkPayedForTwoWheels(TwoWheels twoWheels) {
        twoWheels.toPayPrice();
        twoWheels.toPaySecurity();
        return twoWheels.getPrice();
    }

    //Si le vehicule a paye, elle sort et laisse une place libre
    public static String scooterOut(Scooter scooter) {
        String result = "Vous n'avez pas paye le stationnement.";
        if (scooter.getPayedPrice()) {
            if (scooter.getPayedSecurity()) {
                int newNumberVehicules = scooter.getPlaces() - 1;
                scooter.setPlaces(newNumberVehicules);
                result = "Le vehicule sort...";
            } else {
                result = "Vous n'avez pas regle le tarif pour la video surveillance votre scooter.";
            }
        }
        return result;
    }
}