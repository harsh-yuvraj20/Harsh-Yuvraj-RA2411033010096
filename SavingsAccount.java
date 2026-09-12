public class SavingsAccount extends Account implements Depositable, Withdrawable, Transferable, StatementProvider {
    public SavingsAccount(String accountNumber, String accountHolder, double openingBalance) {
        super(accountNumber, accountHolder, openingBalance);
    }

    public void withdraw(double amount) {
        withdrawFromBalance(amount);
    }

    public void transfer(double amount, String toAccount) {
        withdraw(amount);
        System.out.println("Transferred " + amount + " to " + toAccount);
    }

    public void printStatement() {
        System.out.println("Savings account balance: " + getBalance());
    }
}
