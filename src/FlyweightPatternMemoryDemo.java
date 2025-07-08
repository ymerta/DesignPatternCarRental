import car.Car;
import car.CarFlyweightFactory;

public class FlyweightPatternMemoryDemo {
    public static void main(String[] args) {
        int numberOfCars = 1000;
        Runtime runtime = Runtime.getRuntime();

        // Run garbage collection before measuring memory usage
        runtime.gc();
        long memoryBeforeFlyweight = runtime.totalMemory() - runtime.freeMemory();

        // Creating cars using the Flyweight Pattern
        for (int i = 0; i < numberOfCars; i++) {
            CarFlyweightFactory.getCar("sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        }

        // Run garbage collection again before final measurement
        runtime.gc();
        long memoryAfterFlyweight = runtime.totalMemory() - runtime.freeMemory();

        // Calculate the memory saved using the Flyweight Pattern
        long memorySaved = memoryBeforeFlyweight - memoryAfterFlyweight;

        System.out.println("Memory saved using Flyweight Pattern: " + memorySaved + " bytes");
        System.out.println("Total unique car instances created: " + CarFlyweightFactory.getTotalCarsCreated());
    }
}