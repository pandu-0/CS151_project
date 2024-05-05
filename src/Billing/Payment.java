package Billing;

public class Payment {
    private String cardNumber; // credit/debit card number for payment
    private String expirationDate; //expiration date of credit card
    private int cvv; //cvv of credit card
    private String cardHolderName;//name of cardholder
    private String billingAddress;//address of cardholder

    public Payment(String creditCardNumber, String expirationDate, int cvv, String cardHolderName, String billingAddress) {//constructor
        this.cardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
        this.billingAddress = billingAddress;
    }

    public String getCardNumber() {//get method for cardNumber
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {//set method for cardNumber
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {//get method for expirationDate
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {//set method for expirationDate
        this.expirationDate = expirationDate;
    }

    public int getCvv() {//get method for cvv
        return cvv;
    }

    public void setCvv(int cvv) {//set method for cvv
        this.cvv = cvv;
    }

    public String getCardHolderName() {//get method for cardHolderName
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {//set method for cardHolderName
        this.cardHolderName = cardHolderName;
    }

    public String getBillingAddress() {//get method for billingAddress
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {//set method for billingAddress
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Payment info:\n" +
                "\t" + "Card Number: " + cardNumber + "\n" +
                "\t" + "Expiration Date: " + expirationDate + "\n" +
                "\t" + "CVV: " + cvv + "\n" +
                "\t" + "Cardholder Name: " + cardHolderName + "\n" +
                "\t" + "Billing Address: " + billingAddress + "\n";
    }
}
