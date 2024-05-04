import java.util.List;

public abstract class NonExpired extends Product {

    public NonExpired(int id, String name, String description, float price, boolean quantityBased, List<Retailer> retailers) {//constructor for NonExpired class
        super(id, name, description, price, quantityBased, retailers);
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
