package model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void depositTest() {
        var account = new BankAccount("ACC001", "Иван Иванов", 1000);
        account.deposit(1000);
        assertEquals(2000, account.getBalance());
    }

    @Test
    void withdrawTest() {
        var account = new BankAccount("ACC001", "Иван Иванов", 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawWithInsufficientFunds() {
        var account = new BankAccount("ACC001", "Иван Иванов", 1000);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    account.withdraw(100000);
                });
    }

    @Test
    void depositNegativeAmount() {
        var account = new BankAccount("ACC001", "Иван Иванов", 1000);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    account.deposit(-100);
                });
    }
}
