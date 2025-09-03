package entity;

import encounters.Bandit;
import encounters.Goblin;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//basic monster class to build other monsters from
public abstract class Monster {
    protected final String name, art;
    protected int health,attack,strength,defence;

    // constructor for super
    public Monster(String name, int health, int attack, int strength, int defence, String art) {
        this.name = name;
        this.art = art;
        this.health = health;
        this.attack = attack;
        this.strength = strength;
        this.defence = defence;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getStrength() {
        return strength;
    }
    public int getDefence() {
        return defence;
    }
    public String getArt() {
        return art;
    }
    //setters
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }

    // shared behavior
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }
    public Boolean isAlive() {
        return health > 0;
    }
}
