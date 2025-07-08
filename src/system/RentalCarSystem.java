package system;

import car.Car;
import car.CarFactory;
import customer.Customer;
import rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalCarSystem {
    private static RentalCarSystem instance;
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    // Singleton: Private constructor to prevent instantiation
    private RentalCarSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Singleton: Public method to provide global access
    public static RentalCarSystem getInstance() {
        if (instance == null) {
            instance = new RentalCarSystem();
        }
        return instance;
    }

    // Car management methods
    public void addCar(String type, String make, String model, double rentalPricePerDay, int year, String fuelType) {
        Car car = CarFactory.createCar(type, make, model, rentalPricePerDay, year, fuelType);
        cars.add(car);
    }

    public void removeCar(String model) {
        cars.removeIf(car -> car.getModel().equals(model));
    }

    public void listCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // Customer management methods
    public void addCustomer(String name, String email, String phoneNumber, String licenseNumber, String address) {
        Customer customer = new Customer(name, email, phoneNumber, licenseNumber, address);
        customers.add(customer);
    }

    public void listCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Rental management methods
    public void placeRental(String customerName, String carModel, int rentalDays, String rentalDate, boolean insuranceIncluded) {
        Car car = cars.stream().filter(c -> c.getModel().equals(carModel)).findFirst().orElse(null);
        Customer customer = customers.stream().filter(c -> c.getName().equals(customerName)).findFirst().orElse(null);

        if (car != null && customer != null) {
            Rental rental = new Rental(customer, car, rentalDays, rentalDate, insuranceIncluded);
            rentals.add(rental);
            System.out.println("Rental placed: " + rental);
        } else {
            System.out.println("Car or customer not found.");
        }
    }

    public void listRentals() {
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    // Method to show total income from all rentals
    public void showTotalIncome() {
        double totalIncome = 0;
        for (Rental rental : rentals) {
            totalIncome += rental.calculateTotalCost();
        }
        System.out.println("Total income from all rentals: $" + totalIncome);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        RentalCarSystem rentalSystem = RentalCarSystem.getInstance();  // Singleton instance

        rentalSystem.addCar("Sedan", "Toyota", "Camry", 50.00, 2020, "Gasoline");
        rentalSystem.addCar("SUV", "Ford", "Explorer", 70.00, 2019, "Diesel");

        Car clonedCar = rentalSystem.cars.get(0).clone();
        System.out.println("Cloned car: " + clonedCar);

        rentalSystem.addCustomer("John Doe", "john@example.com", "555-1234", "B12345678", "123 Main St");
        rentalSystem.addCustomer("Jane Smith", "jane@example.com", "555-5678", "C87654321", "456 Oak St");

        rentalSystem.placeRental("John Doe", "Camry", 3, "2024-10-20", true);
        rentalSystem.placeRental("Jane Smith", "Explorer", 5, "2024-10-21", false);

        rentalSystem.listRentals();
        rentalSystem.showTotalIncome();
    }
}