package VirtualPetProject;
 
/**
*
* @author madis
*/
import javax.swing.*;
import java.awt.*;
 
public class GameplayFrameGUI extends JFrame {
    private PetInteraction petInteraction = new PetInteraction();
 
    public GameplayFrameGUI(Animal pet) {
        setTitle("Interact with " + pet.getName());
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 1));
 
        JButton hungerButton = new JButton("Fulfill Hunger");
        JButton socialButton = new JButton("Fulfill Social");
        JButton bladderButton = new JButton("Fulfill Bladder");
        JButton hygieneButton = new JButton("Fulfill Hygiene");
        JButton energyButton = new JButton("Fulfill Energy");
        JButton funButton = new JButton("Fulfill Fun");
 
        hungerButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '1'));
        socialButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '2'));
        bladderButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '3'));
        hygieneButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '4'));
        energyButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '5'));
        funButton.addActionListener(e -> petInteraction.fulfillNeed(pet, '6'));
 
        add(hungerButton);
        add(socialButton);
        add(bladderButton);
        add(hygieneButton);
        add(energyButton);
        add(funButton);
    }
}
