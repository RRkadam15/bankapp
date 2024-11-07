public class BankAccount {
    private double balance;

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to set the balance (used by other classes)
    public void setBalance(double balance) {
        this.balance = balance;
    }
}