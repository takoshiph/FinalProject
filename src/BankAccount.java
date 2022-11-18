import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    final Account account = new Account();

    List<Account> accounts = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("$ ###,###,###.##");

    BankAccount(String cName, String cId) {
        account.customerName = cName;
        account.customerId = cId;
    }
    void deposit(int amount){
        if (amount >= 0){
            account.balance = account.balance + amount;
            account.previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if (amount >= 0){
            account.balance = account.balance - amount;
            account.previousTransaction = -amount;
        }

    }
    void getPreviousTransaction(){
        if (account.previousTransaction > 0) System.out.println("Deposited: " + decimalFormat.format(account.previousTransaction));
        else if (account.previousTransaction < 0) System.out.printf("Withdrawn: " + Math.abs(account.previousTransaction));
        else System.out.println("No transaction occurred.");
    }
    void showMenu(){
        char option ='\0';
        Scanner scan = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("$ ###,###,###.##");

        do{
            System.out.println("================================");
            System.out.println("Enter an option:");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit ");
            System.out.println("================================");
            option = scan.next().charAt(0);

            switch (Character.toUpperCase(option)){
                case 'A':
                    System.out.println("--------------------------------");
                    System.out.println("Balance: " + decimalFormat.format(account.balance));

                    System.out.println("--------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("--------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("--------------------------------");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("--------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("--------------------------------");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("--------------------------------");
                    getPreviousTransaction();
                    System.out.println("\n--------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("********************************");
                    break;

                default:
                    System.out.println("Invalid Option! Please enter a correct one.");
            }

        }while (option != 'E');
        System.out.println("Thank you for using our Banking System.");

    }
}