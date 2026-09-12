public class Bank {
    private final AccountRepository repository;
    private final NotificationService notificationService;

    public Bank(AccountRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void saveAccount(BankAccount account) {
        repository.save(account);
    }

    public void sendNotification(String message) {
        notificationService.send(message);
    }
}
