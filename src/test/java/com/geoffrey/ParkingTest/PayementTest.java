package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayementTest {

    @ValueSource(ints = {2,6,5})
    @ParameterizedTest
    void should_pay_voiture(int hours){
        Car voiture = new Car(hours, false, false, 0, 5);
        float expected = 2*hours+5;
        float result = Parking.checkPayed(voiture);
        assertEquals(expected, result);
    }

    @ValueSource(ints = {3,1,4})
    @ParameterizedTest
    void should_pay_moto(int hours){
        Moto moto = new Vehicle(hours, false, true, 0, 5);
        float result = Parking.checkPayed(moto);
        assertEquals(hours, result);
    }

    @ValueSource(ints = {3,0,7})
    @ParameterizedTest
    void should_pay_scooter(int hours){
        Scooter scooter = new Vehicle(hours, false, true, 0, 5);
        float result = Parking.checkPayed(scooter);
        assertEquals(hours, result);
    }
}
