import java.util.*;

public class HouseholdEssentials extends NonExpired{
    private boolean environmentallyFriendly;//variable for whether item is environmentally friendly

    public HouseholdEssentials(int id, String name, String description, float price, boolean quantityBased, boolean environmentallyFriendly, List<Retailer> retailers) {//constructor
        super(id, name, description, price, quantityBased, retailers);
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
                    "Environmentally Friendly: Yes";
        } else {
            return super.toString() +
                    "Environmentally Friendly: No";
        }
    }
}
