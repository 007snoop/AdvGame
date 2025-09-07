package core;

import actions.AttackAction;
import entity.Monster;
import entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CombatEngine {

    private static final AttackAction atkAct = new AttackAction();

    public static List<String> fight(Player player, Monster monster, int chosenAction) {
        List<String> messages = new ArrayList<>();

        //player turn
        switch (chosenAction) {
            case 1 -> messages.add(atkAct.playerAttack(player, monster));
            default -> messages.add("Invalid Action.\n");
        }

        //monster turn if alive
        if (monster.isAlive()) {
            messages.add(atkAct.monsterAttack(monster, player));
        }

        //status
        messages.add(player.getName() + " HP: " + player.getHealth());
        messages.add(monster.getName() + " HP: " + monster.getHealth());

        return messages;
    }
}
