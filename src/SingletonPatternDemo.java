import system.RentalCarSystem;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        // There should be only one instance of RentalCarSystem
        RentalCarSystem system1 = RentalCarSystem.getInstance();
        RentalCarSystem system2 = RentalCarSystem.getInstance();

        // Checking if the two samples are the same
        System.out.println("----------------------------");

        System.out.println("Are the two RentalCarSystem samples identical?");
        System.out.println(system1 == system2); // true olmalı

        System.out.println("----------------------------");

        // Adding cars to the system
        system1.addCar("Sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        system1.listCars();
    }
}