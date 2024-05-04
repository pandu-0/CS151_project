import java.util.Random;

public class Order extends Payment{
    private String shippingAddress;//address where order should be delivered
    private String name;//name of person order should be delivered to

    Random random = new Random();//initialize Random to generate random number
    private final int orderNumber = random.nextInt(10000);//generate random number less than 10000 and set that as order number

    public Order(String creditCardNumber, String expirationDate, int cvv, String cardHolderName, String billingAddress, String shippingAddress, String name) {//constructor
        super(creditCardNumber, expirationDate, cvv, cardHolderName, billingAddress);
        this.shippingAddress = shippingAddress;
        this.name = name;
    }

    public String getShippingAddress() {//get method for shippingAddress
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {//set method for shippingAddress
        this.shippingAddress = shippingAddress;
    }

    public String getName() {//get method for name
        return name;
    }

    public void setName(String name) {//set method for name
        this.name = name;
    }

    public int getOrderNumber() {//get method for orderNumber
        return orderNumber;
    }
}
