package Purchasable;

import java.util.*;
import Billing.Retailer;

public class Bakery extends Expired{
    private boolean glutenFree;//variable for whether item is gluten free

    //constructor
    public Bakery(int id, String name, String description, float price, int daysToExpire, boolean quantityBased, boolean glutenFree, List<Retailer> retailers) {
        super(id, name, description, price, daysToExpire, quantityBased,  retailers);
        this.glutenFree = glutenFree;
    }

    public boolean isGlutenFree() {//get method for glutenFree
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {//set method for glutenFree
        this.glutenFree = glutenFree;
    }

    @Override
    public float calculatePrice() {//method for calculating price
        return this.getPrice()*this.getQuantity();
    }

    @Override
    public String toString() {
//        if gluten-free return yes, otherwise no.
        return super.toString() + (glutenFree ?  "Gluten Free: Yes" : "Gluten Free: No");
    }

}
