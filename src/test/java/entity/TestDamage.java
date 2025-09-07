package entity;

import actions.AttackAction;
import core.CombatResult;
import entity.Monster;
import entity.Player;
import encounters.Goblin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDamage {

    private Player player;
    private Monster goblin;
    private AttackAction attackAction;

    @BeforeEach
    void setUp() {
        player = new Player("Hero");
        goblin = new Goblin();   // assume default stats: HP=15, Attack=3, Strength=3, Defence=1
        attackAction = new AttackAction();
    }

    @Test
    void testPlayerDealsDamage() {
        int originalHP = goblin.getHealth();
        CombatResult damage = attackAction.playerAttack(player, goblin);

        // goblin HP should decrease by damage
        assertEquals(originalHP - damage.getDamage(), goblin.getHealth());

        // damage cannot be negative
        assertTrue(damage.getDamage() >= 0);

        // damage should never exceed player's max potential
        int maxDamage = player.getStrength() * 2;
        assertTrue(damage.getDamage() <= maxDamage);
    }

    @Test
    void testPlayerMissChance() {
        // Temporarily create a monster with super high defence to force a miss
        Monster tank = new Goblin();
        tank.setDefence(1000);

        CombatResult damage = attackAction.playerAttack(player, tank);
        assertEquals(0, damage.getDamage());  // should miss
        assertEquals(1000, tank.getDefence());
    }

    @Test
    void testMonsterDealsDamage() {
        int originalHP = player.getHealth();
        CombatResult damage = attackAction.monsterAttack(goblin, player);

        // player HP should decrease by damage
        assertEquals(originalHP - damage.getDamage(), player.getHealth());

        // damage cannot be negative
        assertTrue(damage.getDamage() >= 0);

        // damage should never exceed monster's max potential
        int maxDamage = goblin.getStrength() * 2;
        assertTrue(damage.getDamage() <= maxDamage);
    }
}
