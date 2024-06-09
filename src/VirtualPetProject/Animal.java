/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.io.Serializable;

/**
 *
 * @author madis
 */

public abstract class Animal implements Serializable {
    
    protected String petName;
    private int hunger;
    private int social;
    private int bladder;
    private int hygiene;
    private int energy;
    private int fun;
    
    
    public Animal(){
        this.hunger = 50;
        this.social = 50;
        this.bladder = 50;
        this.hygiene = 50;
        this.energy = 50;
        this.fun = 50;
    }
    
    public Animal(String petName) {
        this();
        this.petName = petName;
    }
    
    // Getters and Setters
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = Math.max(0, Math.min(hunger, 100));
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = Math.max(0, Math.min(social, 100));
    }

    public int getBladder() {
        return bladder;
    }

    public void setBladder(int bladder) {
        this.bladder = Math.max(0, Math.min(bladder, 100));
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = Math.max(0, Math.min(hygiene, 100));
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, Math.min(energy, 100));
    }

    public int getFun() {
        return fun;
    }

    public void setFun(int fun) {
        this.fun = Math.max(0, Math.min(fun, 100));
    }
    
    public abstract void displayNeeds();
    
    public abstract void fulfillNeed(int need);
    
    public abstract void fulfillHunger();

    public abstract void fulfillSocial();
    
    public abstract void fulfillBladder();
    
    public abstract void fulfillHygiene();
    
    public abstract void fulfillEnergy();
    
    public abstract void fulfillFun();
    
}
