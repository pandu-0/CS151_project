public class Retailer {
    private String name; //retailer name
    private String city; //retailer city
    private String state; //retailer state

    public Retailer(String name, String city, String state) {//constructor
        this.name = name;
        this.city = city;
        this.state = state;
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
        return  "Retailer name:" + name + "\n" +
                "City:" + city + "\n" +
                "State:" + state + "\n" ;
    }
}
