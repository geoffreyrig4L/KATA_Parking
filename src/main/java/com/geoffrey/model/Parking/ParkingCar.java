package com.geoffrey.model.Parking;

import com.geoffrey.model.Vehicles.Car;

import java.time.LocalDateTime;

public class ParkingCar extends Parking{

//si il y a de la place le vehicule se gare
    public static String canYouParkYourCar(Car car){
        String result = "Parking plein !";
        if(car.getPlaces()<=10){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = car.getPlaces() + 1;
            car.setPlaces(newNumberVehicules);
            //car.setCheckin(LocalDateTime.now());System.out.println(car.checkin);
        }
        return result;
    }

//le conducteur procede au payement
    public static float checkPayedForCar(Car car){
        car.toPayPrice();
        car.toPaySecurity();
        return car.getPrice();
    }

    public static void carWantToLeave(Car car){
        car.setCheckout(LocalDateTime.now());
    }

//Si le vehicule a paye, elle sort et laisse une place libre
    public static String carOut(Car car) {
        String result = "Vous n'avez pas paye le stationnement.";
        if(car.getPayedPrice()){
            if(car.getPayedSecurity()) {
                int newNumberVehicules = car.getPlaces() - 1;
                car.setPlaces(newNumberVehicules);
                result = "Le vehicule sort...";
            } else {
                result = "Vous n'avez pas regle le tarif pour la video surveillance votre voiture.";
            }
        }
        return result;
    }
}
