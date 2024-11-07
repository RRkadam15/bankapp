// DepositTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    private BankAccount account;
    private Deposit deposit;
    
   @BeforeEach
    void setUp() {
        account = new BankAccount();
        deposit = new Deposit();
    }

    @Test
    void testDepositPositiveAmount() {
        deposit.deposit(account, 100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be updated correctly after deposit");
    }

    @Test
    void testDepositNegativeAmount() {
        deposit.deposit(account, -50.0);
        assertEquals(0.0, account.getBalance(), "Negative amount should not be taken");
    }
}
