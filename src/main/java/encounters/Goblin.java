package encounters;

public class Goblin {

    // goblin stats
    private String goblinArt;
    private String name;
    private int health;
    private int attack;
    private int strength;
    private int defence;

    // basic goblin encounter
    public Goblin() {
        this.name = "Goblin";
        this.health = 15;
        this.attack = 3;
        this.strength = 3;
        this.defence = 1;
        this.goblinArt = """
                         ,      ,
                        /(.-""-.)\\
                    |\\  \\/      \\/  /|
                    | \\ / =.  .= \\ / |
                    \\( \\   o\\/o   / )/
                     \\_, '-/  \\-' ,_/
                       /   \\__/   \\
                       \\ \\__/\\__/ /
                     ___\\ \\|--|/ /___
                   /`    \\      /    `\\
                  /       '----'       \\
            """;
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

    public String getGoblinArt() {
        return goblinArt;
    }

    public void setGoblinArt(String goblinArt) {
        this.goblinArt = goblinArt;
    }

    public void setHealth(int health) {
        this.health = health;
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
}

