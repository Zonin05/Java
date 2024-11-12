package bank_mate;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialize the bank system and start the menu
        BankSystem bankSystem = new BankSystem();
        bankSystem.run();
    }
}

class BankSystem {
    private Account userAccount;
    private Scanner scanner;

    public BankSystem() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        // Main menu loop
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    viewBalanceAndHistory();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nBank Account System Menu:");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. View Balance and Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserInput() {
        return scanner.nextInt(); // Get the user input as an integer
    }

    private void createAccount() {
        scanner.nextLine(); // Consume newline from previous input
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        userAccount = new Account(accountName, initialBalance);
        System.out.println("Account created successfully for " + accountName + " with an initial balance of " + initialBalance);
    }

    private void depositMoney() {
        if (userAccount == null) {
            System.out.println("No account found. Please create an account first.");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposited " + amount + " to your account.");
    }

    private void withdrawMoney() {
        if (userAccount == null) {
            System.out.println("No account found. Please create an account first.");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        boolean success = userAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrew " + amount + " from your account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void viewBalanceAndHistory() {
        if (userAccount == null) {
            System.out.println("No account found. Please create an account first.");
            return;
        }
        System.out.println("Account balance: " + userAccount.getBalance());
        System.out.println("Transaction history:");
        userAccount.displayTransactionHistory();
    }
}

class Account {
    private String accountName;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public double getBalance() {
        return balance;
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
