import car.Car;
import car.CarFactory;

public class FactoryPatternDemo {
    public static void main(String[] args) {

        // Creating different types of cars using the Factory Pattern
        Car sedan = CarFactory.createCar("Sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        Car suv = CarFactory.createCar("SUV", "Ford", "Explorer", 70.00, 2019, "Diesel");
        Car hatchback = CarFactory.createCar("Hatchback", "Honda", "Civic", 40.00, 2021, "Hybrid");

        System.out.println("----------------------------");

        // Display the created car objects
        System.out.println("Cars created by FactoryPattern: ");
        System.out.println(sedan);
        System.out.println(suv);
        System.out.println(hatchback);

        System.out.println("----------------------------");
    }
}