import core.CombatEngine;
import core.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Room;
import encounters.Goblin;
import entity.Monster;
import entity.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero");
        /*Monster goblin = new Goblin();*/
        MonsterFactory spawn = new MonsterFactory();
        Dungeon dungeon = new Dungeon(spawn, 5);


        System.out.println("Dungeon Rooms: \n");

        int roomNumber = 1;

        for (Room room : dungeon.getRoom()) {
            System.out.println("Room " + roomNumber + ": " + room.getDesc());
            roomNumber++;
        }

        System.out.println("\n--- Testing room encounters ---\n");
        for (Room room : dungeon.getRoom()) {
            room.enter(player);
            if (!player.isAlive()) {
                System.out.println("You have died. Game over.");
                break;
            }
        }
    }
}
