import java.util.*;
import java.util.concurrent.TimeUnit;

import Billing.Cart;
import Billing.Order;
import Inventory.DatabaseConnection;
import Inventory.ShoppingExceptions.InvalidProductIdException;
import Inventory.ShoppingExceptions.InvalidRetailerException;
import Inventory.ShoppingExceptions.OutOfStockException;

public class Main {
    public static void main(String[] args) { // this is where the program starts to run
        try {
            Cart cart = new Cart(); // create a new cart for the user

            welcome(); // greeting helper

            startShopping(cart); // get them shopping

            proceedToCart(cart); // once they say "No" to the previous method that asks them if they want to
            // continue shopping, we proceed to cart.

            // keep them shopping or ask them to close for as long as they do not want to check out
            while (!wantsToCheckout()) {
                if (wantsToLeave()) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Cya ;)");
                    System.exit(0);
                } else {
                    startShopping(cart);
                    proceedToCart(cart);
                }
            }

//            get them checked out
            checkout(cart);

            System.out.println("Cya :)");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    ask if they want to exit the application
    private static boolean wantsToLeave() throws InterruptedException {
        String answer = null;

        List<String> correctAnswers = Arrays.asList("Yes", "No");

        System.out.println();
        do {
            Scanner input = new Scanner(System.in);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Would you like to exit the application (your cart will be lost)? [Type: Yes/No]: ");
            answer = input.nextLine();

            System.out.println();
            if (!correctAnswers.contains(answer)) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Invalid answer. Enter Correctly!");
            }
            System.out.println();

        } while (!correctAnswers.contains(answer));

        return answer.equals("Yes");
    }

    //    for as long as they want to continue shopping, keep them browsing the menu
    private static void startShopping(Cart cart) throws InterruptedException{
        do {
            browse(cart);
        } while (wantsToContinueShopping());
    }

    //    ask if they want to check out
    private static boolean wantsToCheckout() throws InterruptedException {
        String answer = null;

        List<String> correctAnswers = Arrays.asList("Yes", "No");

        System.out.println();
        do {
            Scanner input = new Scanner(System.in);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Would you like to checkout? [Type: Yes/No]: ");
            answer = input.nextLine();

            System.out.println();
            if (!correctAnswers.contains(answer)) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Invalid answer. Enter Correctly!");
            }
            System.out.println();

        } while (!correctAnswers.contains(answer));

        return answer.equals("Yes");
    }

    //    ask them to enter billing information to check out and place order
    private static void checkout(Cart cart) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(2);
        System.out.println();
        System.out.println("Let's proceed to checkout!");
        System.out.println();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("Please enter billing information below");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("Credit Card Number: ");
        String creditCardNumber = input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("Expiry date: ");
        String expirationDate = input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("CVV: ");
        int cvv = input.nextInt();
        input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("Card Holder Name: ");
        String cardHolderName = input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("Billing Address: ");
        String billingAddress = input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("Shipping Address: ");
        String shippingAddress = input.nextLine();
        TimeUnit.SECONDS.sleep(1);

        System.out.print("Recipient's Name: ");
        String recipientName = input.nextLine();
        System.out.println();
        TimeUnit.SECONDS.sleep(1);

        Order od = new Order(
                creditCardNumber, expirationDate, cvv, cardHolderName, billingAddress, shippingAddress, recipientName
        );

        System.out.println(od);
        System.out.println();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("Order has been place!");

        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        new DatabaseConnection().update(cart);
        System.out.println();


    }

    //    proceed to cart and ask if they want to remove an item from cart
    private static void proceedToCart(Cart cart) throws InterruptedException {

        System.out.println(
                """
                Let's get you checked out!
                
                Here's the list of items in your cart:
                """
        );

        TimeUnit.SECONDS.sleep(2);
        System.out.println(cart);
        System.out.println();

        TimeUnit.SECONDS.sleep(2);

        if (cart.getCartSize() > 0) {
            while (wantsToRemoveAnItem()) {
                removeItemFromCart(cart);
            }
        }

    }

    //    remove item requested from cart
    private static void removeItemFromCart(Cart cart) throws InterruptedException {
        if (cart.getCartSize() == 0) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Cart is empty :(");
            System.out.println();
            return;
        }

        Scanner input = new Scanner(System.in);
        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Enter the ID of the Product you want to remove: ");
            int p_id = input.nextInt();

            System.out.println();
            if (!cart.contains(p_id)) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Invalid answer. Enter Correctly!");
            } else {
                cart.removeFromCart(p_id);
                break;
            }
            System.out.println();
        }

        System.out.println();
        TimeUnit.SECONDS.sleep(2);
        System.out.print("Successfully removed Product from Cart!");
        System.out.println();

        System.out.println();
        TimeUnit.SECONDS.sleep(2);
        System.out.print("Here's the updated Cart:");
        System.out.println(cart);
        System.out.println();

    }

    //    ask if they want to remove an item from cart
    private static boolean wantsToRemoveAnItem() throws InterruptedException {
        String answer = null;

        List<String> correctAnswers = Arrays.asList("Yes", "No");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Would you like to remove a Product from Cart? [Type: Yes/No (Enter Exactly!)]: ");
            answer = input.nextLine();

            System.out.println();
            if (!correctAnswers.contains(answer)) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Invalid answer. Enter Correctly!");
            }
            System.out.println();

        } while (!correctAnswers.contains(answer));

        return answer.equals("Yes");
    }

    //    ask if they want to continue shopping
    private static boolean wantsToContinueShopping() throws InterruptedException {
        String answer = null;

        List<String> correctAnswers = Arrays.asList("Yes", "No");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("Would you like to continue shopping? [Type: Yes/No]: ");
            answer = input.nextLine();

            System.out.println();
            if (!correctAnswers.contains(answer)) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Invalid answer. Enter Correctly!");
            }
            System.out.println();

        } while (!correctAnswers.contains(answer));

        return answer.equals("Yes");
    }

    //    print greeting
    private static void welcome() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println();
            System.out.println("HIII!!");
            System.out.println();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Welcome to the Grocery Marketplace! :)\n");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    helper to check if category is valid
    public static boolean validateCategory(String category) {
        List<String> categories = Arrays.asList("Dairy", "Bakery", "HouseHoldEssentials", "Produce", "Product");

        return categories.contains(category);
    }

    //    ask which category of products to browse
    public static String askForCategory() {

        String category = null;

        Scanner input = new Scanner(System.in);

        try {
            System.out.println();
            System.out.println("What category of Products would you like to browse today?");
            System.out.println();
            System.out.print(
                    """
                    Categories:
                        1. Dairy
                        2. Bakery
                        3. House Hold
                        4. Produce
                    """
            );
            System.out.println();

            TimeUnit.SECONDS.sleep(2);
            System.out.print("Enter the Category Name you want to browse exactly as you see it in the list: ");
            category = input.nextLine();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return category;
    }

    //    browse the category (print products in it) and add them to cart
    public static void browse(Cart cart) {
        try {
            String category = null;

            while (true) {
                category = askForCategory();
                System.out.println();

                if (category.equals("House Hold")) {
                    category = "HouseHoldEssentials";
                }

                if (validateCategory(category)) {
                    break;
                } else {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("!!Please enter a valid category!!");
                }
                TimeUnit.SECONDS.sleep(2);
            }

            System.out.println();
            System.out.println("Understood! ;)");
            System.out.println();
            TimeUnit.SECONDS.sleep(2);

//          print the products desired
            DatabaseConnection inventory = new DatabaseConnection();
            inventory.listProducts(category);
            TimeUnit.SECONDS.sleep(2);

            System.out.println();
            System.out.print(
                    """
                    Which Product would you like to purchase?
                    Enter id of Product exactly:\s"""
            );

            Scanner input = new Scanner(System.in);
            int productId = input.nextInt();
            TimeUnit.SECONDS.sleep(1);
            inventory.validateProductId(productId, category);

            System.out.println();
            System.out.println("Understood! ;)");
            System.out.println();
            TimeUnit.SECONDS.sleep(2);

            System.out.println();
            inventory.showRetailers(productId);
            System.out.println();
            TimeUnit.SECONDS.sleep(1);

            System.out.print("Enter the ID of the retailer you would like to purchase from: ");
            int retailerId = input.nextInt();

            System.out.println();
            inventory.validateRetailerId(retailerId, productId);
            System.out.println();

            System.out.print("Enter how many would you like to purchase: ");
            int quantity = input.nextInt();

            System.out.println();
            inventory.validateQuantity(productId, retailerId, quantity);
            System.out.println();

            TimeUnit.SECONDS.sleep(2);
            inventory.addToCart(retailerId, productId, quantity, category, cart);
            TimeUnit.SECONDS.sleep(1);

            System.out.println();
            System.out.println("Understood! ;)");
            TimeUnit.SECONDS.sleep(1);
            System.out.println();

            System.out.println();
            System.out.println("Adding them to cart!");
            System.out.println();

            System.out.println();
            System.out.println("The following items have been added to cart!");
            System.out.println();

            TimeUnit.SECONDS.sleep(1);
            System.out.println();
            System.out.println(cart);
            System.out.println();

        } catch (OutOfStockException | InvalidRetailerException | InvalidProductIdException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}