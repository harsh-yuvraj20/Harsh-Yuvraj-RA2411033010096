import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void save(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount findByAccountNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
