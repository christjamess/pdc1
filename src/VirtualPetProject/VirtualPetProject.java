/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */
public class VirtualPetProject {

    public static void main(String[] args) {
        UserInterface.displayWelcomeMessage();

        char choice;
        do {
            choice = UserInterface.getMainMenuChoice();
            switch (choice) {
                case '1':
                    PetInteraction.createNewPet();
                    break;
                case '2':
                    PetInteraction.loadSavedPet();
                    break;
                case '3':
                    UserInterface.displayExitMenu();
                    return;                    
                default:
                    UserInterface.displayInvalidChoiceMessage();
            }
        } while (choice != '3');

        UserInterface.closeScanner();
    }
    
}
