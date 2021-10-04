package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
import com.geoffrey.Vehicules.model.Vehicules;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayementTest {

    @Test
    void should_pay_price_moto(){
        Vehicules vehicule = new Vehicules("Motos", 3,false, false, 0);
        float result = Parking.payement_tarifaire(vehicule);
        assertEquals(3, result);
    }

    @Test
    void should_pay_price_voiture(){
        Vehicules vehicule = new Vehicules("Voitures", 5,false, false, 0);
        float result = Parking.payement_tarifaire(vehicule);
        assertEquals(10, result);
    }

    @Test
    void should_pay_price_scooter(){
        Vehicules vehicule = new Vehicules("Scooters", 4,false, false, 0);
        float result = Parking.payement_tarifaire(vehicule);
        assertEquals(4, result);
    }

    @Test
    void should_pay_security(){
        Vehicules vehicule = new Vehicules("Motos", 3,false, false, 0);
        float result = Parking.payement_securite(vehicule);
        assertEquals(5, result);
    }
}
