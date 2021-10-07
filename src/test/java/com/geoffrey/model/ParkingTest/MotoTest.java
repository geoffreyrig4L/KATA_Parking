package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.PaymentModule;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.*;
import com.geoffrey.model.Vehicles.Moto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {


    private TypePark defineNewTypePark(String forWho, int nbPlaces){
        TypePark motoPark = new TypePark(forWho, nbPlaces);
        return motoPark;
    }

    private Parking defineNewParking(TypePark motoPark){
        List<TypePark> parks = List.of(motoPark);
        Parking parking = new Parking(parks);
        return parking;
    }

    private PaymentModule defineNewPaymentModule(Moto moto, LocalDateTime hourCheckin){
        HashMap<Vehicle,LocalDateTime> vehiclesMustPay = new HashMap<>();
        PaymentModule paymentModule = new PaymentModule(vehiclesMustPay);
        paymentModule.vehiculeEnter(moto,hourCheckin);   //ajoute le vehicle dans vehiclesMustPay
        return paymentModule;
    }

    private void fillPark(TypePark motoPark) {
        motoPark.setCurrentCapacity(motoPark.getCapacity()-1);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_moto(int nbPlaces){
        Moto moto = new Moto("123456");
        TypePark motoPark = defineNewTypePark("moto",nbPlaces);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouPark(moto);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_moto(int nbPlaces){
        Moto moto = new Moto("123456");
        TypePark motoPark = defineNewTypePark("moto",nbPlaces);
        fillPark(motoPark);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouPark(moto);
        assertEquals("Parking plein !", result);
    }

    //le vehicule PEUT partir
    @Test
    void should_out_moto(){
        Moto moto = new Moto("123456");
        PaymentModule paymentModule = defineNewPaymentModule(moto, null);
        TypePark motoPark = defineNewTypePark("moto",10);
        Parking parking = defineNewParking(motoPark);
        paymentModule.toPay(moto);
        String result = parking.canYouOut(moto,paymentModule);
        assertEquals("Vous pouvez sortir.", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_moto(){
        Moto moto = new Moto("123456");
        PaymentModule paymentModule = defineNewPaymentModule(moto, null);
        TypePark motoPark = defineNewTypePark("moto",10);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouOut(moto,paymentModule);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //paiement
    @CsvSource({"2021-10-05T10:00:00", "2021-10-05T14:00:00", "2021-10-05T18:00:00"})
    @ParameterizedTest
    void should_pay_moto(LocalDateTime hourCheckin){
        Moto moto = new Moto("123456");
        PaymentModule paymentModule = defineNewPaymentModule(moto, hourCheckin);
        paymentModule.toPay(moto);
        Duration nbHours = Duration.between(hourCheckin, LocalDateTime.now());
        float expected = nbHours.toHoursPart()+5;
        float result = paymentModule.getVehiclePayed().get(moto);
        assertEquals(expected, result);
    }
}
