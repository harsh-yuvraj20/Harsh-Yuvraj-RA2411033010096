public class StatementGenerator {
    public String generate(BankAccount account) {
        return "Account Statement\n"
                + "Account Number: " + account.getAccountNumber() + "\n"
                + "Account Holder: " + account.getAccountHolder() + "\n"
                + "Balance: " + account.getBalance();
    }
}
