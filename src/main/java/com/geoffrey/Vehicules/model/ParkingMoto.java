package com.geoffrey.Vehicules.model;

import java.time.LocalDateTime;

public class ParkingMoto extends Parking {

    public static String canYouParkYourMoto(Moto moto){
        String result = "Parking plein !";
        if(moto.getPlaces()<=3){
            result = "Vous pouvez vous garer.";
            int newNumberVehicules = moto.getPlaces() + 1;
            moto.setPlaces(newNumberVehicules);
            moto.setCheckin(LocalDateTime.now());
        }
        return result;
    }

    public static void motoWantToLeave(Moto moto){
        moto.setCheckout(LocalDateTime.now());
    }

    public static float checkPayedForTwoWheels(TwoWheels twoWheels){
        twoWheels.toPayPrice();
        twoWheels.toPaySecurity();
        return twoWheels.getPrice();
    }

    //Si le vehicule a paye, elle sort et laisse une place libre
    public static String motoOut(Moto moto) {
        String result = "Vous n'avez pas paye le stationnement.";
        if(moto.getPayedPrice()){
            if(moto.getPayedSecurity()) {
                int newNumberVehicules = moto.getPlaces() - 1;
                moto.setPlaces(newNumberVehicules);
                result = "Le vehicule sort...";
            } else {
                result = "Vous n'avez pas regle le tarif pour la video surveillance votre moto.";
            }
        }
        return result;
    }
}
