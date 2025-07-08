package feature;

import car.Car;

public class GPSDecorator extends CarFeature {

    public GPSDecorator(Car car) {
        super(car);
    }

    @Override
    public double getRentalPricePerDay() {
        return car.getRentalPricePerDay() + 10; // GPS özelliği için ek ücret
    }

    @Override
    public String getCarType() {
        return car.getCarType() + " with GPS"; // Arabanın türüne GPS özelliğini ekler
    }
}