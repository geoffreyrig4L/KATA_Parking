package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.PaymentModule;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Vehicles.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private TypePark defineNewTypePark(String forWho, int nbPlaces){
        TypePark carPark = new TypePark(forWho, nbPlaces);
        return carPark;
    }

    private Parking defineNewParking(TypePark carPark){
        List<TypePark> parks = List.of(carPark);
        Parking parking = new Parking(parks);
        return parking;
    }

    private PaymentModule defineNewPaymentModule(Car car, LocalDateTime hourCheckin){
        HashMap<Vehicle,LocalDateTime> vehiclesMustPay = new HashMap<>();
        PaymentModule paymentModule = new PaymentModule(vehiclesMustPay);
        paymentModule.vehiculeEnter(car,hourCheckin);   //ajoute le vehicle dans vehiclesMustPay
        return paymentModule;
    }

    private void fillPark(TypePark carPark) {
        carPark.setCurrentCapacity(carPark.getCapacity()-1);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_car(int nbPlaces){
        Car car = new Car("123456");
        TypePark carPark = defineNewTypePark("car",nbPlaces);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouPark(car);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_car(int nbPlaces){
        Car car = new Car("123456");
        TypePark carPark = defineNewTypePark("car",nbPlaces);
        fillPark(carPark);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouPark(car);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_car(){
        Car car = new Car("123456");
        PaymentModule paymentModule = defineNewPaymentModule(car, null);
        TypePark carPark = defineNewTypePark("car",10);
        Parking parking = defineNewParking(carPark);
        paymentModule.toPay(car);
        String result = parking.canYouOut(car,paymentModule);
        assertEquals("Vous pouvez sortir.", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_car(){
        Car car = new Car("123456");
        PaymentModule paymentModule = defineNewPaymentModule(car, null);
        TypePark carPark = defineNewTypePark("car",10);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouOut(car,paymentModule);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //paiement
    @CsvSource({"2021-10-05T10:00:00", "2021-10-05T14:00:00", "2021-10-05T18:00:00"})
    @ParameterizedTest
    void should_pay_car(LocalDateTime hourCheckin){
        Car car = new Car("123456");
        PaymentModule paymentModule = defineNewPaymentModule(car, hourCheckin);
        paymentModule.toPay(car);
        Duration nbHours = Duration.between(hourCheckin, LocalDateTime.now());
        float expected = nbHours.toHoursPart() *2+5;
        float result = paymentModule.getVehiclePayed().get(car);
        assertEquals(expected, result);
    }
}
