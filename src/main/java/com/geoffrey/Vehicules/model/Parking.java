package com.geoffrey.Vehicules.model;

public class Parking {

    //si il y a de la place le vehicule se gare
    public static String canYouPark(Vehicules vehicule){
        String result = "Parking plein !";
        if(vehicule.getPlaces()<=10){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = vehicule.getPlaces() + 1;
            vehicule.setPlaces(newNumberVehicules);
        }
        return result;
    }

    //le conducteur procede au payement
    public static float checkPayed(Vehicules vehicule){
        vehicule.toPayPrice();
        vehicule.toPaySecurity();
        return vehicule.getPrice();
    }

    //Si la voiture a paye, elle sort et laisse une place libre
    public static String vehiculeOut(Vehicules vehicule) {
        String result = "Vous n'avez pas paye le stationnement.";
        if(vehicule.getPayedPrice()){
            int newNumberVehicules = vehicule.getPlaces() - 1;
            vehicule.setPlaces(newNumberVehicules);
            result = "Le vehicule sort...";
        }
        return result;
    }
}
