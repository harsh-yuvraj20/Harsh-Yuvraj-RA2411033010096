import java.util.ArrayList;
import java.util.List;

public class LspDemonstration {
    public static void run() {
        demonstrateRectangleSquareViolation();
        demonstrateBrokenFixedDepositDesign();
        demonstrateCorrectWithdrawals();
    }

    private static void demonstrateRectangleSquareViolation() {
        Rectangle rectangle = new Square();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        System.out.println("Square used as Rectangle area: " + rectangle.area());
    }

    private static void demonstrateBrokenFixedDepositDesign() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-1001", "Harsh Yuvraj", 1000.00));
        accounts.add(new FixedDepositAccount("FD-1001", "Harsh Yuvraj", 1000.00));

        for (Account account : accounts) {
            try {
                withdrawUsingBrokenAccountDesign(account, 100.00);
                System.out.println("Bad design withdrawal succeeded for " + account.getAccountNumber());
            } catch (UnsupportedOperationException exception) {
                System.out.println("Bad design withdrawal failed for " + account.getAccountNumber()
                        + ": " + exception.getMessage());
            }
        }
    }

    private static void withdrawUsingBrokenAccountDesign(Account account, double amount) {
        if (account instanceof Withdrawable) {
            ((Withdrawable) account).withdraw(amount);
            return;
        }

        // This isolated example shows why treating every Account as withdrawable is wrong.
        throw new UnsupportedOperationException("Fixed deposit accounts cannot be withdrawn from");
    }

    private static void demonstrateCorrectWithdrawals() {
        List<Withdrawable> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingsAccount("SAV-1002", "Harsh Yuvraj", 1000.00));
        withdrawableAccounts.add(new CurrentAccount("CUR-1001", "Harsh Yuvraj", 1000.00));

        for (Withdrawable account : withdrawableAccounts) {
            account.withdraw(100.00);
        }
        System.out.println("Withdrawals completed through List<Withdrawable>.");
    }
}
