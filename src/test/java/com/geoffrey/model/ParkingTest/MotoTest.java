package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Vehicles.Moto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {

    //le vehicule PEUT se garer
    @ValueSource(ints = {1,2,3})
    @ParameterizedTest
    void should_be_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null, false,false,0, nbPlaces);
        String result = Parking.canYouPark(moto);
        assertEquals("Vous pouvez vous garer.", result);
    }

    //le vehicule NE PEUT PAS se garer
    @ValueSource(ints = {4,5,6})
    @ParameterizedTest
    void should_not_be_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null, false,false,0, nbPlaces);
        String result = Parking.canYouPark(moto);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_moto(){
        Moto moto = new Moto(null, null,true,true, 10, 10);
        String result = Parking.canYouOut(moto);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_moto(){
        Moto moto = new Moto(null, null,false,false, 0, 10);
        String result = Parking.canYouOut(moto);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_moto(){
        Moto moto = new Moto(null, null,true,false, 0, 10);
        String result = Parking.canYouOut(moto);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }

    /*
    //paiement
    @ValueSource(localdatetimes ={'2021-10-05T10:15:30', '2021-10-05T14:15:30', '2021-10-05T15:15:30'})
    @ParameterizedTest
    void should_pay_moto(LocalDateTime hourCheckin){
        Moto moto = new Moto(hourCheckin, null, false, false, 0, 5);
        Parking.motoWantToLeave(moto);
        Duration duration = Parking.calculateDuration(hourCheckin, moto.getCheckout());
        float expected = duration + 5;
        float result = ParkingScooter.checkPayedForTwoWheels(moto);
        assertEquals(expected, result);
    }
     */
}
