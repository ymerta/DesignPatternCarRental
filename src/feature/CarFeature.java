package feature;

import car.Car;

// Abstract decorator class that extends Car
public abstract class CarFeature extends Car {
    // Wrapped car object
    protected Car car;

    // Constructor copies base car properties and stores reference
    public CarFeature(Car car) {
        super(car.getMake(), car.getModel(), car.getRentalPricePerDay(), car.getYear(), car.getFuelType());
        this.car = car;
    }

    // Each feature will provide its own implementation for rental price
    public abstract double getRentalPricePerDay();
}