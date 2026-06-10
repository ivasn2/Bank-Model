package app;

import model.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount account1;
    private static BankAccount account2;

    public static void main(String[] args) {
        while (true) {

            System.out.println("=== БАНК ===");
            System.out.println("1. Создать счет");
            System.out.println("2. Пополнить счет");
            System.out.println("3. Снять деньги");
            System.out.println("4. Показать данные счета");
            System.out.println("5. Перевод между счетами");
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
                        printInfo();
                        break;

                    case 5:
                        transfer(account2, account1.getBalance());
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

        System.out.print("Введите номер счета: ");
        String number = scanner.nextLine();

        System.out.print("Введите владельца: ");
        String owner = scanner.nextLine();

        System.out.print("Введите баланс: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        account1 = new BankAccount(number, owner, balance);

        System.out.println("Счет успешно создан");
    }

    private static void deposit() {

        if (account1 == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        account1.deposit(amount);
        System.out.println("Счет пополнен");
    }

    private static void withdraw() {

        if (account1 == null) {
            System.out.println("Сначала создайте счет");
            return;
        }

        System.out.println();

    }

    private static void printInfo() {
        account1.printInfo();
    }

    private static void transfer(BankAccount target, double amount) {
        if (account1 == null || account2 == null) {
            System.out.println("Необходимо создать два счета");
            return;
        }

        System.out.print("Введите сумму перевода: ");
        amount = scanner.nextDouble();
        scanner.nextLine();

        try {
            account1.transfer(account2, amount);
            System.out.println("Перевод выполнен успешно");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}

