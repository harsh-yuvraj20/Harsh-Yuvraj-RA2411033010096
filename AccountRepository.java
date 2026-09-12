public interface AccountRepository {
    void save(BankAccount account);

    BankAccount findByAccountNumber(String accountNumber);
}
