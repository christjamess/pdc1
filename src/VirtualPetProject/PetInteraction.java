/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;


/**
 *
 * @author madis
 */
public class PetInteraction {
    public void fulfillNeed(Animal pet, char needChoice) {
        switch (needChoice) {
            case '1':
                pet.fulfillHunger();
                break;
            case '2':
                pet.fulfillSocial();
                break;
            case '3':
                pet.fulfillBladder();
                break;
            case '4':
                pet.fulfillHygiene();
                break;
            case '5':
                pet.fulfillEnergy();
                break;
            case '6':
                pet.fulfillFun();
                break;
            default:
                System.out.println("Invalid need choice.");
        }
    }

    public void displayOptions() {
        System.out.println("Select a need to fulfill or press 'n' to create a new pet:");
        System.out.println("Select 'x' to exit.");
        System.out.println("1. Hunger\n2. Social\n3. Bladder\n4. Hygiene\n5. Energy\n6. Fun");
    }
}


