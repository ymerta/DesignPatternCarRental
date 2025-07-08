import rental.RentalPayment;
import payment.CreditCardPayment;
import payment.PayPalPayment;

public class BridgePatternDemo {
    public static void main(String[] args) {
        // Create a rental payment using a Credit Card payment method
        RentalPayment creditCardPayment = new RentalPayment(new CreditCardPayment());
        creditCardPayment.makePayment(100.0);

        // Create a rental payment using a PayPal payment method
        RentalPayment paypalPayment = new RentalPayment(new PayPalPayment());
        paypalPayment.makePayment(150.0);
    }
}