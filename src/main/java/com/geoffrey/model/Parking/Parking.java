package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Vehicles.Moto;
import com.geoffrey.model.Vehicles.Scooter;
import com.geoffrey.model.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class Parking {

    //List<TypePlace>

    //si il y a de la place le vehicule se gare
    public static String canYouPark(Vehicle vehicle){
        if(vehicle.getPlaces()<= getPlaceNumber(vehicle)){
            int newNumberVehicules = vehicle.getPlaces() + 1;
            vehicle.setPlaces(newNumberVehicules);
            return "Vous pouvez vous garer.";
            //vehicle.setCheckin(LocalDateTime.now());System.out.println(vehicle.checkin);
        }
        return "Parking plein !";
    }

    private static int getPlaceNumber(Vehicle vehicle){
        if(vehicle instanceof Car){
            return 10;
        }
        if (vehicle instanceof Moto) {
           return 3;
        }
        if (vehicle instanceof Scooter) {
            return 6;
        }
        return 0;
    }

    //le conducteur procede au payement
    public static float checkPayed(Vehicle vehicle){
        vehicle.toPayPrice();
        vehicle.toPaySecurity();
        return vehicle.getPrice();
    }

    public static void WantToLeave(Vehicle vehicle){
        vehicle.setCheckout(LocalDateTime.now());
    }

    //Si le vehicule a paye, elle sort et laisse une place libre
    public static String canYouOut(Vehicle vehicle) {
        if(vehicle.getPayedPrice()){
            if(vehicle.getPayedSecurity()) {
                int newNumberVehicules = vehicle.getPlaces() - 1;
                vehicle.setPlaces(newNumberVehicules);
                return "Le vehicule sort...";
            } else {
                return "Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.";
            }
        }
        return "Vous n'avez pas paye le stationnement.";
    }

    /*public static Duration calculateDuration(LocalDateTime checkin, LocalDateTime checkout){
        return Duration.between(checkin, checkout);
    }*/
}
