package entity;

import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int attack;
    private int strength;
    private int defence;

    public Player(String name) {
        this.name = name;
        this.health = 30;
        this.attack = 5;
        this.strength = 1;
        this.defence = 1;
    }

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

    // setters for buffs and healing
    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    // isAlive check
    public Boolean isAlive() {
        return health > 0;
    }
}
