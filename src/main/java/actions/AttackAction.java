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

      public String playerAttack(Player player, Monster monster) {
         int damage = resolveAttack(player.getAttack(), player.getStrength(), monster.getDefence());

          if (damage == 0) return player.getName() + " misses!";
          monster.takeDamage(damage);
          return player.getName() + " hits " + monster.getName() + " for " + damage + "!";
      }

      public String monsterAttack(Monster monster, Player player) {
          int damage = resolveAttack(monster.getAttack(), monster.getStrength(), player.getDefence());

          if (damage == 0) return monster.getName() + " misses!";
          player.takeDamage(damage);
          return monster.getName() + " hits " + player.getName() + " for " + damage + "!";
      }
}
