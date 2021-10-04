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

    public static void vehiculeSort(Parking parking, String type) {
        switch(type){
            case "Motos" :
                parking.placeMotosOccupees -= 1;
                break;
            case "Voitures" :
                parking.placeVoituresOccupees -= 1;
                break;
            case "Scooters" :
                parking.placeScootersOccupees -= 1;
                break;
        }
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
