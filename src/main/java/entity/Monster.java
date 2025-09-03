package entity;
//basic monster class to build other monsters from
public abstract class Monster {
    protected String name;
    protected int health;
    protected int attack;
    protected int strength;
    protected int defence;
    protected String art;

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


    public void setName(String name) {
        this.name = name;
    }

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

    public void setArt(String art) {
        this.art = art;
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
