import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        BankAccount account = new BankAccount("ACC-1001", "Harsh Yuvraj", 1000.00);
        account.deposit(500.00);
        account.withdraw(250.00);

        AccountRepository repository = new InMemoryAccountRepository();

        NotificationService notificationService = new EmailNotificationService();
        Bank bank = new Bank(repository, notificationService);
        bank.saveAccount(account);
        bank.sendNotification("Your account balance is " + account.getBalance());

        StatementGenerator statementGenerator = new StatementGenerator();
        System.out.println(statementGenerator.generate(account));

        InterestPolicy savingsPolicy = new SavingsInterestPolicy();
        InterestPolicy currentPolicy = new CurrentInterestPolicy();
        System.out.println("Savings interest: " + savingsPolicy.calculate(account.getBalance()));
        System.out.println("Current interest: " + currentPolicy.calculate(account.getBalance()));

        SalaryAccount salaryAccount = new SalaryAccount("ACC-1002", "Harsh Yuvraj", 1000.00);
        InterestPolicy salaryPolicy = new SalaryInterestPolicy();
        System.out.println("Salary interest: " + salaryPolicy.calculate(salaryAccount.getBalance()));

        NotificationService smsNotificationService = new SMSNotificationService();
        Bank smsBank = new Bank(repository, smsNotificationService);
        smsBank.sendNotification("SMS notification service can be substituted.");

        LspDemonstration.run();
        demonstrateFileRepository(account, notificationService);
    }

    private static void demonstrateFileRepository(BankAccount account, NotificationService notificationService)
            throws IOException {
        Path filePath = Files.createTempFile("accounts", ".txt");
        try {
            AccountRepository repository = new FileAccountRepository(filePath);
            Bank bank = new Bank(repository, notificationService);
            bank.saveAccount(account);

            System.out.println("File repository stored: " + Files.readString(filePath).trim());
            BankAccount savedAccount = repository.findByAccountNumber(account.getAccountNumber());
            System.out.println("File repository loaded: " + savedAccount.getAccountNumber()
                    + "," + savedAccount.getAccountHolder() + "," + savedAccount.getBalance());
        } finally {
            Files.deleteIfExists(filePath);
        }
    }
}
