package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
import com.geoffrey.Vehicules.model.Vehicules;
import com.geoffrey.Vehicules.model.Voitures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayementTest {

    @Test
    void should_pay_voiture(){
        Voitures voiture = new Voitures(5, false, false, 0);
        float result = Parking.checkPayed(voiture);
        assertEquals(15, result);
    }

    @Test
    void should_pay_moto(){
        Vehicules vehicule = new Vehicules(7, false, true, 0);
        float result = Parking.checkPayed(vehicule);
        assertEquals(7, result);
    }

    @Test
    void should_pay_scooter(){
        Vehicules vehicule = new Vehicules(4, false, true, 0);
        float result = Parking.checkPayed(vehicule);
        assertEquals(4, result);
    }
}
