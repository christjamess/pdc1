package VirtualPetProject;
 
/**
*
* @author madis
*/
 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
 
public class MainMenuGui {
    private JComboBox<String> animalDropdown;
    private List<Animal> animalList;
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenuGui().createAndShowGUI());
    }
 
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Virtual Pet Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
 
        JPanel panel = new JPanel();
        animalDropdown = new JComboBox<>();
        loadAnimals();
 
        JButton loadAnimalButton = new JButton("Load Selected Animal");
        loadAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAnimal = (String) animalDropdown.getSelectedItem();
                if (selectedAnimal != null) {
                    loadAnimal(selectedAnimal);
                }
            }
        });
 
        panel.add(animalDropdown);
        panel.add(loadAnimalButton);
        frame.add(panel);
        frame.setVisible(true);
    }
 
    private void loadAnimals() {
        animalList = DatabaseSetup.loadExistingPets();
        animalDropdown.removeAllItems();
        for (Animal animal : animalList) {
            animalDropdown.addItem(animal.getName());
        }
    }
 
    private void loadAnimal(String animalName) {
        Animal selectedAnimal = null;
 
        for (Animal animal : animalList) {
            if (animal.getName().equals(animalName)) {
                selectedAnimal = animal;
                break;
            }
        }
 
        if (selectedAnimal != null) {
            new GameplayFrameGUI(selectedAnimal).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pet not found.");
        }
    }
}
