import java.util.List;

public abstract class Expired extends Product{
    private int daysToExpire;//variable for days left until product expires

    public Expired(int id, String name, String description, float price, int daysToExpire, boolean quantityBased, List<Retailer> retailers) {//constructor
        super(id, name, description, price, quantityBased, retailers);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {//get method for daysToExpire
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {//set method for daysToExpire
        this.daysToExpire = daysToExpire;
    }

    @Override
    public float calculatePrice(int quantity) {//calculate price for quantity based items
        return quantity*this.getPrice();
    }

    @Override
    public float calculatePrice(float weight) {//calculate price for weight based items
        return weight*this.getPrice();
    }


}
