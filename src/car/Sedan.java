package car;

public class Sedan extends Car {
    public Sedan(String make, String model, double rentalPricePerDay, int year, String fuelType) {
        super(make, model, rentalPricePerDay, year, fuelType);
    }

    @Override
    public String getCarType() {
        return "Sedan";
    }
}