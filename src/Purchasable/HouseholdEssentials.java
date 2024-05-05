package Purchasable;

import java.util.*;
import Billing.Retailer;

public class HouseholdEssentials extends NonExpired{
    private boolean environmentallyFriendly;//variable for whether item is environmentally friendly

    // constructor
    public HouseholdEssentials(int id, String name, String description, float price, boolean environmentallyFriendly, int retailer_id) {
        super(id, name, description, price, retailer_id);
        this.environmentallyFriendly = environmentallyFriendly;
    }

    public boolean isEnvironmentallyFriendly() {//get method for environmentallyFriendly
        return environmentallyFriendly;
    }

    public void setEnvironmentallyFriendly(boolean environmentallyFriendly) {//set method for environmentallyFriendly
        this.environmentallyFriendly = environmentallyFriendly;
    }

    @Override
    public float calculatePrice() {//method for calculating price
        return this.getPrice()*this.getQuantity();
    }

    @Override
    public String toString() {
        if (environmentallyFriendly) {
            return super.toString() +
                    "Environmentally Friendly: Yes\t";
        } else {
            return super.toString() +
                    "Environmentally Friendly: No\t";
        }
    }
}
