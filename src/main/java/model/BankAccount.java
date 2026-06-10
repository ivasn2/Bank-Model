package model;

public class BankAccount {

    private final String accountNumber;
    private String ownerName;
    private double balance;


    public BankAccount(String accountNumber, String ownerName, double balance) {

        if (balance < 0) {
            throw new IllegalArgumentException("Ошибка: начальный баланс не может быть отрицательным.");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void deposit(double amount) {


        if (amount <= 0) {
            throw new IllegalArgumentException("Ошибка: Отрицательные значения запрещены! Сумма пополнения должна быть больше нуля.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Ошибка: сумма снятия должна быть больше нуля.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Ошибка: нельзя снять больше денег, чем есть на счёте.");
        }
        balance -= amount;
    }

}
