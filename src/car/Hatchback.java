package car;

public class Hatchback extends Car {
    public Hatchback(String make, String model, double rentalPricePerDay, int year, String fuelType) {
        super(make, model, rentalPricePerDay, year, fuelType);
    }

    @Override
    public String getCarType() {
        return "Hatchback";
    }
}