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
    public static final String[] ROOM_DESC = {
            "a dark, damp cave with dripping water",
            "a torch-lit hall with strange carvings",
            "a crumbling stone chamber",
            "a narrow tunnel with eerie echoes",
            "an abandoned library full of dust",
            "a shadowy cavern filled with eerie whispers",
            "a moss-covered hall with broken pillars",
            "a flooded tunnel with slippery stones",
            "a narrow spiral staircase winding down",
            "a chamber with glowing runes etched into the walls",
            "a library of crumbling tomes and cobwebs",
            "a torch-lit armory with rusted weapons",
            "a cold crypt lined with ancient sarcophagi",
            "a winding corridor with dripping stalactites",
            "a circular room with a strange magical sigil on the floor",
            "a collapsed hallway with rubble blocking the way",
            "a quiet sanctuary with faint sunlight streaming through cracks",
            "a dark pit where you can hear faint scratching noises",
            "a cavern echoing with distant growls",
            "a laboratory with shattered glass vials and alchemy tools",
            "a forge with cold, blackened furnaces",
            "a hall of statues, some broken and some watching silently",
            "a hidden shrine with offerings long decayed",
            "a tunnel with walls etched in blood-red symbols",
            "a room filled with strange, glowing mushrooms"
            // add more here

    };

    public Room( String desc, MonsterFactory mf ) {
        this.desc = desc;
        this.mf = mf;
    }

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
