package EI.Models;

import EI.Interface.Prototype;

public class Electronics extends Product {
    private String brand;
    private String model;
    private int warrantyPeriod;

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public Prototype copy() {
        Electronics product = new Electronics();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setCategory(this.getCategory());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setQuantity(this.getQuantity());
        product.setIsAvailable(this.getIsAvailable());
        product.setBrand(this.getBrand());
        product.setModel(this.getModel());
        product.setWarrantyPeriod(this.getWarrantyPeriod());

        return product;
    }
}
