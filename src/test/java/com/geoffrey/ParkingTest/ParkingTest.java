package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {

//le vehicule PEUT se garer

    @ValueSource(ints = {11,12,13,14})
    @ParameterizedTest
    void should_not_be_park_car(int nbPlaces){
        Car car = new Car(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourCar(car);
        assertEquals("Parking plein !", result);
    }

    @ValueSource(ints = {4,5,6})
    @ParameterizedTest
    void should_not_be_park_moto(int nbPlaces){
        Moto moto = new Moto(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourMoto(moto);
        assertEquals("Parking plein !", result);
    }

    @ValueSource(ints = {7,8,9})
    @ParameterizedTest
    void should_not_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourScooter(scooter);
        assertEquals("Parking plein !", result);
    }

//le vehicule NE PEUT PAS se garer

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_car(int nbPlaces){
        Car car = new Car(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourCar(car);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {1,2,3})
    @ParameterizedTest
    void should_be_park_moto(int nbPlaces){
        Moto moto = new Moto(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourMoto(moto);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {1,2,3,4,5,6})
    @ParameterizedTest
    void should_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(5,false,false,0, nbPlaces);
        String result = Parking.canYouParkYourScooter(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

//le vehicule peut il partir ??

    @Test
    void should_out(){
        Car car = new Car(5,true,true, 10, 10);
        String result = Parking.vehicleOut(car);
        assertEquals("Le vehicule sort...", result);
    }

    @Test
    void should_not_out(){
        Moto moto = new Moto(5,false,false, 0, 10);
        String result = Parking.vehicleOut(moto);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    @Test
    void should_not_out_because_security(){
        Scooter scooter = new Scooter(5,true,false, 0, 10);
        String result = Parking.vehicleOut(scooter);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }
}
