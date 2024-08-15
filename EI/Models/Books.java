package EI.Models;

import EI.Interface.Prototype;

public class Books extends Product {
    private String author;
    private String publisher;
    private String isbn;

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public Prototype copy() {
        Books product = new Books();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setCategory(this.getCategory());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setQuantity(this.getQuantity());
        product.setIsAvailable(this.getIsAvailable());
        product.setAuthor(this.getAuthor());
        product.setPublisher(this.getPublisher());
        product.setIsbn(this.getIsbn());

        return product;
    }
}
