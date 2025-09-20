package entity;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import dungeon.Room;

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

    public void handleInput(KeyStroke key, Room room) {
        if (key.getKeyType()== KeyType.Character) {
            Character c = key.getCharacter();

            if (c == null) return;
            switch (c) {
                case 'w' -> move(0, -1, room);
                case 's' -> move(0, 1, room);
                case 'a' -> move(-1, 0, room);
                case 'd' -> move(1, 0, room);
            }
        }
    }
}
