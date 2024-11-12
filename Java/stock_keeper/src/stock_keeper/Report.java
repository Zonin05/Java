package stock_keeper;

public class Report {
    private Inventory inventory;

    public Report(Inventory inventory) {
        this.inventory = inventory;
    }

    public void generateInventoryReport() {
        System.out.println("\nInventory Report:");
        System.out.println("====================================");

        for (Product product : inventory.getProducts()) {
            if (product.getQuantity() < 10) {
                System.out.println("Low Stock: " + product);
            }
        }

        System.out.println("====================================");
    }
}
