package EI;

import java.util.*;

import EI.enums.Category;
import EI.Models.Books;
import EI.Models.Electronics;
import EI.Models.Product;

public class Main {
    public static void main(String[] args) {
        // Switch case implementation
        Scanner sc = new Scanner(System.in);
        Map<Integer, Product> products = new HashMap<>();

        Electronics laptop = new Electronics(); // Object of Electronics sub class
        laptop.setId(1);
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop");
        laptop.setPrice(1200.00);
        laptop.setQuantity(10);
        laptop.setCategory(Category.ELECTRONICS);
        laptop.setBrand("BrandName");
        laptop.setModel("Model123");
        laptop.setWarrantyPeriod(24);
        laptop.setIsAvailable(true);

        Books book = new Books();
        book.setId(2);
        book.setName("System Design Vol 1");
        book.setDescription("System Design for Interviews");
        book.setPrice(1200.00);
        book.setQuantity(10);
        book.setCategory(Category.BOOKS);
        book.setAuthor("Alex Xu");
        book.setIsbn("123456789012");
        book.setPublisher("Springer Publication House");
        book.setIsAvailable(true);

        products.put(laptop.getId(), laptop); // Object of subclass can be added to list of base class
        products.put(book.getId(), book);

        // add
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the E-commerce Platform");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. Update Cart Quantity");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout and apply discount (View Total Bill)");
            System.out.println("7. Exit");
            System.out.print("Please choose an option: ");
            try {

                int choice = sc.nextInt();
                if (choice <= 0)
                    throw new InputMismatchException();
                switch (choice) {
                    case 1:
                        System.out.println("Available Products:");
                        products.forEach((id, product) -> {
                            System.out.println(product.getName());
                        });
                        break;
                    case 2:
                        products.forEach((id, product) -> {
                            System.out.println(product.getId() + ", " + product.getName());
                        });
                        System.out.println();
                        System.out.println("Which Product do you want to add? Select id :");
                        try {
                            boolean isProductFound = false;
                            int indProd = sc.nextInt();
                            for (Map.Entry<Integer, Product> product : products.entrySet()) {
                                int key = product.getKey();
                                Product value = product.getValue();
                                if (key == indProd) {
                                    Cart.addProduct(value, indProd, 1);
                                    isProductFound = true;
                                }
                            }
                            if (!isProductFound) {
                                System.out.println("No product found for this id!");
                            }
                            // display current cart
                            Cart.viewCart();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: You must enter an integer.");
                            exit = true;
                        }
                        break;
                    case 3:
                        // Display current cart
                        Cart.viewCart();

                        System.out.println("Enter Id of item to be deleted from cart");
                        int id = sc.nextInt();
                        Cart.removeItem(id);

                        // Display Cart
                        Cart.viewCart();
                        break;
                    case 4:
                        // Display current cart
                        Cart.viewCart();

                        System.out.println("Enter Id of item whose quantity needs to be updated");
                        int pid = sc.nextInt();

                        System.out.println("Increase or Decrease: ");
                        char incOrdec = sc.next().charAt(0);
                        System.out.println("Enter quantity to be updated");
                        int quantity = sc.nextInt();

                        Cart.updateQuantity(pid, quantity, incOrdec);

                        // Display Cart
                        Cart.viewCart();
                        break;
                    case 5:
                        Cart.viewCart();
                        break;
                    case 6:
                        System.out.println("Enter 0 for no Discount");
                        System.out.println("Enter 1 for Percentage Discount");
                        System.out.println("Enter 2 for Buy One Get One free");
                        try {
                            int discountChoice = sc.nextInt();
                            if (discountChoice < 0)
                                throw new InputMismatchException();

                            double discountablePercentage = 0.0;
                            switch (discountChoice) {
                                case 0:
                                    discountablePercentage = 0.0;
                                    break;
                                case 1:
                                    Discount percentageDiscount = new Discount();
                                    discountablePercentage = percentageDiscount.applyDiscount(0.20);
                                    break;
                                case 2:
                                    SeasonSale seasonSale = new SeasonSale();
                                    discountablePercentage = seasonSale.applyDiscount(0.30);
                                    break;
                                default:
                                    System.out.println("No matching discount exists, try again!");
                                    break;
                            }
                            Cart.sumCart(discountablePercentage);
                        } catch (InputMismatchException e) {
                            System.out.println("You must enter a positive integer less than 3");
                            exit = true;
                        }
                        break;
                    case 7:
                        System.out.println("Closing Application....");
                        exit = true;
                        sc.close();
                        break;
                    default:
                        System.out.println("No choice exists, try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter a positive integer.");
                return;
            }

        }
        sc.close();
    }
}
