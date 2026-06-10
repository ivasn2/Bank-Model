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
            throw new IllegalArgumentException("Ошибка: сумма пополнения должна быть больше нуля.");
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

    public void printInfo() {
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Владелец: " + ownerName);
        System.out.println("Баланс: " + balance);
    }


    public void transfer(BankAccount target, double amount) {
        if (target == null) {
            throw new IllegalArgumentException("Ошибка: целевой счет не найден.");
        }
        this.withdraw(amount);
        target.deposit(amount);
    }

}
