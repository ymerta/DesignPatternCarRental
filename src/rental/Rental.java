package rental;

import car.Car;
import customer.Customer;

public class Rental {
    private Customer customer;
    private Car car;
    private int rentalDays;
    private String rentalDate;
    private boolean insuranceIncluded;

    // Constructor for creating a rental record
    public Rental(Customer customer, Car car, int rentalDays, String rentalDate, boolean insuranceIncluded) {
        this.customer = customer;
        this.car = car;
        this.rentalDays = rentalDays;
        this.rentalDate = rentalDate;
        this.insuranceIncluded = insuranceIncluded;
    }

    // Getters
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

    // Calculates total rental cost
    public double calculateTotalCost() {
        double totalCost = car.getRentalPricePerDay() * rentalDays;
        if (insuranceIncluded) {
            totalCost += 15.00 * rentalDays; // Insurance costs $15 per day
        }
        return totalCost;
    }

    // Extends the rental by a given number of days
    public void extendRental(int additionalDays) {
        this.rentalDays += additionalDays;
    }

    // Adds insurance to the rental if not already included
    public void includeInsurance() {
        this.insuranceIncluded = true;
    }

    // Printable representation of a rental
    @Override
    public String toString() {
        return "Rental: " + customer.getName() + " rented " + car.getModel() + " for "
                + rentalDays + " days. Total cost: $" + calculateTotalCost();
    }
}