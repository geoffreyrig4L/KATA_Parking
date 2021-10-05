package com.geoffrey.Vehicules.model;

public class Parking {

    //si il y a de la place le vehicule se gare
    public static String canYouPark(Vehicle vehicule){
        String result = "Parking plein !";
        if(vehicule.getPlaces()<=10){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = vehicule.getPlaces() + 1;
            vehicule.setPlaces(newNumberVehicules);
        }
        return result;
    }

    //le conducteur procede au payement
    public static float checkPayed(Vehicle vehicule){
        vehicule.toPayPrice();
        vehicule.toPaySecurity();
        return vehicule.getPrice();
    }

    //Si la voiture a paye, elle sort et laisse une place libre
    public static String vehiculeOut(Vehicle vehicule) {
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
