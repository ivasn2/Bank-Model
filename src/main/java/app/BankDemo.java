package app;

import model.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount account;

    public static void main(String[] args) {

        while (true) {

            System.out.println("=== БАНК ===");
            System.out.println("1. Создать счет");
            System.out.println("2. Пополнить счет");
            System.out.println("3. Снять деньги");
            System.out.println("4. Показать баланс");
            System.out.println("5. Показать данные счета");
            System.out.println("0. Выход");

            try {

                System.out.print("Выберите действие: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        deposit();
                        break;

                    case 3:
                        withdraw();
                        break;

                    case 4:
                       printBalance();
                        break;

                    case 5:
                        printInfo();
                        break;

                    case 0:
                        System.out.println("Выход из программы...");
                        return;

                    default:
                        System.out.println("Такого пункта меню не существует");
                }

            } catch (InputMismatchException e) {

                System.out.println("Номер пункта меню должен быть числом!");
                scanner.nextLine();
            }
        }
    }

    private static void createAccount() {

        try {

            System.out.print("Введите номер счета: ");
            String number = scanner.nextLine();

            System.out.print("Введите владельца: ");
            String owner = scanner.nextLine();

            System.out.print("Введите баланс: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            account = new BankAccount(number, owner, balance);

            System.out.println("Счет успешно создан");
        }

        catch (InputMismatchException e) {
            System.out.println("Ошибка: баланс должен быть числом");
            scanner.nextLine();
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deposit() {

        if (account == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        try {
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.deposit(amount);

            System.out.println("Счет пополнен");
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: необходимо ввести число");
            scanner.nextLine();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void withdraw() {

        if (account == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        try {
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.withdraw(amount);

            System.out.println("С счета успешно снято: " + amount);
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: необходимо ввести число");
            scanner.nextLine();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void printInfo() {

        if (account == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        System.out.println("Номер счета: " + account.getAccountNumber());
        System.out.println("Владелец счета: " + account.getOwnerName());
        System.out.println("Баланс счета: " + account.getBalance());
    }

    private static void printBalance() {

        if (account == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        System.out.println("Баланс счета: " + account.getBalance());
    }

}

