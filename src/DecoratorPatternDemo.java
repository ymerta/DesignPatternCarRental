import car.Car;
import car.Sedan;
import feature.GPSDecorator;
import feature.ChildSeatDecorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a basic car
        Car basicCar = new Sedan("Toyota", "Camry", 50.00, 2020, "Gasoline");

        // Add GPS feature to the car
        Car carWithGPS = new GPSDecorator(basicCar);

        // Add both GPS and Child Seat features
        Car fullyLoadedCar = new ChildSeatDecorator(carWithGPS);

        // Print the rental prices for each configuration
        System.out.println("Basic Car Daily Price: $" + basicCar.getRentalPricePerDay());
        System.out.println("Car with GPS Daily Price: $" + carWithGPS.getRentalPricePerDay());
        System.out.println("Car with GPS and Child Seat Daily Price: $" + fullyLoadedCar.getRentalPricePerDay());
    }
}