package actions;

import entity.Monster;
import entity.Player;
import java.util.Random;

public class AttackAction {
      private Random rand = new Random();

      private int resolveAttack(int attack, int strength, int defence) {
         double hitChance = (double) attack / (attack + defence);
        if (rand.nextDouble() > hitChance) {
              return 0; // miss
        }
        int maxDamage = strength * 2;
        int damage = rand.nextInt(maxDamage +1);
        damage -= defence /2;

        return Math.max(damage, 0);
      }

      public int playerAttack(Player player, Monster monster) {
         int damage = resolveAttack(player.getAttack(), player.getStrength(), monster.getDefence());

          if (damage == 0) {
              System.out.println(player.getName() + " Misses.");
          } else {
              monster.takeDamage(damage);
              System.out.println(player.getName() + " hits " + monster.getName() + " for " + damage + " points of " +
                      "damage.");
          }
          return damage;
      }

      public int monsterAttack(Monster monster, Player player) {
          int damage = resolveAttack(monster.getAttack(), monster.getStrength(), player.getDefence());

          if (damage == 0) {
              System.out.println(monster.getName() + " Misses.");
          } else {
              player.takeDamage(damage);
              System.out.println(monster.getName() + " hits " + player.getName() + " for " + damage + " points of " +
                      "damage.");
          }
          return damage;
      }
}
