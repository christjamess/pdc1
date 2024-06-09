/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author madis
 */
public class FileHandler {
    
    public static String getFilePath(int pet) {
        switch (pet) {
            case 1:
                return "./resources/cat.txt";
            case 2:
                return "./resources/dog.txt";
            case 3:
                return "./resources/rabbit.txt";
            case 4:
                return "./resources/hamster.txt";
            case 5:
                return "./resources/horse.txt";
            default:
                return null;
        }
    }
    
    //Reading 1
    public static void readFromFile(String filePath) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                UserInterface.displayMessage(line);
            }
        } catch (FileNotFoundException e) {
            UserInterface.displayMessage("File not found.");
        } catch (IOException e) {
            UserInterface.displayMessage("Error reading the file.");
        }
    }
    
    //Writing 1
    public static void saveState(Map<String, Animal> petMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./resources/saveData.txt"))) {
            oos.writeObject(petMap);
            System.out.println("Pet state saved.");
        } catch (IOException e) {
            System.out.println("Error saving pet state: " + e.getMessage());
        }
    }
    
    //Reading 2
    public static void loadSavedPets(Map<String, Animal> petMap) {
        try {
            Map<String, Animal> savedPets;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./resources/saveData.txt"))) {
                savedPets = (Map<String, Animal>) ois.readObject();
                System.out.println("Saved pets loaded.");
            }
            petMap.putAll(savedPets);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading saved pets.");
        }
    }
    
    // Writing 2
    public static void savePetRegistryToFile(List<String> petData) {
        String filePath = "./resources/PetRegistry.txt";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            for (String data : petData) {
                writer.println(data);
            }
            System.out.println("New pets added to registry.");
        } catch (IOException e) {
            System.err.println("Error writing pet data to file.");
        }
    }
    
    
    //Reading 3
    public static void displayPetRegistryFromFile() {
        String filePath = "./resources/PetRegistry.txt";
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                UserInterface.displayMessage(line);
            }
        } catch (FileNotFoundException e) {
            UserInterface.displayMessage("File not found.");
        } catch (IOException e) {
            UserInterface.displayMessage("Error reading the file.");
        }
        
    }
    
    //delete
    public static void deleteSavedFile() {
        File file = new File("./resources/saveData.txt");
        if (file.delete()) {
            System.out.println("Saved pet file deleted.");
        } else {
            System.out.println("Error deleting saved pet file.");
        }
    }
    
}
