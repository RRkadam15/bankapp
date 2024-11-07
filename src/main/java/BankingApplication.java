import java.util.Scanner;

public class BankingApplication {
    private static AccountManager accountManager = new AccountManager();
    private static Scanner scanner = new Scanner(System.in);
    private static Deposit depositAction = new Deposit();
    private static Withdraw withdrawAction = new Withdraw();
    private static Transfer transferAction = new Transfer();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Banking Application Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> transferMoney();
                case 5 -> checkBalance();
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the our banking application.");
    }

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        accountManager.createAccount(accountName);
    }

    // Method to deposit money into an account
    private static void depositMoney() {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        BankAccount account = accountManager.getAccount(accountName);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            depositAction.deposit(account, amount);
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    private static void withdrawMoney() {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        BankAccount account = accountManager.getAccount(accountName);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            withdrawAction.withdraw(account, amount);
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to transfer money between accounts
    private static void transferMoney() {
        System.out.print("Enter your account name: ");
        String fromAccountName = scanner.nextLine();
        System.out.print("Enter recipient account name: ");
        String toAccountName = scanner.nextLine();

        BankAccount fromAccount = accountManager.getAccount(fromAccountName);
        BankAccount toAccount = accountManager.getAccount(toAccountName);

        if (fromAccount != null && toAccount != null) {
            System.out.print("Enter transfer amount: ");
            double amount = scanner.nextDouble();
            transferAction.transfer(fromAccount, toAccount, amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // Method to check the balance of an account
    private static void checkBalance() {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        BankAccount account = accountManager.getAccount(accountName);
        if (account != null) {
            System.out.println("Current balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}