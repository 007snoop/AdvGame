package actions;

import core.CombatResult;
import entity.Monster;
import entity.Player;
import java.util.Random;

public class AttackAction {
      private Random rand = new Random();

      private CombatResult resolveAttack(int attack, int strength, int defence, String atkName, String defName) {
          double hitChance = (double) attack / (attack + defence);
          boolean hit = rand.nextDouble() <= hitChance;
          int damage = 0;
          if (hit) {
              int maxDamage = strength * 2;
              damage = rand.nextInt(maxDamage + 1);
              damage -= defence / 2;
              damage = Math.max(damage, 0);
          }

          //message for ui
          String message = hit
                  ? atkName + " hits " + defName + " for " + damage + "!"
                  : atkName + " misses.";

          return new CombatResult(damage, hit, message);
      }

      public CombatResult playerAttack(Player player, Monster monster) {
         CombatResult damage = resolveAttack(player.getAttack(), player.getStrength(), monster.getDefence(),
                 player.getName(), monster.getName());
         boolean hit = damage.getDamage() > 0;
         if (damage.isHit()) monster.takeDamage(damage.getDamage());
         return damage;
      }

      public CombatResult monsterAttack(Monster monster, Player player) {
          CombatResult damage = resolveAttack(monster.getAttack(), monster.getStrength(), player.getDefence(),
                  monster.getName(), player.getName());
          boolean hit = damage.getDamage() > 0;
          if (damage.isHit()) player.takeDamage(damage.getDamage());
          return damage;
      }
}
