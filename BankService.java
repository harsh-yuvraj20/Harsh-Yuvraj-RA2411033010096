// Bad ISP example: a basic ATM needs only deposit and withdraw, but this interface
// would also force it to provide transfer, statement, and loan operations.
public interface BankService {
    void deposit(double amount);

    void withdraw(double amount);

    void transfer(double amount, String toAccount);

    void printStatement();

    void applyForLoan();
}
