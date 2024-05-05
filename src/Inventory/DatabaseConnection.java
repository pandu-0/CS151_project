package Inventory;
import Billing.Cart;
import Inventory.ShoppingExceptions.InvalidProductIdException;
import Inventory.ShoppingExceptions.InvalidRetailerException;
import Inventory.ShoppingExceptions.OutOfStockException;
import Purchasable.Bakery;
import Purchasable.Dairy;
import Purchasable.HouseholdEssentials;
import Purchasable.Produce;
import Purchasable.Product;

import java.sql.*;

public class DatabaseConnection {
    public Connection connect() {

        String url = "jdbc:sqlite:src/Inventory/inventory.db"; // Change the path to your database file
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void update(Cart cart) {
        for (Product p : cart.getCartList()) {
            String query = String.format("""
                UPDATE Retailer
                SET quantity_available = quantity_available - %d
                WHERE Retailer.id = %d AND Retailer.product_id = %d;
                """, p.getQuantity(), p.getRetailer_id(), p.getId());
            try (Statement statement = connect().createStatement()){
                statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Inventory Updated!");
    }

    public void addToCart(int r_id, int p_id, int quantity, String category, Cart cart) throws OutOfStockException {
        System.out.println("cat: " + category);
        try ( Statement statement = connect().createStatement();) {

            String otherAttributes = getCategoryAttributes(category);

            String query = String.format("""
                    SELECT p.id AS p_id, name, description, price, %s
                    FROM Product p
                    JOIN %s t ON p.id = t.id
                    WHERE p.id = %d;
                    """, otherAttributes, category, p_id);

//            System.out.println("Query:");
//            System.out.println(query);
//            System.out.println();

            ResultSet rs = statement.executeQuery(query);

            String[] attributes = otherAttributes.split(",");

            while (rs.next()) {
                int id = rs.getInt("p_id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                float price = rs.getFloat("price");
                boolean firstOtherAttribute = (rs.getInt(attributes[0]) == 0);
                float secondOtherAttribute = Float.MIN_VALUE;

                if (attributes.length == 2) {
                    if (attributes[1].equals("daysToExpire")) {
                        secondOtherAttribute = rs.getInt(attributes[1]);
                    } else {
                        secondOtherAttribute = rs.getFloat(attributes[1]);
                    }
                }

                Product product = switch (attributes[0]) {
                    case "veganFriendly" ->
                            new Dairy(id, name, desc, price, (int) secondOtherAttribute, firstOtherAttribute, r_id);
                    case "glutenFree" ->
                            new Bakery(id, name, desc, price, (int) secondOtherAttribute, firstOtherAttribute, r_id);
                    case "environmentallyFriendly" ->
                            new HouseholdEssentials(id, name, desc, price, firstOtherAttribute, r_id);
                    case "organic" ->
                            new Produce(id, name, desc, price, firstOtherAttribute, secondOtherAttribute, r_id);
                    default -> null;
                };

                if (product != null) {
                    product.setQuantity(quantity);
                }

                cart.addToCart(product);

            }

        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
    }

    private String getCategoryAttributes(String category) {
        return switch (category) {
            case "Dairy" -> "veganFriendly,daysToExpire";
            case "Bakery" -> "glutenFree,daysToExpire";
            case "Produce" -> "organic,weight";
            default -> "environmentallyFriendly";
        };
    }

    public void showRetailers(int productId) {

        try ( Statement statement = connect().createStatement();) {

            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String query = String.format("""
                    SELECT r.id AS id, r.name AS r_name, city, p.name AS p_name, quantity_available
                    FROM Product p
                    JOIN Retailer r ON p.id = r.product_id
                    WHERE p.id = %d;
                    """, productId);

            ResultSet rs = statement.executeQuery(query);

            System.out.println("Retailers selling the item:");
            System.out.printf("%4s\t%25s\t%25s\t%20s\t%25s\n", "-ID-", "-Name-", "-City-", "-Product name-", "-Quantity Available-");

            while(rs.next()) {
                int id = rs.getInt("id");
                String r_name = rs.getString("r_name");
                String p_name = rs.getString("p_name");
                String city = rs.getString("city");
                int quantity_available = rs.getInt("quantity_available");

                // print the row
                System.out.printf("%4d\t%25s\t%25s\t%20s\t%25d\n", id, r_name, city, p_name, quantity_available);
            }

        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }


    }

    public void listProducts(String tableName) {

        try (Statement statement = connect().createStatement();) {

            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String query = String.format("""
                    SELECT p.id, name, description, price
                    FROM Product p
                    JOIN %s t ON p.id = t.id;
                    """, tableName);

            if (tableName.equals("Product")) {
                query = "SELECT id, name, description, price FROM Product";
            }

            ResultSet rs = statement.executeQuery(query);

            String table = (tableName.equals("Product") ? "All " : tableName);

            System.out.println(table + " Products:");
            System.out.printf("%4s\t%20s\t%25s\t%11s\n", "-ID-", "-Name-", "-Description-", "-Price-");

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                float price = rs.getFloat("price");

                // read the result set
                String row = String.format("%4d\t%20s\t%25s\t%,10.2f", id, name, desc, price);
                System.out.println(row);
            }

        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
    }

    public void validateQuantity(int p_id, int r_id, int quantity) throws OutOfStockException {

        try (Statement statement = connect().createStatement()) {
            String query = String.format("""
                        SELECT quantity_available
                        FROM Retailer
                        WHERE Retailer.id = %d AND Retailer.product_id = %d;
                        """, r_id, p_id);

            ResultSet rs = statement.executeQuery(query);

            if (rs.getInt("quantity_available") < quantity) {
                throw new OutOfStockException("Quantity exceeded stock availability");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateProductId(int p_id, String category)  throws InvalidProductIdException {
        try (Statement statement = connect().createStatement()) {

            String query = String.format("""
                        SELECT CASE
                        WHEN EXISTS (SELECT 1 FROM %s WHERE id = %d)
                        THEN 0 ELSE 1
                        END AS idExists;
                        """, category, p_id);

            ResultSet rs = statement.executeQuery(query);

            if (rs.getInt("idExists") == 1) {
                throw new InvalidProductIdException("Invalid ID Entered");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateRetailerId(int r_id, int p_id) throws InvalidRetailerException {

        try (Statement statement = connect().createStatement()) {
            String query = String.format("""
                        SELECT CASE
                        WHEN EXISTS (SELECT 1 FROM Retailer WHERE Retailer.id = %d AND Retailer.product_id = %d)
                        THEN 0 ELSE 1
                        END AS idExists;
                        """, r_id, p_id);

            ResultSet rs = statement.executeQuery(query);

            if (rs.getInt("idExists") == 1) {
                throw new InvalidRetailerException("Invalid ID entered");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
