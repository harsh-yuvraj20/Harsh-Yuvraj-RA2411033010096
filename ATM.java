public class ATM implements Depositable, Withdrawable {
    private double cashBalance;

    // The fat BankService would force an ATM to implement transfer, statements, and loans.
    public void deposit(double amount) {
        cashBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount > cashBalance) {
            throw new IllegalArgumentException("Insufficient ATM balance");
        }
        cashBalance -= amount;
    }
}
