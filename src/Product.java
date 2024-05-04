import java.util.List;

public abstract class Product {
    private int id; //product id
    private String name;//product name
    private String description;//product description
    private float price;//product price
    List<Retailer> retailers; //List of possible retailers

    private boolean quantityBased;//variable for whether item is quantity or weight based

    public Product(int id, String name, String description, float price, boolean quantityBased, List<Retailer> retailers) {//constructor
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityBased = quantityBased;
        this.retailers = retailers;
    }

    public int getId() {//get method for id
        return id;
    }

    public void setId(int id) {//set method for id
        this.id = id;
    }

    public String getName() {//get method for name
        return name;
    }

    public void setName(String name) {//set method for name
        this.name = name;
    }

    public String getDescription() {//get method for description
        return description;
    }

    public void setDescription(String description) {//set method for description
        this.description = description;
    }

    public float getPrice() {//get method for price
        return price;
    }

    public void setPrice(float price) {//get method for price
        this.price = price;
    }

    public boolean isQuantityBased() {
        return quantityBased;
    }

    public void setQuantityBased(boolean quantityBased) {
        this.quantityBased = quantityBased;
    }

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

    public abstract float calculatePrice(int quantity);//abstract method to calculate price for quantity based items
    public abstract float calculatePrice(float weight);//abstract method to calculate price for weight based items
}
