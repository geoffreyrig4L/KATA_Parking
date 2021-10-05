package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
import com.geoffrey.Vehicules.model.Vehicules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {


    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park(int nbPlaces){
        Vehicules vehicule = new Vehicules(5,false,false,0, nbPlaces);
        String result = Parking.canYouPark(vehicule);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {11,12,20,21})
    @ParameterizedTest
    void should_be_not_park(int nbPlaces){
        Vehicules vehicule = new Vehicules(5,false,false,0, nbPlaces);
        String result = Parking.canYouPark(vehicule);
        assertEquals("Parking plein !", result);
    }

    @Test
    void should_out(){
        Vehicules vehicule = new Vehicules(5,true,true, 10, 10);
        String result = Parking.vehiculeOut(vehicule);
        assertEquals("Le vehicule sort...", result);
    }

    @Test
    void should_not_out(){
        Vehicules vehicule = new Vehicules(5,false,false, 0, 10);
        String result = Parking.vehiculeOut(vehicule);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }
}
