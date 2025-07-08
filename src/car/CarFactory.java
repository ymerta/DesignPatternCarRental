package car;

public class CarFactory {

    // Factory method to create car instances based on type
    public static Car createCar(String type, String make, String model, double rentalPricePerDay, int year, String fuelType) {
        switch (type) {
            case "Sedan":
                return new Sedan(make, model, rentalPricePerDay, year, fuelType);
            case "SUV":
                return new SUV(make, model, rentalPricePerDay, year, fuelType);
            case "Hatchback":
                return new Hatchback(make, model, rentalPricePerDay, year, fuelType);
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}