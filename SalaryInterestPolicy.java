public class SalaryInterestPolicy implements InterestPolicy {
    public double calculate(double balance) {
        return balance * 0.05;
    }
}
