package car;

public class SUV extends Car {
    public SUV(String make, String model, double rentalPricePerDay, int year, String fuelType) {
        super(make, model, rentalPricePerDay, year, fuelType);
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}