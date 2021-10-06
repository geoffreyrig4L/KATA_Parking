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

    // -------------------------------------- METHODE SOUVENT UTILISE --------------------------------------

    //a utilse quand un vehicule entre ou sort
    private void changeCurrentCapacityByOne(TypePark theGoodType, boolean moreOrLess) {
        int newCurrentCapacity = theGoodType.getCurrentCapacity();
        if(moreOrLess)  // true for +1
        {
            newCurrentCapacity += 1;
            theGoodType.setCurrentCapacity(newCurrentCapacity);
        }else{ //false for -1
            newCurrentCapacity -= 1;
            theGoodType.setCurrentCapacity(newCurrentCapacity);
        }
    }

    //retourne la capacité actuelle d'un type de parking
    private int getCurrentCapacityForOneTypePark(TypePark oneTypePark) {
        int capacity = oneTypePark.getCapacity();
        int currentCapacity = oneTypePark.getCurrentCapacity() + 1;
        int gap = capacity-currentCapacity;
        if(gap>=0) {
            System.out.println("Il reste " + gap + " places de '" + oneTypePark.getForWho() + "'.");
        }
        return currentCapacity;
    }

    public TypePark selectTheGoodType(String name){
        for(TypePark oneTypePark : parks) {
            if (oneTypePark.getForWho().equals(name)) {
                return oneTypePark;
            }
        }
        System.out.println("ERREUR !!! Parking incorrect !!!");
        return parks.get(0);
    }

    //distingue le type de vehicule
    public String distinctVehicle(Vehicle vehicle){
        if(vehicle instanceof Car){
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
    public String canYouPark(Vehicle vehicle){
        String typeVehicle = distinctVehicle(vehicle);
        TypePark theGoodType = selectTheGoodType(typeVehicle);
        int currentCapacity = getCurrentCapacityForOneTypePark(theGoodType);
        for(TypePark oneType : parks){
            if(oneType.getCapacity() > currentCapacity){
                changeCurrentCapacityByOne(oneType,true);
                return "Vous pouvez vous garer.";
            }
        }
        return "Parking plein !";
    }

    //Si le vehicule a paye, elle sort et laisse une place libre
    public String canYouOut(Vehicle vehicle) {
        if(vehicle.getPayedPrice()){
            if(vehicle.getPayedSecurity()) {
                String typeVehicle = distinctVehicle(vehicle);
                TypePark theGoodType = selectTheGoodType(typeVehicle);
                changeCurrentCapacityByOne(theGoodType, false);
                return "Le vehicule sort...";
            } else {
                return "Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.";
            }
        }
        return "Vous n'avez pas paye le stationnement.";
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

    public List<TypePark> getParks() {return parks;}

    /*public static Duration calculateDuration(LocalDateTime checkin, LocalDateTime checkout){
        return Duration.between(checkin, checkout);
    }*/
}
