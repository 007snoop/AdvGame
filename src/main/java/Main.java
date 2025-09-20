
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.*;
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
        Dungeon dungeon = new Dungeon(spawn, 1, 100, 20);
        Room room = dungeon.getRooms().getFirst();
        GameCore game = new GameCore(player, dungeon);
        game.initScreen(room);
        game.run();



    }
}
