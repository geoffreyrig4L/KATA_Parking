package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Vehicles.Scooter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.datatype.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScooterTest {

    //le vehicule PEUT se garer
    @ValueSource(ints = {1,2,3,4,5,6})
    @ParameterizedTest
    void should_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null, false,false,0, nbPlaces);
        String result = Parking.canYouPark(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

    //le vehicule NE PEUT PAS se garer
    @ValueSource(ints = {7,8,9})
    @ParameterizedTest
    void should_not_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null,false,false,0, nbPlaces);
        String result = Parking.canYouPark(scooter);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_scooter(){
        Scooter scooter = new Scooter(null, null,true,true, 10, 10);
        String result = Parking.canYouOut(scooter);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_scooter(){
        Scooter scooter = new Scooter(null, null,false,false, 0, 10);
        String result = Parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_scooter(){
        Scooter scooter = new Scooter(null, null,true,false, 0, 10);
        String result = Parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }

    /*
    //paiement
    @ValueSource(localdatetimes ={'2021-10-05T10:15:30', '2021-10-05T14:15:30', '2021-10-05T15:15:30'})
    @ParameterizedTest
    void should_pay_scooter(LocalDateTime hourCheckin){
        Scooter scooter = new Scooter(hourCheckin, null, false, false, 0, 5);
        Parking.WantToLeave(scooter);
        Duration duration = Parking.calculateDuration(hourCheckin, scooter.getCheckout());
        float expected = duration +5;
        float result = Parking.checkPayed(scooter);
        assertEquals(expected, result);
    }*/
}
