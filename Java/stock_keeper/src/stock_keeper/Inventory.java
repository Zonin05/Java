package stock_keeper;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(name, category, price, quantity);
        products.add(product);
        System.out.println("Product added: " + product);
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to remove: ");
        String name = scanner.nextLine();

        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        System.out.println("Product removed: " + name);
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();

                product.updatePrice(price);
                product.updateQuantity(quantity);

                System.out.println("Updated product: " + product);
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void searchProducts() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name or category to search: ");
        String query = scanner.nextLine();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(query) || product.getCategory().equalsIgnoreCase(query)) {
                System.out.println(product);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
