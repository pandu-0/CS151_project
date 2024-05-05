package Purchasable;

import java.util.List;
import Billing.Retailer;

public class Dairy extends Expired{
    private boolean veganFriendly;//variable for whether item is vegan friendly

    // constructor
    public Dairy(int id, String name, String description, float price, int daysToExpire, boolean veganFriendly, boolean quantityBased, List<Retailer> retailers) {
        super(id, name, description, price, daysToExpire, quantityBased, retailers);
        this.veganFriendly = veganFriendly;
    }

    public boolean isVeganFriendly() {//get method for veganFriendly
        return veganFriendly;
    }

    public void setVeganFriendly(boolean veganFriendly) {//set method for veganFriendly
        this.veganFriendly = veganFriendly;
    }

    @Override
    public float calculatePrice() {//method for calculating price
        return this.getPrice()*this.getQuantity();
    }

    @Override
    public String toString() {
        if(veganFriendly) {
            return super.toString() +
                    "Vegan Friendly: Yes";
        }
        else{
            return super.toString() +
                    "Vegan Friendly: No";
        }

    }
}