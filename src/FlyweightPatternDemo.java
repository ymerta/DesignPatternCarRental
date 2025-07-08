import car.Car;
import car.CarFlyweightFactory;

public class FlyweightPatternDemo {
    public static void main(String[] args) {
        // The first parameter indicates the car type ("sedan", "suv", or "hatchback")
        Car camry1 = CarFlyweightFactory.getCar("sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        Car camry2 = CarFlyweightFactory.getCar("sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        Car accord = CarFlyweightFactory.getCar("sedan", "Honda", "Accord", 55.00, 2019, "Gasoline");

        // Only 2 unique car instances will be created due to Flyweight pattern reuse
        System.out.println("Total unique car instances created: " + CarFlyweightFactory.getTotalCarsCreated());
    }
}