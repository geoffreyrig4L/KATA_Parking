package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.ParkingScooter;
import com.geoffrey.model.Vehicles.Scooter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScooterTest {

    //le vehicule PEUT se garer
    @ValueSource(ints = {1,2,3,4,5,6})
    @ParameterizedTest
    void should_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null, false,false,0, nbPlaces);
        String result = ParkingScooter.canYouParkYourScooter(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

    //le vehicule NE PEUT PAS se garer
    @ValueSource(ints = {7,8,9})
    @ParameterizedTest
    void should_not_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null,false,false,0, nbPlaces);
        String result = ParkingScooter.canYouParkYourScooter(scooter);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_scooter(){
        Scooter scooter = new Scooter(null, null,true,true, 10, 10);
        String result = ParkingScooter.scooterOut(scooter);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_scooter(){
        Scooter scooter = new Scooter(null, null,false,false, 0, 10);
        String result = ParkingScooter.scooterOut(scooter);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_scooter(){
        Scooter scooter = new Scooter(null, null,true,false, 0, 10);
        String result = ParkingScooter.scooterOut(scooter);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre scooter.", result);
    }

    //paiement
    /*@ValueSource( ... )
    @ParameterizedTest
    void should_pay_scooter(LocalDateTime hourCheckin){
        Scooter scooter = new Scooter(hourCheckin, null, false, false, 0, 5);
        ParkingScooter.scooterWantToLeave(scooter);
        Duration duration = Parking.calculateDuration(hourCheckin, scooter.getCheckout());
        float expected = duration +5;
        float result = ParkingScooter.checkPayedForScooter(scooter);
        assertEquals(expected, result);
    }*/
}
