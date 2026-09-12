public class SavingsInterestPolicy implements InterestPolicy {
    public double calculate(double balance) {
        return balance * 0.04;
    }
}
