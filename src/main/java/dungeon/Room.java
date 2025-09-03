package dungeon;

import core.CombatEngine;
import core.MonsterFactory;
import entity.Monster;
import entity.Player;

import java.util.Random;

public class Room {
    private Random rand = new Random();
    private final String desc;
    private final MonsterFactory mf;

    // room list
    private static final String[] ROOM_DESC = {
            "a dark, damp cave with dripping water",
            "a torch-lit hall with strange carvings",
            "a crumbling stone chamber",
            "a narrow tunnel with eerie echoes",
            "an abandoned library full of dust"
            // add more here

    };

    public Room( MonsterFactory mf) {
        this.desc = ROOM_DESC[rand.nextInt(ROOM_DESC.length)];
        this.mf = mf;
    }

    public String getDesc() {
        return desc;
    }

    public void enter(Player player) {
        System.out.println("\nYou enter the room: " + desc);

        // 33% encounter chance
        if (Math.random() < 0.33) {
            Monster monster = mf.getRandomMonster();
            System.out.println("A " + monster.getName() + " appears!");
            CombatEngine.fight(player,monster);
        } else {
            System.out.println("The room is empty... for now.");
        }
    }
}
