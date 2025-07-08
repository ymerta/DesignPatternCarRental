package Large;
import java.util.ArrayList;
import java.util.List;

public class Large {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public Large() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Car management methods
    public void addCar(String make, String model, double rentalPricePerDay, int year, String fuelType) {
        Car car = new Car(make, model, rentalPricePerDay, year, fuelType);
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

    // Car class inside Large
    private class Car {
        private String make;
        private String model;
        private double rentalPricePerDay;
        private int year;
        private String fuelType;

        public Car(String make, String model, double rentalPricePerDay, int year, String fuelType) {
            this.make = make;
            this.model = model;
            this.rentalPricePerDay = rentalPricePerDay;
            this.year = year;
            this.fuelType = fuelType;
        }

        // Car methods
        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public double getRentalPricePerDay() {
            return rentalPricePerDay;
        }

        public int getYear() {
            return year;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setRentalPricePerDay(double newPrice) {
            this.rentalPricePerDay = newPrice;
        }

        public void applyDiscount(double percentage) {
            this.rentalPricePerDay -= (this.rentalPricePerDay * percentage / 100);
        }

        @Override
        public String toString() {
            return year + " " + make + " " + model + " (" + fuelType + ") - $" + rentalPricePerDay + " per day";
        }
    }

    // Customer class inside Large
    private class Customer {
        private String name;
        private String email;
        private String phoneNumber;
        private String licenseNumber;
        private String address;

        public Customer(String name, String email, String phoneNumber, String licenseNumber, String address) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.licenseNumber = licenseNumber;
            this.address = address;
        }

        // Customer methods
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getLicenseNumber() {
            return licenseNumber;
        }

        public String getAddress() {
            return address;
        }

        public void updateEmail(String newEmail) {
            this.email = newEmail;
        }

        public void updatePhoneNumber(String newPhoneNumber) {
            this.phoneNumber = newPhoneNumber;
        }

        public void updateAddress(String newAddress) {
            this.address = newAddress;
        }

        @Override
        public String toString() {
            return name + " (" + email + ") - Phone: " + phoneNumber + " - License: " + licenseNumber;
        }
    }

    // Rental class inside Large
    private class Rental {
        private Customer customer;
        private Car car;
        private int rentalDays;
        private String rentalDate;
        private boolean insuranceIncluded;

        public Rental(Customer customer, Car car, int rentalDays, String rentalDate, boolean insuranceIncluded) {
            this.customer = customer;
            this.car = car;
            this.rentalDays = rentalDays;
            this.rentalDate = rentalDate;
            this.insuranceIncluded = insuranceIncluded;
        }

        // Rental methods
        public Customer getCustomer() {
            return customer;
        }

        public Car getCar() {
            return car;
        }

        public int getRentalDays() {
            return rentalDays;
        }

        public String getRentalDate() {
            return rentalDate;
        }

        public boolean isInsuranceIncluded() {
            return insuranceIncluded;
        }

        public double calculateTotalCost() {
            double totalCost = car.getRentalPricePerDay() * rentalDays;
            if (insuranceIncluded) {
                totalCost += 15.00 * rentalDays; // Assume insurance is $15 per day
            }
            return totalCost;
        }

        public void extendRental(int additionalDays) {
            this.rentalDays += additionalDays;
        }

        public void includeInsurance() {
            this.insuranceIncluded = true;
        }

        @Override
        public String toString() {
            return "Rental: " + customer.getName() + " rented " + car.getModel() + " for " + rentalDays + " days. Total cost: $" + calculateTotalCost();
        }
    }

    // Main method for running the system
    public static void main(String[] args) {
        Large rentalSystem = new Large();

        // Adding cars
        rentalSystem.addCar("Toyota", "Camry", 50.00, 2020, "Gasoline");
        rentalSystem.addCar("Ford", "Focus", 40.00, 2018, "Diesel");

        // Adding customers
        rentalSystem.addCustomer("John Doe", "john@example.com", "555-1234", "B12345678", "123 Main St");
        rentalSystem.addCustomer("Jane Smith", "jane@example.com", "555-5678", "C87654321", "456 Oak St");

        // Placing rentals
        rentalSystem.placeRental("John Doe", "Camry", 3, "2024-10-20", true);
        rentalSystem.placeRental("Jane Smith", "Focus", 5, "2024-10-21", false);

        // Listing all rentals and total income
        rentalSystem.listRentals();
        rentalSystem.showTotalIncome();
    }
}