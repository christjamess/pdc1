/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */

public abstract class Animal {

    private String name;
    private int hunger;
    private int energy;
    private int fun;
    private int hygiene;
    private int bladder;
    private int social;

    public Animal(String name) {
        this.name = name;
        this.hunger = 50;
        this.energy = 50;
        this.fun = 50;
        this.hygiene = 50;
        this.bladder = 50;
        this.social = 50;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public int getFun() {
        return fun;
    }

    public int getHygiene() {
        return hygiene;
    }

    public int getBladder() {
        return bladder;
    }

    public int getSocial() {
        return social;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setFun(int fun) {
        this.fun = fun;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public void setBladder(int bladder) {
        this.bladder = bladder;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public void setAttributes(int hunger, int energy, int fun, int hygiene, int bladder, int social) {
        this.hunger = hunger;
        this.energy = energy;
        this.fun = fun;
        this.hygiene = hygiene;
        this.bladder = bladder;
        this.social = social;
    }

    // Abstract methods for fulfilling needs to be implemented by subclasses
    public abstract void fulfillHunger();

    public abstract void fulfillEnergy();

    public abstract void fulfillFun();

    public abstract void fulfillHygiene();

    public abstract void fulfillBladder();

    public abstract void fulfillSocial();
}

