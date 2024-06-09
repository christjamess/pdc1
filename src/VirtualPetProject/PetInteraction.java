/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author madis
 */
public class PetInteraction {

    private static final Map<String, Animal> petMap = new HashMap<>();
    private static final List<String> petNamesList = new ArrayList<>();

    public static void loadSavedPet() {
        FileHandler.loadSavedPets(petMap);
        if (petMap.isEmpty()) {
            UserInterface.displayMessage("No saved pets found.");
            return;
        }
        UserInterface.displaySavedPetsList(petMap);
        int choiceIndex = UserInterface.selectSavedPet(petMap);
        if (choiceIndex != -1) {
            String selectedPetName = petMap.keySet().toArray(new String[0])[choiceIndex];
            Animal petObject = petMap.get(selectedPetName);
            UserInterface.displayMessage("Data loaded successfully.");
            petObject.displayNeeds();
            interactWithPet(petObject);
        } else {
            UserInterface.displayMessage("Invalid selection.");
        }
    }

    public static void createNewPet() {
        int pet = UserInterface.selectPet();
        String filePath = FileHandler.getFilePath(pet);
        if (filePath == null) {
            UserInterface.displayMessage("Invalid pet selection.");
            return;
        }
        FileHandler.readFromFile(filePath); // Read file before prompting for pet name
        String petName = UserInterface.getPetName();
        petNamesList.add(petName);
        Animal petObject = VirtualPetLogic.createPet(pet, petName);
        if (petObject == null) {
            UserInterface.displayMessage("Invalid pet selection.");
            return;
        }
        petMap.put(petName, petObject);
        interactWithPet(petObject);
    }

    public static void interactWithPet(Animal petObject) {
        char choice;
        do {
            choice = UserInterface.getNeedChoice();
            if (Character.isDigit(choice)) {
                int need = Character.getNumericValue(choice);
                petObject.fulfillNeed(need);
                petObject.displayNeeds();
            } else if (choice == 'n') {
                createNewPet();
                return;
            } else if (choice == 'x') {
                handleExitChoice();
            } else {
                UserInterface.displayInvalidChoiceMessage();
            }
        } while (choice != 'x');
    }

    private static void handleExitChoice() {
        FileHandler.savePetRegistryToFile(petNamesList);
        UserInterface.displayMessage("\nWould you like to:");
        UserInterface.displayMessage("s. Save pet state");
        UserInterface.displayMessage("d. Delete saved file");
        char innerChoice;
        do {
            innerChoice = UserInterface.getUserChoice();
            switch (innerChoice) {
                case 's':
                    FileHandler.saveState(petMap);
                    UserInterface.displaySavedPetsBeforeExit();
                    break;
                case 'd':
                    FileHandler.deleteSavedFile();
                    UserInterface.displaySavedPetsBeforeExit();
                    break;
                default:
                    UserInterface.displayInvalidChoiceMessage();
            }
        } while (innerChoice != 's' && innerChoice != 'd');
        UserInterface.displayExitMenu();
    }
}
