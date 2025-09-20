import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
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
        Dungeon dungeon = new Dungeon(spawn, 5);
        Room room = new Room("Test room", spawn, 20,10);
        GameCore game = new GameCore(player, room);
        game.initScreen();
        game.run();



    }
}
