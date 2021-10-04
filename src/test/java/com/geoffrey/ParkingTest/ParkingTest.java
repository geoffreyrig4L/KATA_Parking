package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {

    @ValueSource(strings = {"Motos","Voitures", "Scooters"})
    @ParameterizedTest
    void should_be_check_in(String type){
        Parking parking = new Parking(2,8,3);
        String result = Parking.vehiculeEntrantPeutIlSeGarer(parking,type);
        assertEquals("Vous pouvez vous garer", result);
    }

    @ValueSource(strings = {"Motos","Voitures", "Scooters"})
    @ParameterizedTest
    void should_not_be_check_in(String type){
        Parking parking = new Parking(10,11,7);
        String result = Parking.vehiculeEntrantPeutIlSeGarer(parking,type);
        assertEquals("Parking plein !", result);
    }

    @Test
    void should_out_moto(){
        Parking parking = new Parking(10,11,7);
        int result = parking.getPlaceMotosOccupees() - 1;
        Parking.vehiculeSort(parking,"Motos");
        int expected = parking.getPlaceMotosOccupees();
        assertEquals(expected, result);
    }

    @Test
    void should_out_voiture(){
        Parking parking = new Parking(10,11,7);
        int result = parking.getPlaceVoituresOccupees() - 1;
        Parking.vehiculeSort(parking,"Voitures");
        int expected = parking.getPlaceVoituresOccupees();
        assertEquals(expected, result);
    }

    @Test
    void should_out_scooter(){
        Parking parking = new Parking(10,11,7);
        int result = parking.getPlaceScootersOccupees() - 1;
        Parking.vehiculeSort(parking,"Scooters");
        int expected = parking.getPlaceScootersOccupees();
        assertEquals(expected, result);
    }
}
