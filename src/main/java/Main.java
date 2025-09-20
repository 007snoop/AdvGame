
import core.GameCore;
import core.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Room;
import entity.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //game setup
        Player player = new Player("Hero");
        /*Monster goblin = new Goblin();*/
        MonsterFactory spawn = new MonsterFactory();
        Dungeon dungeon = new Dungeon(spawn, 5, 20, 10);
       /* Room room = new Room("Test room", spawn, 20,10);*/
        GameCore game = new GameCore(player, dungeon);
        game.initScreen();
        game.run();



    }
}
