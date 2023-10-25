package application;

import exceptions.DomainException;
import model.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        System.out.println();

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        try {
            account.withdraw(amount);
            System.out.println(account);
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }

    }
}
