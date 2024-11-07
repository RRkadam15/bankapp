// TransferTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransferTest {
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private Transfer transfer;

    @BeforeEach
    void setUp() {
        fromAccount = new BankAccount();
        fromAccount.setBalance(300.0);
        toAccount = new BankAccount();
        transfer = new Transfer();
    }

    @Test
    void testTransferValidAmount() {
        transfer.transfer(fromAccount, toAccount, 150.0);
        assertEquals(150.0, fromAccount.getBalance(), "From account balance should be reduced correctly");
        assertEquals(150.0, toAccount.getBalance(), "To account balance should be increased correctly");
    }

    @Test
    void testTransferInvalidAmount() {
        transfer.transfer(fromAccount, toAccount, 400.0);
        assertEquals(300.0, fromAccount.getBalance(), "Balance should remain the same if transfer amount exceeds balance");
        assertEquals(0.0, toAccount.getBalance(), "To account balance should remain the same if transfer is invalid");
    }
}
