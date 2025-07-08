package payment;

public class PayPalPayment implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal ile ödeme yapıldı: $" + amount);
    }
}