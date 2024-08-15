package EI.Models;

import EI.Interface.Prototype;
import EI.enums.Category;

public abstract class Product implements Prototype {
    // Fields
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private boolean isAvailable;

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }
}
