package Purchasable;

import java.util.*;
import Billing.Retailer;

public class Produce extends NonExpired{
    private boolean organic;//variable for whether item is organic

    // constructor
    public Produce(int id, String name, String description, float price, boolean organic, float weight, int retailer_id) {
        super(id, name, description, price, retailer_id);
        this.organic = organic;
        this.setWeight(weight);
    }

    public boolean isOrganic() {//get method for organic
        return organic;
    }

    public void setOrganic(boolean organic) {//set method for organic
        this.organic = organic;
    }


    @Override
    public float calculatePrice() {//method for calculating price
        return this.getPrice()*this.getWeight()*this.getQuantity();
    }

    @Override
    public String toString() {
        if (organic) {
            return super.toString() +
                    "Organic: Yes\t";
        } else {
            return super.toString() +
                    "Organic: No\t";
        }
    }
}
