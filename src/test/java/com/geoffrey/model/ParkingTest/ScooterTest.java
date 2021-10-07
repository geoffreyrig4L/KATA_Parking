package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.PaymentModule;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.Scooter;
import com.geoffrey.model.Vehicles.Scooter;
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

    private PaymentModule defineNewPaymentModule(Scooter scooter, LocalDateTime hourCheckin){
        HashMap<Vehicle,LocalDateTime> vehiclesMustPay = new HashMap<>();
        PaymentModule paymentModule = new PaymentModule(vehiclesMustPay);
        paymentModule.vehiculeEnter(scooter,hourCheckin);   //ajoute le vehicle dans vehiclesMustPay
        return paymentModule;
    }

    private void fillPark(TypePark scooterPark) {
        scooterPark.setCurrentCapacity(scooterPark.getCapacity()-1);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter("123456");
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_scooter(int nbPlaces){
        Scooter scooter = new Scooter("123456");
        TypePark scooterPark = defineNewTypePark("scooter",nbPlaces);
        fillPark(scooterPark);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouPark(scooter);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_scooter(){
        Scooter scooter = new Scooter("123456");
        PaymentModule paymentModule = defineNewPaymentModule(scooter, null);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        paymentModule.toPay(scooter);
        String result = parking.canYouOut(scooter,paymentModule);
        assertEquals("Vous pouvez sortir.", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_scooter(){
        Scooter scooter = new Scooter("123456");
        PaymentModule paymentModule = defineNewPaymentModule(scooter, null);
        TypePark scooterPark = defineNewTypePark("scooter",10);
        Parking parking = defineNewParking(scooterPark);
        String result = parking.canYouOut(scooter,paymentModule);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //paiement
    @CsvSource({"2021-10-05T10:00:00", "2021-10-05T14:00:00", "2021-10-05T18:00:00"})
    @ParameterizedTest
    void should_pay_scooter(LocalDateTime hourCheckin){
        Scooter scooter = new Scooter("123456");
        PaymentModule paymentModule = defineNewPaymentModule(scooter, hourCheckin);
        paymentModule.toPay(scooter);
        Duration nbHours = Duration.between(hourCheckin, LocalDateTime.now());
        float expected = nbHours.toHoursPart()+5;
        float result = paymentModule.getVehiclePayed().get(scooter);
        assertEquals(expected, result);
    }
}
