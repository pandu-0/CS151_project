package Purchasable;

import java.util.*;
import Billing.Retailer;

public abstract class NonExpired extends Product {

    // constructor for NonExpired class
    public NonExpired(int id, String name, String description, float price, boolean quantityBased, List<Retailer> retailers) {
        super(id, name, description, price, quantityBased, retailers);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
