import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Inventory inventory = new Inventory();

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      INVENTORY MANAGEMENT SYSTEM       ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice;

        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1 -> viewAllProducts();

                case 2 -> addProduct();

                case 3 -> searchProduct();

                case 4 -> updateProduct();

                case 5 -> deleteProduct();

                case 6 -> restockProduct();

                case 7 -> lowStockAlert();

                case 8 -> {
                    inventory.showSummary();
                    pause();
                }

                case 0 -> System.out.println("\nGoodbye! Exiting system...");

                default -> System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // MENU
    static void printMenu() {

        System.out.println("\n=================================");
        System.out.println("         MAIN MENU");
        System.out.println("=================================");
        System.out.println("1. View All Products");
        System.out.println("2. Add Product");
        System.out.println("3. Search Product");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Restock Product");
        System.out.println("7. Low Stock Alert");
        System.out.println("8. Inventory Summary");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }

    // VIEW ALL PRODUCTS
    static void viewAllProducts() {
        inventory.viewAllProducts();
        pause();
    }

    // ADD PRODUCT
    static void addProduct() {

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        int quantity = getIntInput("Enter Quantity: ");

        double price = getDoubleInput("Enter Price: ");

        inventory.addProduct(name, category, quantity, price);
    }

    // SEARCH PRODUCT
    static void searchProduct() {

        System.out.print("Enter Product Name or Category: ");
        String keyword = scanner.nextLine();

        inventory.searchProduct(keyword);
        pause();
    }

    // UPDATE PRODUCT
    static void updateProduct() {

        inventory.viewAllProducts();

        int id = getIntInput("\nEnter Product ID to Update: ");

        if (inventory.findById(id) == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Category: ");
        String category = scanner.nextLine();

        int quantity = getIntInput("Enter New Quantity: ");

        double price = getDoubleInput("Enter New Price: ");

        inventory.updateProduct(id, name, category, quantity, price);
    }

    // DELETE PRODUCT
    static void deleteProduct() {

        inventory.viewAllProducts();

        int id = getIntInput("\nEnter Product ID to Delete: ");

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            inventory.deleteProduct(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // RESTOCK PRODUCT
    static void restockProduct() {

        inventory.viewAllProducts();

        int id = getIntInput("\nEnter Product ID: ");

        int qty = getIntInput("Enter Quantity to Add: ");

        inventory.restockProduct(id, qty);
    }

    // LOW STOCK ALERT
    static void lowStockAlert() {

        int threshold = getIntInput("Enter Low Stock Threshold: ");

        inventory.lowStockAlert(threshold);
        pause();
    }

    // INTEGER INPUT
    static int getIntInput(String prompt) {

        while (true) {

            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid integer.");
            }
        }
    }

    // DOUBLE INPUT
    static double getDoubleInput(String prompt) {

        while (true) {

            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // PAUSE SCREEN
    static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}