// Product.java - Represents a product in the inventory

public class Product {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    // Constructor
    public Product(int id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public int getId()         { return id; }
    public String getName()    { return name; }
    public String getCategory(){ return category; }
    public int getQuantity()   { return quantity; }
    public double getPrice()   { return price; }

    // Setters
    public void setName(String name)        { this.name = name; }
    public void setCategory(String category){ this.category = category; }
    public void setQuantity(int quantity)   { this.quantity = quantity; }
    public void setPrice(double price)      { this.price = price; }

    // Display product details
    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-12s | %-8d | Rs.%-8.2f |",
                id, name, category, quantity, price);
    }
}