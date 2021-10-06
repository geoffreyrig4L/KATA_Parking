package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.Scooter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScooterTest {

    private TypePark defineNewTypePark(String forWho, int nbPlaces){
        TypePark scooterPark = new TypePark(forWho, nbPlaces);
        return scooterPark;
    }

    private Parking defineNewParking(TypePark scooterPark){
        List<TypePark> parks = List.of(scooterPark);
        Parking parking = new Parking(parks);
        return parking;
    }

    private void fillPark(TypePark scooterPark) {
        scooterPark.setCurrentCapacity(scooterPark.getCapacity()-1);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null,false,false,0);
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter(null, null,false,false,0);
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        fillPark(scooterPark);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Parking plein !", result);
    }


    //le vehicule PEUT partir
    @Test
    void should_out_scooter(){
        Scooter scooter = new Scooter(null, null,true,true, 10);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouOut(scooter);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_scooter(){
        Scooter scooter = new Scooter(null, null,false,false, 0);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_scooter(){
        Scooter scooter = new Scooter(null, null,true,false, 0);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }
}
