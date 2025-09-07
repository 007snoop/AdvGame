package dungeon;

import core.CombatEngine;
import core.MonsterFactory;
import entity.Monster;
import entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private Random rand = new Random();
    private final String desc;
    private final MonsterFactory mf;

    // grid attributes
    private char[][] grid;
    private boolean[][] explored;
    private int width, height;

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

    public Room(String desc, MonsterFactory mf, int width, int height) {
        this(desc, mf);
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        this.explored = new boolean[height][width];
        initializeGrid();
    }

    public void setExplored(boolean[][] explored) {
        this.explored = explored;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean[][] getExplored() {
        return explored;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public MonsterFactory getMf() {
        return mf;
    }

    public Random getRand() {
        return rand;
    }

    public String getDesc() {
        return desc;
    }

    public List<String> enter(Player player) {
        List<String> messages = new ArrayList<>();

        //enter the dungeons
        messages.add("You enter the room: " + desc);

        //check if there is an encounter
        if (Math.random() < 0.33) {
            Monster monster = mf.getRandomMonster();
            messages.add("A " + monster.getName() + " appears!");
            messages.addAll(CombatEngine.fight(player, monster, 1)); //** needs to be changed later to a choice **//
        } else {
            messages.add("The room is empty... for now.");
        }
        return messages;
    }

    private void initializeGrid() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
                    grid[y][x] = '#'; // walls
                } else {
                    grid[y][x] = '_'; // floors
                }
            }
        }
        int mx = rand.nextInt(width - 2) + 1;
        int my = rand.nextInt(height -2) + 1;
        grid[my][mx] = 'E';
    }

    public String display(Player player) {
        StringBuilder gridDisplay = new StringBuilder();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == player.getY() && x == player.getX()) {
                    gridDisplay.append('@');
                    explored[y][x] = true;
                } else  {
                    gridDisplay.append(grid[y][x]);
                }
            }
            gridDisplay.append('\n');
        }
        return gridDisplay.toString();
    }

    public boolean isWalkable(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return false;
        char tile = grid[y][x];
        return tile == '_';
    }

}
