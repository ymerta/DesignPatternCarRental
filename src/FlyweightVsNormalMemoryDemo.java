import car.Car;
import car.CarFlyweightFactory;
import car.Sedan;

public class FlyweightVsNormalMemoryDemo {
    public static void main(String[] args) {
        int numberOfCars = 1000;
        Runtime runtime = Runtime.getRuntime();

        // Trigger garbage collection before measuring memory
        runtime.gc();
        long memoryBeforeFlyweight = runtime.totalMemory() - runtime.freeMemory();

        // Create cars using the Flyweight Pattern
        for (int i = 0; i < numberOfCars; i++) {
            CarFlyweightFactory.getCar("sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        }

        // Measure memory after Flyweight car creation
        runtime.gc();
        long memoryAfterFlyweight = runtime.totalMemory() - runtime.freeMemory();
        long flyweightMemoryUsage = memoryAfterFlyweight - memoryBeforeFlyweight;

        System.out.println("Memory usage with Flyweight Pattern: " + flyweightMemoryUsage + " bytes");
        System.out.println("Total cars created using Flyweight: " + CarFlyweightFactory.getTotalCarsCreated());

        // Measure memory before creating normal car objects
        runtime.gc();
        long memoryBeforeNormal = runtime.totalMemory() - runtime.freeMemory();

        // Create cars without Flyweight (normal object instantiation)
        for (int i = 0; i < numberOfCars; i++) {
            new Sedan("Toyota", "Camry", 50.00, 2020, "Gasoline");
        }

        // Measure memory after normal object creation
        runtime.gc();
        long memoryAfterNormal = runtime.totalMemory() - runtime.freeMemory();
        long normalMemoryUsage = memoryAfterNormal - memoryBeforeNormal;

        System.out.println("Memory usage without Flyweight Pattern: " + normalMemoryUsage + " bytes");

        // Calculate and display the memory saved by using Flyweight
        long memorySaved = normalMemoryUsage - flyweightMemoryUsage;
        System.out.println("Memory saved using Flyweight Pattern: " + memorySaved + " bytes");
    }
}