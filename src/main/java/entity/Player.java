package entity;

import dungeon.Room;

import java.util.Random;

public class Player {
    protected String name;
    protected int health, attack, strength, defence, y, x;

    public Player(String name) {
        this.name = name;
        this.health = 30;
        this.attack = 5;
        this.strength = 1;
        this.defence = 1;

        this.y = 1;
        this.x = 1;
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setName(String name) {
        this.name = name;
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

    // movement in room
    public void move(int dx, int dy, Room room) {
        int newX = x + dx;
        int newY = y + dy;

        if (room.isWalkable(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            System.out.println("Cannot move there.");
        }
    }
}
