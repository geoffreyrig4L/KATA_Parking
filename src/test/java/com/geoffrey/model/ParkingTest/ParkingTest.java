package com.geoffrey.model.ParkingTest;

import com.geoffrey.model.Parking.Parking;
import com.geoffrey.model.Parking.TypePark;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParkingTest {

    @Test
    void test() {
        TypePark carPark = new TypePark("car", 3);

        List<TypePark> parks = List.of(carPark);
        Parking parking = new Parking(parks);

        parking.getCurrentCapacityForOneTypePark("car");
    }
}
