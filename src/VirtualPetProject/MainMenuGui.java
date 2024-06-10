package VirtualPetProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainMenuGui extends JFrame {
    public MainMenuGui() {
        setTitle("Virtual Pet Project");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JPanel panel = new JPanel(new BorderLayout());

        // Create a button to load animals
        JButton loadAnimalsButton = new JButton("Load Animals");
        loadAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadAnimals();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to load animals: " + ex.getMessage(),
                            "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(loadAnimalsButton, BorderLayout.CENTER);
        add(panel);
    }

    private void loadAnimals() throws SQLException {
        // Ensure the database connection is established
        Statement statement = DatabaseSetup.getStatement();
        if (statement != null) {
            try {
                String query = "SELECT * FROM Animals";
                ResultSet resultSet = statement.executeQuery(query);

                // Display animals in a simple message box for now
                StringBuilder animalsList = new StringBuilder("Animals:\n");
                while (resultSet.next()) {
                    animalsList.append(resultSet.getString("name"))
                               .append(" - ")
                               .append(resultSet.getString("type"))
                               .append("\n");
                }
                JOptionPane.showMessageDialog(null, animalsList.toString(), "Animals", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                throw new SQLException("Failed to load animals: " + e.getMessage());
            }
        } else {
            throw new SQLException("Database statement is null.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenuGui().setVisible(true);
            }
        });

        // Add shutdown hook to properly close the database
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                DatabaseSetup.shutdownDatabase();
            }
        }));
    }
}

