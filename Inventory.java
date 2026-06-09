import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;
    private int nextId;

    public Inventory() {
        products = new ArrayList<>();
        nextId = 1;

        products.add(new Product(nextId++, "Laptop", "Electronics", 10, 55000));
        products.add(new Product(nextId++, "Mouse", "Electronics", 50, 500));
        products.add(new Product(nextId++, "Keyboard", "Electronics", 30, 1200));
    }

    public void addProduct(String name, String category, int quantity, double price) {
        Product p = new Product(nextId++, name, category, quantity, price);
        products.add(p);
    }

    public void viewAllProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void searchProduct(String keyword) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
            }
        }
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean updateProduct(int id, String name, String category, int quantity, double price) {
        Product p = findById(id);

        if (p == null) {
            return false;
        }

        p.setName(name);
        p.setCategory(category);
        p.setQuantity(quantity);
        p.setPrice(price);

        return true;
    }

    public boolean deleteProduct(int id) {
        Product p = findById(id);

        if (p == null) {
            return false;
        }

        products.remove(p);
        return true;
    }

    public void restockProduct(int id, int qty) {
        Product p = findById(id);

        if (p != null) {
            p.setQuantity(p.getQuantity() + qty);
        }
    }

    public void lowStockAlert(int threshold) {
        for (Product p : products) {
            if (p.getQuantity() < threshold) {
                System.out.println(p);
            }
        }
    }

    public void showSummary() {
        int totalItems = 0;
        double totalValue = 0;

        for (Product p : products) {
            totalItems += p.getQuantity();
            totalValue += p.getQuantity() * p.getPrice();
        }

        System.out.println("Total Products : " + products.size());
        System.out.println("Total Items    : " + totalItems);
        System.out.println("Total Value    : Rs." + totalValue);
    }
}