package Purchasable;

import java.util.*;


public abstract class Expired extends Product{
    private int daysToExpire;//variable for days left until product expires

    public Expired(int id, String name, String description, float price, int daysToExpire, int retailer_id) {//constructor
        super(id, name, description, price, retailer_id);
        this.daysToExpire = daysToExpire;
    }

    public Expired() {

    }

    public int getDaysToExpire() {//get method for daysToExpire
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {//set method for daysToExpire
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Days To Expire: " + daysToExpire + "\t";
    }
}
