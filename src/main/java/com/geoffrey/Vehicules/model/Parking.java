package com.geoffrey.Vehicules.model;

public class Parking {

    private int placeVoituresOccupees;
    private int placeScootersOccupees;
    private int placeMotosOccupees;

    public Parking(int nbMotos, int nbVoitures, int nbScooters){
        this.placeMotosOccupees = nbMotos;
        this.placeScootersOccupees = nbScooters;
        this.placeVoituresOccupees = nbVoitures;
    }

    public static String vehiculeEntrantPeutIlSeGarer(Parking parking, String typeVehicule){
        String result = "";
        switch(typeVehicule){
            case "Motos" :
                if(parking.placeMotosOccupees >= 3) {
                    result = "Parking plein !";
                }else{
                    result = "Vous pouvez vous garer";
                    parking.placeMotosOccupees += 1;
                }
                break;
            case "Voitures" :
                if(parking.placeVoituresOccupees >= 10) {
                    result = "Parking plein !";
                }else{
                    result = "Vous pouvez vous garer";
                    parking.placeVoituresOccupees += 1;
                }
                break;
            case "Scooters" :
                if(parking.placeScootersOccupees >= 6) {
                    result = "Parking plein !";
                }else{
                    result = "Vous pouvez vous garer";
                    parking.placeScootersOccupees += 1;
                }
                break;
        }
        return result;
    }

    //Si la voiture a paye, elle sort et laisse une place libre
    public static String vehiculeSort(Vehicules vehicule, Parking parking) {
        String result = "Vous n'avez pas paye le stationnement";
        switch(vehicule.getType()){
            case "Motos" :
                if(vehicule.getAPaye()){
                    parking.placeMotosOccupees -= 1;
                    result = "La moto sort...";
                }
                break;
            case "Voitures" :
                if(vehicule.getAPaye()) {
                    parking.placeVoituresOccupees -= 1;
                    result = "La voiture sort...";
                }
                break;
            case "Scooters" :
                if(vehicule.getAPaye()) {
                    parking.placeScootersOccupees -= 1;
                    result = "Le scooter sort...";
                }
                break;
        }
        return result;
    }


    public static float payement(Vehicules vehicule){
        float prix;
        if(vehicule.getType().equals("Voitures")){
            prix = 2*vehicule.getNbHeures();
        } else {
            prix = 1*vehicule.getNbHeures();
        }
        vehicule.setPrix(prix);
        vehicule.setaPaye(true);
        return prix;
    }

    public int getPlaceVoituresOccupees() {
        return placeVoituresOccupees;
    }

    public int getPlaceScootersOccupees() {
        return placeScootersOccupees;
    }

    public int getPlaceMotosOccupees() {
        return placeMotosOccupees;
    }
}
