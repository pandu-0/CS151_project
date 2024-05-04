import java.util.ArrayList;

public class Cart {
    ArrayList<Product> cart;//Initialize cart arraylist

    public Cart(ArrayList<Product> cart) {//constructor
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product p){//method to add to cart
        cart.add(p);
    }

    public void removeFromCart(Product p){//method to remove from cart
        cart.remove(p);
    }
}
