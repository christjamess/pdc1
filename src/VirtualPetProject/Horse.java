/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.util.InputMismatchException;

/**
 *
 * @author madis
 */
public class Horse extends Animal {

    public Horse(String petName) {
        super(petName);
    }

    @Override
    public void fulfillNeed(int need) {

        switch (need) {
            case 1: // Hunger
                fulfillHunger();
                break;
            case 2: // Social
                fulfillSocial();
                break;
            case 3: // Bladder
                fulfillBladder();
                break;
            case 4: // Hygiene
                fulfillHygiene();
                break;
            case 5: // Energy
                fulfillEnergy();
                break;
            case 6: // Fun
                fulfillFun();
                break;
            default:
                System.out.println("Invalid need for a Horse.");
        }
    }

    @Override
    public void fulfillHunger() {
        int foodOption;
        do {
            System.out.println("\nWhat food should " + petName + " eat?");
            System.out.println("1. Hay\n2. Oats\n3. Carrots");
            try {
                foodOption = UserInterface.getUserIntChoice();
                switch (foodOption) {
                    case 1:
                        System.out.println("\nYou fed " + petName + " hay.");
                        setHunger(getHunger() + 25);
                        setSocial(getSocial() + 5);
                        setBladder(getBladder() - 10);
                        setEnergy(getEnergy() + 10);
                        setFun(getFun() + 5);
                        break;
                    case 2:
                        System.out.println("\nYou fed " + petName + " oats.");
                        setHunger(getHunger() + 20);
                        setSocial(getSocial() + 5);
                        setBladder(getBladder() - 10);
                        setEnergy(getEnergy() + 5);
                        setFun(getFun() + 10);
                        break;
                    case 3:
                        System.out.println("\nYou fed " + petName + " a carrots.");
                        setHunger(getHunger() + 15);
                        setSocial(getSocial() + 10);
                        setBladder(getBladder() - 5);
                        setEnergy(getEnergy() + 5);
                        setFun(getFun() + 15);
                        break;
                    default:
                        System.out.println("Invalid food option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                foodOption = -1;
            }
        } while (foodOption < 1 || foodOption > 3);
    }

    @Override
    public void fulfillSocial() {
        int socialOption;
        do {
            System.out.println("What social activity do you want to do with " + petName + "?");
            System.out.println("1. Pet\n2. Groom\n3. Ride");
            try {
                socialOption = UserInterface.getUserIntChoice();
                switch (socialOption) {
                    case 1:
                        System.out.println("You pet " + petName);
                        setSocial(getSocial() + 30);
                        setHunger(getHunger() - 10);
                        setEnergy(getEnergy() + 10);
                        setFun(getFun() + 20);

                        break;
                    case 2:
                        System.out.println("You groomed " + petName);
                        setSocial(getSocial() + 40);
                        setHunger(getHunger() - 5);
                        setEnergy(getEnergy() + 15);
                        setFun(getFun() + 20);
                        break;
                    case 3:
                        System.out.println("You rode on " + petName);
                        setSocial(getSocial() + 20);
                        setFun(getFun() + 10);
                        setEnergy(getEnergy() - 25);
                        break;
                    default:
                        System.out.println("Invalid social activity option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                socialOption = -1;
            }
        } while (socialOption < 1 || socialOption > 3);
    }

    @Override
    public void fulfillBladder() {
        System.out.println(petName + " relieved itself.");
        setBladder(getBladder() + 40);
        setHygiene(getHygiene() - 10);
    }

    @Override
    public void fulfillHygiene() {
        System.out.println("You groomed " + petName);
        setHygiene(getHygiene() + 40);
    }

    @Override
    public void fulfillEnergy() {
        int energyOption;
        do {
            System.out.println("Should " + petName + " have a deep sleep or quick nap?");
            System.out.println("1. Sleep\n2. Nap");
            try {
                energyOption = UserInterface.getUserIntChoice();
                switch (energyOption) {
                    case 1:
                        System.out.println(petName + " had a deep sleep.");
                        setEnergy(getEnergy() + 40);
                        setHunger(getHunger() - 20);
                        setSocial(getSocial() - 15);
                        setBladder(getBladder() - 20);
                        setFun(getFun() - 10);
                        break;
                    case 2:
                        System.out.println(petName + " took a quick nap.");
                        setEnergy(getEnergy() + 25);
                        setHunger(getHunger() - 10);
                        setSocial(getSocial() - 5);
                        setBladder(getBladder() - 10);
                        setFun(getFun() - 5);
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                energyOption = -1;
            }
        } while (energyOption < 1 || energyOption > 2);

    }

    @Override
    public void fulfillFun() {
        int funOption;
        do {
            System.out.println("What should " + petName + " do for fun?");
            System.out.println("1. Gallop in the field\n2. Jump over obstacles\n3. Trot in circles");
            try {
                funOption = UserInterface.getUserIntChoice();;
                switch (funOption) {
                    case 1:
                        System.out.println(petName + " galloped in the fields.");
                        setFun(getFun() + 40);
                        setEnergy(getEnergy() - 30);
                        setHunger(getHunger() - 20);
                        setHygiene(getHygiene() - 25);
                        break;
                    case 2:
                        System.out.println(petName + " jumped over obstacles.");
                        setFun(getFun() + 30);
                        setEnergy(getEnergy() - 25);
                        setHunger(getHunger() - 20);
                        setHygiene(getHygiene() - 20);
                        break;
                    case 3:
                        System.out.println(petName + " trotted in circles.");
                        setFun(getFun() + 2);
                        setEnergy(getEnergy() - 10);
                        setHunger(getHunger() - 10);
                        setHygiene(getHygiene() - 15);
                        break;
                    default:
                        System.out.println("Invalid fun activity option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                funOption = -1;
            }
        } while (funOption < 1 || funOption > 3);
    }

    @Override
    public void displayNeeds() {
        System.out.println("\nYour Horse's Current Needs:");
        System.out.println("Hunger: " + getHunger());
        System.out.println("Social: " + getSocial());
        System.out.println("Bladder: " + getBladder());
        System.out.println("Hygiene: " + getHygiene());
        System.out.println("Energy: " + getEnergy());
        System.out.println("Fun: " + getFun());
    }

    @Override
    public String toString() {
        return "Horse";
    }

}