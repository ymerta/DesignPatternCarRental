package payment;

public class CreditCardPayment implements PaymentSystem {

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment made using Credit Card: $" + amount);
    }
}