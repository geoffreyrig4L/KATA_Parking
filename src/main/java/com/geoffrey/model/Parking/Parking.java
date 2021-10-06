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

    List<TypePlace> typePlaces = new ArrayList<>();

    //si il y a de la place le vehicule se gare
    public static String canYouPark(Vehicle vehicle){
        if(vehicle.getPlaces()<= getPlaceNumber(vehicle)){
            int newNumberVehicules = vehicle.getPlaces() + 1;
            vehicle.setPlaces(newNumberVehicules);
            return "Vous pouvez vous garer.";
        }
        return "Parking plein !";
    }

    public static int getCapacityFromTypePlaces(String name){
        List<TypePlace> typePlaces = new ArrayList<>();
        for(TypePlace oneTypePlace : typePlaces) {
            if (oneTypePlace.getForWho().equals(name)) {
                return oneTypePlace.capacity;
            }
        }
        return 0;
    }

    public static int getPlaceNumber(Vehicle vehicle){
        String forWho;
        if(vehicle instanceof Car){
            forWho = "car";
            return getCapacityFromTypePlaces(forWho);
        }
        if (vehicle instanceof Moto) {
            forWho = "moto";
            return getCapacityFromTypePlaces(forWho);
        }
        if (vehicle instanceof Scooter) {
            forWho = "scooter";
            return getCapacityFromTypePlaces(forWho);
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

    public List<TypePlace> getTypePlaces() {return typePlaces;}

    /*public static Duration calculateDuration(LocalDateTime checkin, LocalDateTime checkout){
        return Duration.between(checkin, checkout);
    }*/
}
