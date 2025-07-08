package car;

import java.util.Objects;

public abstract class Car implements Cloneable {
    private String make;
    private String model;
    private double rentalPricePerDay;
    private int year;
    private String fuelType;
    private boolean rented;

    // Constructor
    public Car(String make, String model, double rentalPricePerDay, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        this.year = year;
        this.fuelType = fuelType;
    }

    // Getters
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

    public boolean isRented() {
        return rented;
    }

    // Setters
    public void setRentalPricePerDay(double newPrice) {
        this.rentalPricePerDay = newPrice;
    }

    public void rent() {
        this.rented = true;
    }

    public void returnCar() {
        this.rented = false;
    }

    // String representation of the car
    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + fuelType + ") - $" + rentalPricePerDay;
    }

    // Abstract method — must be implemented by subclasses
    public abstract String getCarType();

    // Prototype Pattern — cloning method
    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    // Compares values (not references)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Different class

        Car car = (Car) obj;
        return Double.compare(car.rentalPricePerDay, rentalPricePerDay) == 0 &&
                year == car.year &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                fuelType.equals(car.fuelType);
    }

    // Hashcode used for collections (based on key fields)
    @Override
    public int hashCode() {
        return Objects.hash(make, model, rentalPricePerDay, year, fuelType);
    }
}