import car.Car;
import car.Hatchback;
import car.SUV;
import car.Sedan;

public class ObjectTypePatternDemo {
    public static void main(String[] args) {

        // Create different types of cars
        Car sedan = new Sedan("Toyota", "Camry", 50.00, 2020, "Gasoline");
        Car suv = new SUV("Ford", "Explorer", 70.00, 2019, "Diesel");
        Car hatchback = new Hatchback("Honda", "Civic", 40.00, 2021, "Hybrid");

        System.out.println("Types of Cars and Information:");
        printCarDetails(sedan);
        printCarDetails(suv);
        printCarDetails(hatchback);
    }

    // Print car details in a generic way using polymorphism
    public static void printCarDetails(Car car) {
        System.out.println("Type of car: " + car.getCarType());
        System.out.println("Car Information: " + car.toString());
        System.out.println("----------------------------");
    }
}