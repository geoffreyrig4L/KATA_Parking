package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Vehicles.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.datatype.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_car(int nbPlaces){
        Car car = new Car(null, null,false,false,0, nbPlaces);
        String result = Parking.canYouPark(car);
        assertEquals("Vous pouvez vous garer.", result);
    }

    //le vehicule PEUT se garer
    @ValueSource(ints = {11,12,13,14})
    @ParameterizedTest
    void should_not_be_park_car(int nbPlaces){
        Car car = new Car(null, null,false,false,0, nbPlaces);
        String result = Parking.canYouPark(car);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_car(){
        Car car = new Car(null, null,true,true, 10, 10);
        String result = Parking.canYouOut(car);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_car(){
        Car car = new Car(null, null,false,false, 0, 10);
        String result = Parking.canYouOut(car);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_car(){
        Car car = new Car(null, null,true,false, 0, 10);
        String result = Parking.canYouOut(car);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }

    /*
    //paiement
    @ValueSource(localdatetimes ={'2021-10-05T10:15:30', '2021-10-05T14:15:30', '2021-10-05T15:15:30'})
    @ParameterizedTest
    void should_pay_car(LocalDateTime hourCheckin){
        Car car = new Car(hourCheckin, null, false, false, 0, 5);
        Parking.carWantToLeave(car);
        Duration duration = Parking.calculateDuration(hourCheckin, car.getCheckout());
        float expected = duration +5;
        float result = Parking.checkPayedForCar(car);
        assertEquals(expected, result);
    }

     */
}
