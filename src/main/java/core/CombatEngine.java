package core;

import actions.AttackAction;
import entity.Monster;
import entity.Player;

import java.util.Scanner;

public class CombatEngine {
    private static Scanner scanner = new Scanner(System.in);
    private static AttackAction atkAct = new AttackAction();

    public static void fight(Player player, Monster monster) {
        while (player.isAlive() && monster.isAlive()) {
            System.out.println("\nYour turn! Choose an action: ");
            System.out.println("1. Attack");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> atkAct.playerAttack(player, monster);
                default -> System.out.println("Invalid choice.");
            }

            if (monster.isAlive()) {
                atkAct.monsterAttack(monster, player);
            }
            System.out.println("\n[Status]");
            System.out.println(player.getName() + " HP: " + player.getHealth());
            System.out.println(monster.getName() + " HP: " + monster.getHealth());

        }
        if (player.isAlive()) {
            System.out.println("\nYou defeated the " + monster.getName() + "!");
        } else {
            System.out.println("\nYou were slain by the " + monster.getName() + "...");
        }
    }
}
