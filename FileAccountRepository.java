import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileAccountRepository implements AccountRepository {
    private final Path filePath;

    public FileAccountRepository(Path filePath) {
        this.filePath = filePath;
    }

    public void save(BankAccount account) {
        String line = account.getAccountNumber() + "," + account.getAccountHolder() + "," + account.getBalance();
        try {
            Files.write(filePath, List.of(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to save account", exception);
        }
    }

    public BankAccount findByAccountNumber(String accountNumber) {
        try {
            if (!Files.exists(filePath)) {
                return null;
            }
            for (String line : Files.readAllLines(filePath)) {
                String[] values = line.split(",", 3);
                if (values.length == 3 && values[0].equals(accountNumber)) {
                    return new BankAccount(values[0], values[1], Double.parseDouble(values[2]));
                }
            }
            return null;
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to read account", exception);
        }
    }
}
