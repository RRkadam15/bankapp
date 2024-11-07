public class Transfer {
    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            System.out.println("Transferred $" + amount + " to the recipient account.");
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }
}
