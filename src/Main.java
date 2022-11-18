import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        BankAccount bankAccount = new BankAccount("Elvin Ross","123456");
        System.out.println("Welcome " + bankAccount.account.customerName);
        System.out.println("Your ID is " + bankAccount.account.customerId);
        bankAccount.showMenu();
    }
}

