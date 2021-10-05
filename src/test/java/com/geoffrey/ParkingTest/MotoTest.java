package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {

    //le vehicule PEUT se garer
    @ValueSource(ints = {1,2,3})
    @ParameterizedTest
    void should_be_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null, false,false,0, nbPlaces);
        String result = ParkingMoto.canYouParkYourMoto(moto);
        assertEquals("Vous pouvez vous garer.", result);
    }

    //le vehicule NE PEUT PAS se garer
    @ValueSource(ints = {4,5,6})
    @ParameterizedTest
    void should_not_be_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null, false,false,0, nbPlaces);
        String result = ParkingMoto.canYouParkYourMoto(moto);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_moto(){
        Moto moto = new Moto(null, null,true,true, 10, 10);
        String result = ParkingMoto.motoOut(moto);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_moto(){
        Moto moto = new Moto(null, null,false,false, 0, 10);
        String result = ParkingMoto.motoOut(moto);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_moto(){
        Moto moto = new Moto(null, null,true,false, 0, 10);
        String result = ParkingMoto.motoOut(moto);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre moto.", result);
    }
}
