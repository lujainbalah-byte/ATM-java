
Here is a simpler version of the ATM simulation in Java:
import java.util.Scanner;

public class SimpleATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pin = 1234;
        int attempts = 0;
        boolean loggedIn = false;

        // PIN check with up to 3 attempts
        do {
            System.out.print("Enter PIN: ");
            int enteredPin = input.nextInt();
            attempts++;

            if (enteredPin == pin) {
                loggedIn = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Wrong PIN.");
            }
        } while (!loggedIn && attempts < 3);

        if (!loggedIn) {
            System.out.println("Too many attempts. Exiting.");
            input.close();
            return;
        }

        double balance = 0.0;
        String[] transactions = new String[50];
        int count = 0;
        int choice = 0;

        // Main menu loop
        while (choice != 5) {
            System.out.println("\n1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Balance: " + balance);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = input.nextDouble();
                balance += amount;
                transactions[count++] = "Deposited: " + amount;
                System.out.println("Deposited " + amount);
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double amount = input.nextDouble();
                if (amount <= balance) {
                    balance -= amount;
                    transactions[count++] = "Withdrew: " + amount;
                    System.out.println("Withdrew " + amount);
                } else {
                    System.out.println("Insufficient balance!");
                }
            } else if (choice == 4) {
                System.out.println("Transactions:");
                for (int i = 0; i < count; i++) {
                    System.out.println(transactions[i]);
                }
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}