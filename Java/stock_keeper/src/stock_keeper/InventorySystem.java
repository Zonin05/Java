package stock_keeper;

import java.util.Scanner;

public class InventorySystem {
    private Inventory inventory;
    private Report report;

    public InventorySystem() {
        inventory = new Inventory();
        report = new Report(inventory);
    }

    public void run() {
        // Main menu loop
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    inventory.removeProduct();
                    break;
                case 3:
                    inventory.updateProduct();
                    break;
                case 4:
                    inventory.searchProducts();
                    break;
                case 5:
                    report.generateInventoryReport();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nInventory Management System Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Update Product");
        System.out.println("4. Search Products");
        System.out.println("5. Generate Report");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
