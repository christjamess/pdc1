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
    private static Scanner scanner = new Scanner(System.in);
    private PetInteraction petInteraction = new PetInteraction();

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Pet");
            System.out.println("2. Load Pet");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = getUserIntChoice();

            switch (choice) {
                case 1:
                    createPet();
                    break;
                case 2:
//                    loadPet();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createPet() {
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.println("Select pet type:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.print("Choose an option: ");
        int choice = getUserIntChoice();

        Animal pet;
        switch (choice) {
            case 1:
                pet = new Dog(name);
                break;
            case 2:
                pet = new Cat(name);
                break;
            default:
                System.out.println("Invalid pet type.");
                return;
        }

//        DatabaseSetup.saveNewPet(pet);
//        System.out.println("New pet created and saved: " + name);
    }

//    private void loadPet() {
//        List<Animal> pets = DatabaseSetup.loadExistingPets();
//        if (pets.isEmpty()) {
//            System.out.println("No pets found in the database.");
//            return;
//        }
//
//        System.out.println("Select a pet to load:");
//        for (int i = 0; i < pets.size(); i++) {
//            System.out.println((i + 1) + ". " + pets.get(i).getName());
//        }
//        System.out.print("Enter the number of the pet you want to load: ");
//        int choice = getUserIntChoice();
//
//        if (choice < 1 || choice > pets.size()) {
//            System.out.println("Invalid choice.");
//            return;
//        }
//
//        Animal pet = pets.get(choice - 1);
//        interactWithPet(pet);
//    }

    private void interactWithPet(Animal pet) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Interacting with " + pet.getName());
            System.out.println("1. Fulfill Hunger");
            System.out.println("2. Fulfill Social");
            System.out.println("3. Fulfill Bladder");
            System.out.println("4. Fulfill Hygiene");
            System.out.println("5. Fulfill Energy");
            System.out.println("6. Fulfill Fun");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = getUserIntChoice();

            switch (choice) {
                case 1:
                    petInteraction.fulfillNeed(pet, '1');
                    break;
                case 2:
                    petInteraction.fulfillNeed(pet, '2');
                    break;
                case 3:
                    petInteraction.fulfillNeed(pet, '3');
                    break;
                case 4:
                    petInteraction.fulfillNeed(pet, '4');
                    break;
                case 5:
                    petInteraction.fulfillNeed(pet, '5');
                    break;
                case 6:
                    petInteraction.fulfillNeed(pet, '6');
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static int getUserIntChoice() {
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear invalid input
            choice = -1;
        }
        return choice;
    }
}
