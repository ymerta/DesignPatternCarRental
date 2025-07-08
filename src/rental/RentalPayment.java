package rental;

import payment.PaymentSystem;

public class RentalPayment {
    // Reference to the implementation (Bridge to PaymentSystem)
    private PaymentSystem paymentSystem;

    // Constructor takes a specific payment method implementation
    public RentalPayment(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    // High-level operation delegated to the payment system
    public void makePayment(double amount) {
        paymentSystem.processPayment(amount);
    }
}