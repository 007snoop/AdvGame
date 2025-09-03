import core.CombatEngine;
import encounters.Goblin;
import entity.Monster;
import entity.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero");
        Monster goblin = new Goblin();

        CombatEngine.fight(player, goblin);
    }
}
