// WithdrawTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WithdrawTest {
    private BankAccount account;
    private Withdraw withdraw;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
        account.setBalance(200.0); // Setting initial balance
        withdraw = new Withdraw();
    }

    @Test
    void testWithdrawValidAmount() {
        withdraw.withdraw(account, 100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be reduced correctly after valid withdrawal");
    }

    @Test
    void testWithdrawInvalidAmount() {
        withdraw.withdraw(account, 300.0);
        assertEquals(200.0, account.getBalance(), "Balance should remain the same if withdrawal amount exceeds balance");
    }

    @Test
    void testWithdrawNegativeAmount() {
        withdraw.withdraw(account, -50.0);
        assertEquals(200.0, account.getBalance(), "Negative withdrawal should not change the balance");
    }
}
