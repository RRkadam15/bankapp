public class Withdraw {
    public void withdraw(BankAccount account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}