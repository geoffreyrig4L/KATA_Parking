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
import java.time.LocalDate;
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

    private HashMap<Vehicle, LocalDateTime> defineNewPaymentModele(Car car){
        HashMap<Vehicle, LocalDateTime> vehiclesMustPay = new HashMap<>();
        vehiclesMustPay.put(car,LocalDateTime.now());
        return vehiclesMustPay;
    }

    private void fillPark(TypePark carPark) {
        carPark.setCurrentCapacity(carPark.getCapacity()-1);
    }

    /*
    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_car(int nbPlaces){
        Car car = new Car();
        TypePark carPark = defineNewTypePark("car",nbPlaces);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouPark(car);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_car(int nbPlaces){
        Car car = new Car();
        TypePark carPark = defineNewTypePark("car",nbPlaces);
        fillPark(carPark);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouPark(car);
        assertEquals("Parking plein !", result);
    }


    //le vehicule PEUT partir
    @Test
    void should_out_car(){
        Car car = new Car();
        car.setCheckin(LocalDateTime.now());
        TypePark carPark = defineNewTypePark("car",10);
        Parking parking = defineNewParking(carPark);
        parking.processCheckout(car);
        String result = parking.canYouOut(car);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_car(){
        Car car = new Car();
        TypePark carPark = defineNewTypePark("car",10);
        Parking parking = defineNewParking(carPark);
        String result = parking.canYouOut(car);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_car(){
        Car car = new Car();
        car.setCheckin(LocalDateTime.now());
        TypePark carPark = defineNewTypePark("car",10);
        Parking parking = defineNewParking(carPark);
        parking.processCheckout(car);
        car.setPaySecurity(false);
        String result = parking.canYouOut(car);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }
    */

    //paiement
    @CsvSource({"2021-10-05T10:00:00", "2021-10-05T14:00:00", "2021-10-05T18:00:00"})
    @ParameterizedTest
    void should_pay_car(LocalDateTime hourCheckin){
        Car car = new Car("123456");
        PaymentModule paymentModule = new PaymentModule(defineNewPaymentModele(car));
        paymentModule.vehiculeEnter(car,hourCheckin);
        paymentModule.toPay(car);
        Duration nbHours = Duration.between(hourCheckin, LocalDateTime.now());
        float expected = nbHours.toHoursPart() *2+5;
        HashMap<Vehicle,Float> vehiclePayed = paymentModule.getVehiclePayed();
        float result = vehiclePayed.get(car);
        assertEquals(expected, result);
    }
}
