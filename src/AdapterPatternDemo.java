import adapter.CurrencyAdapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Original price in Euro
        double euroPrice = 50.0;

        // Convert Euro price to Dollar using the Adapter
        double dollarPrice = CurrencyAdapter.convertEuroToDollar(euroPrice);

        // Output the original and converted price
        System.out.println("Price in Euro: €" + euroPrice);
        System.out.println("Price in US Dollar: $" + dollarPrice);
    }
}