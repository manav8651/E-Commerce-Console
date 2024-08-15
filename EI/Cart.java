package EI;

import java.util.*;

import EI.Models.Product;

public class Cart {
    private static Map<Integer, Integer> items = new HashMap<>();
    private static Map<Integer, Product> cartItems = new HashMap<>();

    // Adding product to cart using clone
    public static void addProduct(Product product, int id, int quantity) {

        if (product.getIsAvailable()) {
            Product clonedProduct = (Product) product.copy(); // Cloning the product object

            items.put(id, items.getOrDefault(id, 0) + quantity);
            cartItems.put(id, clonedProduct);
            System.out.println("Product added:" + product.getName());
        } else {
            System.out.println("Product is not available.");
        }

    }

    public static void updateQuantity(int id, int quantity, char incOrdec) {
        if (items.containsKey(id)) {
            if (incOrdec == '+')
                items.put(id, items.getOrDefault(id, 0) + quantity);
            else {
                if (items.get(id) - quantity <= 0) {
                    items.remove(id);
                } else
                    items.put(id, items.getOrDefault(id, 0) - quantity);
            }
        } else {
            System.out.println("No product found for this id.");
        }
    }

    public static void removeItem(int id) {
        if (items.get(id) == null) {
            System.out.println("No Product exists for this id!");
            return;
        }

        items.remove(id);
    }

    public static void viewCart() {
        int itemsSize = items.size();
        if (itemsSize == 0) {
            System.out.println("Cart is Empty");
        } else {
            System.out.println("****************************** Current Cart ****************************************");
            items.forEach((id, quantity) -> {
                System.out.println("Id: " + id);
                System.out.println("Product Name: " + cartItems.get(id).getName());
                System.out.println("Product Category: " + cartItems.get(id).getCategory().toString());
                System.out.println("Quantity Added: " + quantity);
            });
            System.out.println("**********************************************************************************");
        }

    }

    public static void sumCart(double discount) {
        int total = 0;
        for (Map.Entry<Integer, Integer> item : items.entrySet()) {
            int key = item.getKey();
            Integer value = item.getValue();
            total += (cartItems.get(key).getPrice()) * value;
        }
        if (discount > 0) {
            total -= total * discount;
        }
        System.out.println("Total Bill: " + total);
    }
}
