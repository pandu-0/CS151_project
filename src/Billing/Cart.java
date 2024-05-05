package Billing;

import Purchasable.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> cart; // Initialize cart arraylist

    public Cart() { // constructor
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product p) {//method to add to cart
        cart.add(p);
    }

    public void removeFromCart(Product p) {//method to remove from cart
        cart.remove(p);
    }

    public float total() { // Calculate cart total
        float total = 0;
        for (Product product : cart) {
            total = total + product.calculatePrice();
        }

        return total;
    }
}
