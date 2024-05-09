package Billing;

import Purchasable.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart; // Initialize cart arraylist

    public Cart() { // constructor
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product p) {//method to add to cart
        cart.add(p);
    }

    public void removeFromCart(int productId) {//method to remove from cart

        List<Product> toRemove = new ArrayList<>();

        for (Product p : cart) {
            if (p.getId() == productId) {
                toRemove.add(p);
                break;
            }
        }

        cart.removeAll(toRemove);
    }

    public float total() { // Calculate cart total
        float total = 0;
        for (Product product : cart) {
            total = total + product.calculatePrice();
        }

        return total;
    }

    public int getCartSize() {
        return cart.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p : this.cart) {
            sb.append(p.toString());
            sb.append("\n");
        }
        sb.append("\nCart Total: $").append(total());
        return sb.toString();
    }

    public boolean contains (int p_id) {
        for(Product p : this.cart) {
            if(p.getId() == p_id) {
                return true;
            }
        }
        return false;
    }

    public List<Product> getCartList() {
        return this.cart;
    }
}
