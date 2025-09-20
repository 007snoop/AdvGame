import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import core.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Room;
import entity.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean running = true;
        // start screen

        // create terminal
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(80,24));
        Terminal terminal = terminalFactory.createTerminal();
        //wrap it into screen
        Screen screen = new TerminalScreen(terminal);
        // start screen session
        screen.startScreen();
        //get screen size
        TerminalSize size = screen.getTerminalSize();
        int w = size.getColumns() - 31;
        int h = size.getRows() - 8; // keep 4 rows for UI


        //game setup
        Player player = new Player("Hero");
        /*Monster goblin = new Goblin();*/
        MonsterFactory spawn = new MonsterFactory();
        Dungeon dungeon = new Dungeon(spawn, 5);
        Room room = new Room("Test room", spawn, w, h);

        while (running) {


            room.render(screen, player);
            screen.refresh();

            //wait for input
            KeyStroke key = screen.readInput();
            if (key == null) continue;

            if (key.getKeyType() == KeyType.Escape) {
                running = false;
                screen.stopScreen();
            } else if (key.getKeyType()==KeyType.Character) {
                switch (key.getCharacter()) {
                    case 'w' -> player.move(0, -1, room);
                    case 's' -> player.move(0,1,room);
                    case 'a' -> player.move(-1,0,room);
                    case 'd' -> player.move(1,0,room);
                }
            }
        }

    }
}
