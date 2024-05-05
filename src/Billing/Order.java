package Billing;

public class Order extends Payment{
    private String shippingAddress;//address where order should be delivered
    private String name;//name of person order should be delivered to

    private final int  orderNumber;

    public Order(String creditCardNumber, String expirationDate, int cvv, String cardHolderName, String billingAddress, String shippingAddress, String name) {//constructor
        super(creditCardNumber, expirationDate, cvv, cardHolderName, billingAddress);
        this.shippingAddress = shippingAddress;
        this.name = name;
        this.orderNumber = Math.abs(this.hashCode());
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
        return this.orderNumber;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNumber + "\n" +
                "Name: " + name + "\n" +
                "Shipping Address: " + shippingAddress + "\n" +
                super.toString();
    }

    @Override
    public int hashCode() { // this will be used to generate the Billing.Order number
//        create a hashCode using the order recipient's name, cardholder name, and shipping address
        return this.name.hashCode() + this.getCardHolderName().hashCode() + this.shippingAddress.hashCode();
    }
}
