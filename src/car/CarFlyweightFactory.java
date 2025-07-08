package car;

import java.util.HashMap;
import java.util.Map;

public class CarFlyweightFactory {

    // Shared pool of flyweight Car objects
    private static Map<String, Car> carFlyweights = new HashMap<>();

    // Returns an existing car if available; otherwise, creates and stores a new one
    public static Car getCar(String carType, String make, String model, double rentalPricePerDay, int year, String fuelType) {
        String key = carType + make + model + year + fuelType;

        if (!carFlyweights.containsKey(key)) {
            Car car;
            switch (carType.toLowerCase()) {
                case "sedan":
                    car = new Sedan(make, model, rentalPricePerDay, year, fuelType);
                    break;
                case "suv":
                    car = new SUV(make, model, rentalPricePerDay, year, fuelType);
                    break;
                case "hatchback":
                    car = new Hatchback(make, model, rentalPricePerDay, year, fuelType);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid car type: " + carType);
            }
            carFlyweights.put(key, car);
        }

        return carFlyweights.get(key);
    }

    // Returns the number of unique car instances created
    public static int getTotalCarsCreated() {
        return carFlyweights.size();
    }
}