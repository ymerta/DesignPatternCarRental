import car.Car;
import car.Sedan;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        try {
            // Create the original car object
            Car originalCar = new Sedan("Toyota", "Camry", 50.00, 2020, "Gasoline");

            System.out.println("----------------------------");
            System.out.println("Original car: " + originalCar);

            // Clone (copy) the original car
            Car clonedCar = originalCar.clone();

            System.out.println("Cloned car: " + clonedCar);
            System.out.println("----------------------------");

            // Check if the original and cloned objects are the same instance
            System.out.println("Are original and clone the same object?");
            System.out.println(originalCar == clonedCar); // Should be false, different references

            System.out.println("----------------------------");

            // Check if the contents (state) of the two cars are the same
            System.out.println("Do the original and the clone have the same attributes?");
            System.out.println(originalCar.equals(clonedCar)); // Can be true if equals is overridden correctly

            System.out.println("----------------------------");

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}