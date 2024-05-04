import java.util.*;

public class Produce extends NonExpired{
    private boolean organic;//variable for whether item is organic

    public Produce(int id, String name, String description, float price, boolean quantityBased, boolean organic, List<Retailer> retailers) {//constructor
        super(id, name, description, price, quantityBased, retailers);
        this.organic = organic;
    }

    public boolean isOrganic() {//get method for organic
        return organic;
    }

    public void setOrganic(boolean organic) {//set method for organic
        this.organic = organic;
    }


    @Override
    public float calculatePrice() {//method for calculating price
        return this.getPrice()*this.getWeight();
    }
}
