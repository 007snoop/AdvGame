import core.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Room;
import entity.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero");
        /*Monster goblin = new Goblin();*/
        MonsterFactory spawn = new MonsterFactory();
        Dungeon dungeon = new Dungeon(spawn, 5);
        Room roomGrid = new Room("Test roomGrid", spawn, 8, 10);


        System.out.println("Dungeon Rooms: \n");

        int roomNumber = 1;

        for (Room room : dungeon.getRoom()) {
            System.out.println("Room " + roomNumber + ": " + room.getDesc());
            roomNumber++;
        }

        System.out.println("\n--- Testing roomGrid encounters ---\n");
        for (Room room : dungeon.getRoom()) {
            room.enter(player);
            if (!player.isAlive()) {
                System.out.println("You have died. Game over.");
                break;
            }
        }
        System.out.println("Inital roomGrid: ");
        System.out.println(roomGrid.display(player));

        System.out.println("\nMove right");
        player.move(1,0,roomGrid);
        System.out.println(roomGrid.display(player));
    }
}
