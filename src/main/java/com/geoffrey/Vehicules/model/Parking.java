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
    /*
    public static String vehiculeSort(Vehicules vehicule, Parking parking) {
        String result = "Vous n'avez pas paye le stationnement";
        switch(vehicule.getType()){
            case "Motos" :
                if(vehicule.getAPaye()){
                    if(vehicule.getAPayeSecurite()){
                        parking.placeMotosOccupees -= 1;
                        result = "La moto sort...";
                    } else{
                        result = "Vous n'avez pas regle le tarif de la video surveillance pour votre moto";
                    }
                }
                break;
            case "Voitures" :
                if(vehicule.getAPaye()){
                    if(vehicule.getAPayeSecurite()){
                        parking.placeVoituresOccupees -= 1;
                        result = "La voiture sort...";
                    } else{
                        result = "Vous n'avez pas regle le tarif de la video surveillance pour votre voiture";
                    }
                }
                break;
            case "Scooters" :
                if(vehicule.getAPaye()){
                    if(vehicule.getAPayeSecurite()){
                        parking.placeScootersOccupees -= 1;
                        result = "Le scooter sort...";
                    } else{
                        result = "Vous n'avez pas regle le tarif de la video surveillance pour votre scooter";
                    }
                }
                break;
        }
        return result;
    }*/
}
