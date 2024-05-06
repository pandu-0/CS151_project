package Purchasable;

import java.util.*;

public abstract class NonExpired extends Product {

    // constructor for NonExpired class
    public NonExpired(int id, String name, String description, float price, int retailer_id) {
        super(id, name, description, price, retailer_id);
    }

    public NonExpired() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
