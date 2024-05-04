import java.util.*;

public class Dairy extends Expired{
    private boolean veganFriendly;//variable for whether item is vegan friendly

    public Dairy(int id, String name, String description, float price, int daysToExpire, boolean veganFriendly, boolean quantityBased, List<Retailer> retailers) {//constructor
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
}
