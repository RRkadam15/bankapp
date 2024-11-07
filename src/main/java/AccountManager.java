import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String, BankAccount> accounts = new HashMap<>();

    // Method to create a new account
    public void createAccount(String accountName) {
        if (accounts.containsKey(accountName)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountName, new BankAccount());
            System.out.println("Account created successfully.");
        }
    }

    // Method to retrieve an account by name
    public BankAccount getAccount(String accountName) {
        return accounts.get(accountName);
    }
}