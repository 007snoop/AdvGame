package entity;

import encounters.Goblin;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testenemybuild {

    // basic strings so i dont have to write them over and over
    private String displayArt = "Monster Artwork: \n";
    private String displayStats = "Monster Stats: \n";


    @Test
    @DisplayName("Basic Goblin art would should display")
    void GoblinDisplayArtTest() {
        Monster goblin = new Goblin();
        System.out.println(displayArt + goblin.getArt());
    }

    @Test
    @DisplayName("Should display basic stats for goblin")
    void GoblinDisplayStats() {
        Monster goblin = new Goblin();
        System.out.println(displayStats
                + "Name: " + goblin.getName() + '\n'
                + "HP: " + goblin.getHealth() + '\n'
                + "Attack: " + goblin.getAttack() + '\n'
                + "Strength: " + goblin.getStrength() + '\n'
                + "Defence: " + goblin.getDefence());
    }

    @Test
    @DisplayName("Checks and asserts basic stats are equal to build stats")
    void basicGoblinStatCheck() {
        Monster goblin = new Goblin();

        assertEquals("Goblin", goblin.getName(), "Name check");
        assertEquals(15, goblin.getHealth(), "HP check, basic should be 15");
        assertEquals(3, goblin.getAttack(), "Attack check, basic should be 3");
        assertEquals(3, goblin.getStrength(), "Strength check, basic should be 3");
        assertEquals(1, goblin.getDefence(), "Defence check, basic should be 1");

    }
}
