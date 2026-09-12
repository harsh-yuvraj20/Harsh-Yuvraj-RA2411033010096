public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", "Harsh Yuvraj", 1000.00);
        account.deposit(500.00);
        account.withdraw(250.00);

        AccountRepository repository = new AccountRepository();
        repository.save(account);

        NotificationService notificationService = new NotificationService();
        Bank bank = new Bank(notificationService);
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
        Bank smsBank = new Bank(smsNotificationService);
        smsBank.sendNotification("SMS notification service can be substituted.");

        LspDemonstration.run();
    }
}
