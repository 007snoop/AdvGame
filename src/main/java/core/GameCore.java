package core;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import dungeon.Room;
import entity.Player;

import java.io.IOException;

public class GameCore {
    private final Player player;
    private final Room room;
    private Screen screen;
    private boolean running = true;

    public GameCore(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    public void initScreen() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.setCursorPosition(null); // hide cursor

        TerminalSize size = screen.getTerminalSize();
        System.out.println("Terminal size: " + size.getColumns() + "x" + size.getRows());
    }

    public void run() throws IOException {
        while (running) {
            render();
            screen.refresh();

            KeyStroke key = screen.readInput();
            if (key != null) {
                handleInput(key);
            }
        }
        screen.stopScreen();
    }

    private void render() throws IOException {
        TextGraphics tg = screen.newTextGraphics();

        for (int y = 0; y < room.getHeight(); y++) {
            for (int x = 0; x < room.getWidth(); x++) {
                char ch = room.getGrid()[y][x];
                TextColor fg = switch (ch) {
                    case '~' -> TextColor.ANSI.BLUE;
                    case '_' -> TextColor.ANSI.GREEN;
                    case 'E' -> TextColor.ANSI.RED;
                    default -> TextColor.ANSI.WHITE;
                };

                if (x == player.getX() && y == player.getY()) {
                    ch = '@';
                    fg = TextColor.ANSI.YELLOW;
                }

                tg.setCharacter(x, y, new com.googlecode.lanterna.TextCharacter(ch, fg, TextColor.ANSI.BLACK));
            }
        }
    }

    private void handleInput(KeyStroke key) {
        if (key.getKeyType() == KeyType.Escape) {
            running = false;
            return;
        }

        switch (key.getKeyType()) {
            case ArrowUp -> player.move(0, -1, room);
            case ArrowDown -> player.move(0, 1, room);
            case ArrowLeft -> player.move(-1, 0, room);
            case ArrowRight -> player.move(1, 0, room);
            case Character -> {
                switch (key.getCharacter()) {
                    case 'w' -> player.move(0, -1, room);
                    case 's' -> player.move(0, 1, room);
                    case 'a' -> player.move(-1, 0, room);
                    case 'd' -> player.move(1, 0, room);
                }
            }
        }
    }

    public Screen getScreen() {
        return screen;
    }
}
