public class SavingsAccount extends Account implements Withdrawable {
    public SavingsAccount(String accountNumber, String accountHolder, double openingBalance) {
        super(accountNumber, accountHolder, openingBalance);
    }

    public void withdraw(double amount) {
        withdrawFromBalance(amount);
    }
}
