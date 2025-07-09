public class TaxUtil {

    // Pure function
    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        TaxUtil taxUtil = new TaxUtil();
        double amount = 1000.0;
        double rate = 0.15;
        double tax = taxUtil.calculateTax(amount, rate);
        System.out.println("Tax on ₹" + amount + " at " + (rate * 100) + "% is ₹" + tax);
    }
}
