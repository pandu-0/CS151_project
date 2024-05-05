package Inventory;
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

    public static void main(String[] args) {
        // NOTE: Connection and Statement are AutoCloseable.
            //       Don't forget to close them both in order to avoid leaks.
            try
                    (
                        // create a database connection
                        Connection connection = new DatabaseConnection().connect();
                        Statement statement = connection.createStatement();
                    )
            {
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                ResultSet rs = statement.executeQuery("select * from Product");
                while(rs.next())
                {
                    // read the result set
                    System.out.println("name = " + rs.getString("name"));
                    System.out.println("id = " + rs.getInt("id"));
                }
            }
            catch(SQLException e)
            {
                // if the error message is "out of memory",
                // it probably means no database file is found
                e.printStackTrace(System.err);
            }
        }

}
