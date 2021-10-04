package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
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
}
