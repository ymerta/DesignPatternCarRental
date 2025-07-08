package adapter;

public class CurrencyAdapter {

    // Converts Euro price to Dollar using a fixed exchange rate
    public static double convertEuroToDollar(double euroPrice) {
        return euroPrice * 1.1; // Simple conversion rate (example: 1 EUR = 1.1 USD)
    }
}