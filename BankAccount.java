public class BankAccount extends Account implements Withdrawable {
    // BankAccount changes for account operations; persistence, notifications, and statement format change elsewhere.

    public BankAccount(String accountNumber, String accountHolder, double openingBalance) {
        super(accountNumber, accountHolder, openingBalance);
    }

    public void withdraw(double amount) {
        withdrawFromBalance(amount);
    }
}
