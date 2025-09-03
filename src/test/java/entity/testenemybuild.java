package entity;

import encounters.Goblin;
import org.junit.jupiter.api.Test;


public class testenemybuild {

    private String displayArt = "Monster Artwork: \n";
    private String displayStats = "Monster Stats: \n";
    @Test
    void GoblinDisplauArtTest() {
        Monster goblin = new Goblin();
        System.out.println(displayArt + goblin.getArt());
    }

    @Test
    void GoblinDisplayStats() {
        Monster goblin = new Goblin();
        System.out.println(displayStats
                + "Name: " + goblin.getName() + '\n'
                + "HP: " + goblin.getHealth() + '\n'
                + "Attack: " + goblin.getAttack() + '\n'
                + "Strength: " + goblin.getStrength() + '\n'
                + "Defence: " + goblin.getDefence());
    }
}
