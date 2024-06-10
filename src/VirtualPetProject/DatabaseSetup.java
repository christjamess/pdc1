package VirtualPetProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            establishConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void establishConnection() throws SQLException {
        try {
            // Load the embedded Derby driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            // Connect to the database, create it if it does not exist
            connection = DriverManager.getConnection("jdbc:derby:D:\\pdc1\\VirtualPetDb;create=true");
            statement = connection.createStatement();
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection: " + e.getMessage());
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
    }

    public static void shutdownDatabase() {
        try {
            if (connection != null) {
                try {
                    // Attempt to shut down the database
                    DriverManager.getConnection("jdbc:derby:D:\\pdc1\\VirtualPetDb;shutdown=true");
                } catch (SQLException se) {
                    if (!"08006".equals(se.getSQLState())) {
                        throw se;
                    }
                }
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Database shutdown error: " + e.getMessage());
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public static Connection getConnection() {
        return connection;
    }
}

