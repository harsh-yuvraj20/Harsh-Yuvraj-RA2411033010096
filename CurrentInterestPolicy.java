public class CurrentInterestPolicy implements InterestPolicy {
    public double calculate(double balance) {
        return balance * 0.01;
    }
}
