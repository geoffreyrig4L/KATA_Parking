package com.geoffrey.ParkingTest;

import com.geoffrey.Vehicules.model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayementTest {

    @ValueSource(ints = {2,6,5})
    @ParameterizedTest
    void should_pay_car(int hours){
        Car car = new Car(hours, false, false, 0, 5);
        float expected = 2*hours+5;
        float result = Parking.checkPayedForCar(car);
        assertEquals(expected, result);
    }

    @ValueSource(ints = {3,1,4})
    @ParameterizedTest
    void should_pay_two_wheels(int hours){
        Moto moto = new Moto(hours, false, true, 0, 5);
        float result = Parking.checkPayedForTwoWheels(moto);
        assertEquals(hours, result);
    }
}
