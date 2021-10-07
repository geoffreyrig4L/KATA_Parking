package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Vehicles.Scooter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.LocalDateTime;
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
        Scooter scooter = new Scooter();
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter();
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        fillPark(scooterPark);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Parking plein !", result);
    }


    //le vehicule PEUT partir
    @Test
    void should_out_scooter(){
        Scooter scooter = new Scooter();
        scooter.setCheckin(LocalDateTime.now());
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        parking.processCheckout(scooter);
        String result = parking.canYouOut(scooter);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_scooter(){
        Scooter scooter = new Scooter();
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_scooter(){
        Scooter scooter = new Scooter();
        scooter.setCheckin(LocalDateTime.now());
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        parking.processCheckout(scooter);
        scooter.setPaySecurity(false);
        String result = parking.canYouOut(scooter);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }

    //paiement
    @CsvSource({"2021-10-05T10:15:30", "2021-10-05T14:15:30", "2021-10-05T15:15:30"})
    @ParameterizedTest
    void should_pay_car(LocalDateTime hourCheckin){
        Scooter scooter = new Scooter();
        scooter.setCheckin(hourCheckin);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        parking.processCheckout(scooter);
        Duration nbHours = Duration.between(scooter.getCheckin(), scooter.getCheckout());
        float expected = nbHours.toHoursPart() +5;
        float result = scooter.getPrice();
        assertEquals(expected, result);
    }
}
