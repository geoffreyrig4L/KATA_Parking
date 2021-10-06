package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.TypePark;
import com.geoffrey.model.Vehicles.Moto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    private void fillPark(TypePark motoPark) {
        motoPark.setCurrentCapacity(motoPark.getCapacity()-1);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null,false,false,0);
        TypePark motoPark = defineNewTypePark("moto",nbPlaces);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouPark(moto);
        assertEquals("Vous pouvez vous garer.", result);
    }

    @ValueSource(ints = {5,10,7,4,2,3})
    @ParameterizedTest
    void should_be_not_park_moto(int nbPlaces){
        Moto moto = new Moto(null, null,false,false,0);
        TypePark motoPark = defineNewTypePark("moto",nbPlaces);
        fillPark(motoPark);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouPark(moto);
        assertEquals("Parking plein !", result);
    }


    //le vehicule PEUT partir
    @Test
    void should_out_moto(){
        Moto moto = new Moto(null, null,true,true, 10);
        TypePark motoPark = defineNewTypePark("moto",10);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouOut(moto);
        assertEquals("Le vehicule sort...", result);
    }

    //le vehicule NE PEUT PAS partir
    @Test
    void should_not_out_moto(){
        Moto moto = new Moto(null, null,false,false, 0);
        TypePark motoPark = defineNewTypePark("moto",10);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouOut(moto);
        assertEquals("Vous n'avez pas paye le stationnement.", result);
    }

    //le vehicule N'A PAS PAYE la video surveillance
    @Test
    void should_not_out_because_security_moto(){
        Moto moto = new Moto(null, null,true,false, 0);
        TypePark motoPark = defineNewTypePark("moto",10);
        Parking parking = defineNewParking(motoPark);
        String result = parking.canYouOut(moto);
        assertEquals("Vous n'avez pas regle le tarif pour la video surveillance votre vehicule.", result);
    }
}
