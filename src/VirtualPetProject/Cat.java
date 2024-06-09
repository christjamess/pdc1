/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void fulfillHunger() {
        setHunger(getHunger() + 20);
        System.out.println(getName() + "'s hunger has been fulfilled.");
    }

    @Override
    public void fulfillEnergy() {
        setEnergy(getEnergy() + 20);
        System.out.println(getName() + " has rested and regained energy.");
    }

    @Override
    public void fulfillFun() {
        setFun(getFun() + 20);
        System.out.println(getName() + " has had some fun.");
    }

    @Override
    public void fulfillHygiene() {
        setHygiene(getHygiene() + 20);
        System.out.println(getName() + "'s hygiene has been improved.");
    }

    @Override
    public void fulfillBladder() {
        setBladder(getBladder() + 20);
        System.out.println(getName() + "'s bladder has been relieved.");
    }

    @Override
    public void fulfillSocial() {
        setSocial(getSocial() + 20);
        System.out.println(getName() + "'s social need has been fulfilled.");
    }
}
