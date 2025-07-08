package feature;

import car.Car;

public class ChildSeatDecorator extends CarFeature {

    // Constructor accepts a Car object and passes it to the abstract decorator
    public ChildSeatDecorator(Car car) {
        super(car);
    }

    // Adds extra daily cost for the child seat
    @Override
    public double getRentalPricePerDay() {
        return car.getRentalPricePerDay() + 5; // $5 additional for Child Seat
    }

    // Appends "with Child Seat" to the car type
    @Override
    public String getCarType() {
        return car.getCarType() + " with Child Seat";
    }
}