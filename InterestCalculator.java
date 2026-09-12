public class InterestCalculator {
    public double calculate(String accountType, double balance) {
        if (accountType.equals("Savings")) {
            return balance * 0.04;
        } else if (accountType.equals("Current")) {
            return balance * 0.01;
        }

        // Adding a fourth account type would require modifying this calculator.
        return 0;
    }
}
