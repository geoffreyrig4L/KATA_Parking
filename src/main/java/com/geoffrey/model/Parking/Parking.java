package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Vehicles.Moto;
import com.geoffrey.model.Vehicles.Scooter;
import com.geoffrey.model.Vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Parking {

    List<TypePark> parks = new ArrayList<>();

    public Parking(List<TypePark> parks) {
        this.parks = parks;
    }

    //si il y a de la place le vehicule se gare
    public String canYouPark(Vehicle vehicle){
        int currentCapacity = getPlaceNumber(vehicle);
        for(TypePark oneType : parks){
            if(oneType.getCapacity() >= currentCapacity){
                int newNumberVehicules = currentCapacity + 1;
                oneType.setCurrentCapacity(newNumberVehicules);
                return "Vous pouvez vous garer.";
            }
        }
        return "Parking plein !";
    }

    //retourne la capacité actuelle d'un type de parking
    public int getCurrentCapacityForOneTypePark(String name){
        for(TypePark oneTypePark : parks) {
            if (oneTypePark.getForWho().equals(name)) {
                int capacity = oneTypePark.getCapacity();
                int currentCapacity = oneTypePark.getCurrentCapacity() + 1;
                System.out.println("Il reste "+ (capacity-currentCapacity) +" places de '" +oneTypePark.getForWho()+ "'.");
                return currentCapacity;
            }
        }
        return 0;
    }

    //distingue le type de vehicule puis fais appel a la fonction ci dessus
    public int getPlaceNumber(Vehicle vehicle){
        String forWho;
        if(vehicle instanceof Car){
            forWho = "car";
            return getCurrentCapacityForOneTypePark(forWho);
        }
        if (vehicle instanceof Moto) {
            forWho = "moto";
            return getCurrentCapacityForOneTypePark(forWho);
        }
        if (vehicle instanceof Scooter) {
            forWho = "scooter";
            return getCurrentCapacityForOneTypePark(forWho);
        }
        return 0;
    }

    /*

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

    public List<TypePark> getParks() {return parks;}

    /*public static Duration calculateDuration(LocalDateTime checkin, LocalDateTime checkout){
        return Duration.between(checkin, checkout);
    }*/
}
