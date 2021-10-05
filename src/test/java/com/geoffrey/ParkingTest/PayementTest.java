package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayementTest {

    /*@ValueSource( ... )
    @ParameterizedTest
    void should_pay_car(LocalDateTime hourCheckin){
        Car car = new Car(hourCheckin, null, false, false, 0, 5);
        ParkingCar.carWantToLeave(car);
        Duration duration = Parking.calculateDuration(hourCheckin, car.getCheckout());
        float expected = 2*duration +5;
        float result = ParkingCar.checkPayedForCar(car);
        assertEquals(expected, result);
    }

    @ValueSource( ... )
    @ParameterizedTest
    void should_pay_two_wheels(int hours){
        Moto moto = new Moto(null, null, false, true, 0, 5);
        float result = ParkingMoto.motoWantToLeave(moto);
        assertEquals(hours, result);
    }*/
}
