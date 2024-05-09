package Purchasable;

import java.util.*;

public abstract class Product {
    private int id; // product id
    private String name; // product name
    private String description; // product description
    private float price; // product price
    int retailer_id; // List of possible retailers
    private int quantity; // quantity being purchased
    private float weight; // weight of item

    // constructor
    public Product(int id, String name, String description, float price, int retailer_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.retailer_id = retailer_id;
    }

    public Product() {

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

    public int getRetailer_id() {
        return this.retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    public int getQuantity() {//get method for quantity
        return quantity;
    }

    public void setQuantity(int quantity) { //set method for quantity
        this.quantity = quantity;
    }

    public float getWeight() {//get method for weight
        return weight;
    }

    public void setWeight(float weight) {//set method for weight
        this.weight = weight;
    }

    public void changeQuantityWeight(int quantity){//method to change quantity of item
        this.setQuantity(quantity);
    }

    public void changeQuantityWeight(float weight){//method to change weight of item
        this.setWeight(weight);
    }

    public abstract float calculatePrice(); // abstract method to calculate price item

    @Override
    public String toString() {

        return String.format(
                "Product\nname: %s\n\tid: %d\n\tDescription: %s\n\tPrice: $%.2f\n\tQuantity: %d\n\t",
                this.name,
                this.id,
                this.description,
                this.calculatePrice(),
                this.quantity
        );
    }
}
