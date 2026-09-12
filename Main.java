public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", "Harsh Yuvraj", 1000.00);
        account.deposit(500.00);
        account.withdraw(250.00);

        AccountRepository repository = new AccountRepository();
        repository.save(account);

        NotificationService notificationService = new NotificationService();
        notificationService.send("Your account balance is " + account.getBalance());

        StatementGenerator statementGenerator = new StatementGenerator();
        System.out.println(statementGenerator.generate(account));
    }
}
