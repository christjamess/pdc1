package VirtualPetProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
*
* @author zenox
*/
 
 
public class DatabaseSetup {
 
    private static final String URL = "jdbc:derby:VirtualPetDb;create=true";
 
    private static Connection conn;
    private static Statement statement;
 
    static {
        try {
            // Load the Derby JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
 
            establishConnection();
            conn = getConnection();
            if (conn != null) {
                statement = conn.createStatement();
                initializeDatabase();
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Derby JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error during database setup: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public static Connection getConnection() {
        return conn;
    }
 
    private static void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL);
                System.out.println("Connected to database at " + URL);
            } catch (SQLException ex) {
                System.out.println("Failed to connect to the database: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
 
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
 
    private static void initializeDatabase() {
        try {
            statement.addBatch("CREATE TABLE PETS (NAME VARCHAR(50) NOT NULL, TYPE VARCHAR(10) NOT NULL, HUNGER INT, ENERGY INT, FUN INT, HYGIENE INT, BLADDER INT, SOCIAL INT)");
 
            // Insert initial pet data
            statement.addBatch("INSERT INTO PETS VALUES ('Tim', 'Cat', 30, 30, 30, 30, 30, 30),"
                    + "('Bob', 'Dog', 50, 50, 50, 50, 50, 50),"
                    + "('Max', 'Dog', 60, 40, 70, 30, 50, 50),"
                    + "('Kiki', 'Cat', 70, 30, 60, 40, 50, 50)");
 
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Error initializing database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public static List<Animal> loadExistingPets() {
        List<Animal> pets = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PETS");
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String type = resultSet.getString("TYPE");
                int hunger = resultSet.getInt("HUNGER");
                int energy = resultSet.getInt("ENERGY");
                int fun = resultSet.getInt("FUN");
                int hygiene = resultSet.getInt("HYGIENE");
                int bladder = resultSet.getInt("BLADDER");
                int social = resultSet.getInt("SOCIAL");
 
                Animal pet = createPet(name, type);
                if (pet != null) {
                    pet.setAttributes(hunger, energy, fun, hygiene, bladder, social);
                    pets.add(pet);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error loading pets: " + ex.getMessage());
            ex.printStackTrace();
        }
        return pets;
    }
 
    private static Animal createPet(String name, String type) {
        switch (type.toLowerCase()) {
            case "dog":
                return new Dog(name);
            case "cat":
                return new Cat(name);
            default:
                System.out.println("Unknown pet type: " + type);
                return null;
        }
    }
 
    public static void saveNewPet(Animal pet) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PETS WHERE NAME = '" + pet.getName() + "'");
            if (resultSet.next()) {
                try (PreparedStatement updateStatement = conn.prepareStatement(
                        "UPDATE PETS SET HUNGER = ?, ENERGY = ?, FUN = ?, HYGIENE = ?, BLADDER = ?, SOCIAL = ? WHERE NAME = ?")) {
                    updateStatement.setInt(1, pet.getHunger());
                    updateStatement.setInt(2, pet.getEnergy());
                    updateStatement.setInt(3, pet.getFun());
                    updateStatement.setInt(4, pet.getHygiene());
                    updateStatement.setInt(5, pet.getBladder());
                    updateStatement.setInt(6, pet.getSocial());
                    updateStatement.setString(7, pet.getName());
                    updateStatement.executeUpdate();
                }
            } else {
                try (PreparedStatement insertStatement = conn.prepareStatement(
                        "INSERT INTO PETS (NAME, TYPE, HUNGER, ENERGY, FUN, HYGIENE, BLADDER, SOCIAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
                    insertStatement.setString(1, pet.getName());
                    insertStatement.setString(2, pet instanceof Dog ? "Dog" : "Cat");
                    insertStatement.setInt(3, pet.getHunger());
                    insertStatement.setInt(4, pet.getEnergy());
                    insertStatement.setInt(5, pet.getFun());
                    insertStatement.setInt(6, pet.getHygiene());
                    insertStatement.setInt(7, pet.getBladder());
                    insertStatement.setInt(8, pet.getSocial());
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error saving pet: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
