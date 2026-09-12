public class CurrentAccount extends Account implements Withdrawable {
    public CurrentAccount(String accountNumber, String accountHolder, double openingBalance) {
        super(accountNumber, accountHolder, openingBalance);
    }

    public void withdraw(double amount) {
        withdrawFromBalance(amount);
    }
}
