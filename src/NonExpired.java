import java.util.*;

public abstract class NonExpired extends Product {

    public NonExpired(int id, String name, String description, float price, boolean quantityBased, List<Retailer> retailers) {//constructor for NonExpired class
        super(id, name, description, price, quantityBased, retailers);
    }
}
