import com.geoffrey.model.Vehicles.Car;
import com.geoffrey.model.Parking.ParkingCar;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nBonjour, bienvenue au parking du centre commercial !");

        Car car = new Car(null,null,false,false, 5, 6);
        System.out.println(ParkingCar.canYouParkYourCar(car));
    }
}
