package com.geoffrey.Vehicules.model;

public class Parking {

    //si il y a de la place le vehicule se gare
    public static String canYouParkYourCar(Car car){
        String result = "Parking plein !";
        if(car.getPlaces()<=10){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = car.getPlaces() + 1;
            car.setPlaces(newNumberVehicules);
        }
        return result;
    }

    public static String canYouParkYourMoto(Moto moto){
        String result = "Parking plein !";
        if(moto.getPlaces()<=3){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = moto.getPlaces() + 1;
            moto.setPlaces(newNumberVehicules);
        }
        return result;
    }

    public static String canYouParkYourScooter(Scooter scooter){
        String result = "Parking plein !";
        if(scooter.getPlaces()<=6){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = scooter.getPlaces() + 1;
            scooter.setPlaces(newNumberVehicules);
        }
        return result;
    }

    //le conducteur procede au payement
    public static float checkPayedForCar(Car car){
        car.toPayPrice();
        car.toPaySecurity();
        return car.getPrice();
    }

    public static float checkPayedForTwoWheels(TwoWheels twoWheels){
        twoWheels.toPayPrice();
        twoWheels.toPaySecurity();
        return twoWheels.getPrice();
    }

    //Si la voiture a paye, elle sort et laisse une place libre
    public static String vehicleOut(Vehicle vehicule) {
        String result = "Vous n'avez pas paye le stationnement.";
        if(vehicule.getPayedPrice()){
            if(vehicule.getPayedSecurity()) {
                int newNumberVehicules = vehicule.getPlaces() - 1;
                vehicule.setPlaces(newNumberVehicules);
                result = "Le vehicule sort...";
            } else {
                result = "Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.";
            }
        }
        return result;
    }
}
