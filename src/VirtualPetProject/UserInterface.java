/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author madis
 */
public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to V-Pet!");
    }

    public static char getMainMenuChoice() {
        System.out.println("\nWould you like to:");
        System.out.println("1. Create a new pet");
        System.out.println("2. Load a saved pet");
        System.out.println("3. Exit");
        return scanner.next().charAt(0);
    }

    public static void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public static int selectPet() {
        int pet;
        System.out.println("Select your animal below:");
        System.out.println("1. Cat\n2. Dog\n3. Rabbit\n4. Hamster\n5. Horse");
        while (true) {
            try {
                pet = scanner.nextInt();
                if (pet < 1 || pet > 5) {
                    System.out.println("Invalid pet selection. Please try again:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return pet;
    }

    public static String getPetName() {
        System.out.println("Say hello to your new friend! What would you like to name them?");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displaySavedPetsList(Map<String, Animal> petMap) {
        System.out.println("Choose a pet to load:");
        int index = 1;
        for (String petName : petMap.keySet()) {
            System.out.println(index + ". " + petName);
            index++;
        }
    }

    public static int selectSavedPet(Map<String, Animal> petMap) {
        int petIndex;
        while (true) {
            try {
                petIndex = scanner.nextInt() - 1; 
                if (petIndex < 0 || petIndex >= petMap.size()) {
                    System.out.println("Invalid pet selection. Please try again:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return petIndex;
    }

    public static char getUserChoice() {
        return scanner.next().charAt(0);
    }

    public static char getNeedChoice() {
        System.out.println("Select a need to fulfill or press 'n' to create a new pet:\nSelect 'x' to exit.");
        System.out.println("1. Hunger\n2. Social\n3. Bladder\n4. Hygiene\n5. Energy\n6. Fun");
        return scanner.next().charAt(0);
    }


    public static void displaySavedPetsBeforeExit() {
        System.out.println("\nThank you for playing!\nView Your Pets before you go:");
        FileHandler.displayPetRegistryFromFile();
    }
    
    public static void displayExitMenu() {
        System.out.println("Exiting V-Pet. Goodbye!");
        System.exit(0);
    }
    
    public static int getUserIntChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input. Please enter a valid integer.");
            return getUserIntChoice();
        }
    }
    
    public static void closeScanner() {
        scanner.close();
    }

}
