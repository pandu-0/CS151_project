package Billing;

public class Retailer {

    private int id;
    private String name; //retailer name
    private String city; //retailer city
    private String state; //retailer state

    public Retailer(int id, String name, String city, String state) { // constructor
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {//get method for name
        return name;
    }

    public void setName(String name) {//set method for name
        this.name = name;
    }

    public String getCity() {//get method for city
        return city;
    }

    public void setCity(String city) {//set method for city
        this.city = city;
    }

    public String getState() {//get method for state
        return state;
    }

    public void setState(String state) {//set method for state
        this.state = state;
    }

    @Override
    public String toString() {
        return  "Billing.Retailer name:" + name + "\n" +
                "City:" + city + "\n" +
                "State:" + state + "\n" ;
    }
}
