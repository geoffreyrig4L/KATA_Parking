package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.Parking;
import com.geoffrey.Vehicules.model.Vehicules;
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
        Vehicules vehicule = new Vehicules("Motos",5,true,10);
        Parking parking = new Parking(10,11,7);
        String result = Parking.vehiculeSort(vehicule,parking);
        assertEquals("La moto sort...", result);
    }

    @Test
    void should_out_scooter(){
        Vehicules vehicule = new Vehicules("Scooters",5,true,10);
        Parking parking = new Parking(10,11,7);
        String result = Parking.vehiculeSort(vehicule,parking);
        assertEquals("Le scooter sort...", result);
    }

    @Test
    void should_out_voiture(){
        Vehicules vehicule = new Vehicules("Voitures",5,true,10);
        Parking parking = new Parking(10,11,7);
        String result = Parking.vehiculeSort(vehicule,parking);
        assertEquals("La voiture sort...", result);
    }

    @Test
    void should_pay_moto(){
        Vehicules vehicule = new Vehicules("Motos", 3,false,0);
        float result = Parking.payement(vehicule);
        assertEquals(3, result);
    }

    @Test
    void should_pay_voiture(){
        Vehicules vehicule = new Vehicules("Voitures", 5,false,0);
        float result = Parking.payement(vehicule);
        assertEquals(10, result);
    }

    @Test
    void should_pay_scooter(){
        Vehicules vehicule = new Vehicules("Scooters", 4,false,0);
        float result = Parking.payement(vehicule);
        assertEquals(4, result);
    }
}
