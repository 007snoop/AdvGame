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
import dungeon.Dungeon;
import dungeon.Room;
import entity.Player;

import java.io.IOException;
import java.util.List;

public class GameCore {
    public static final int UI_BUFFER = 5;
    private final Player player;
    private final Dungeon dungeon;
    private Screen screen;
    private boolean running = true;
    private int curRoomIndex = 0;

    public GameCore(Player player, Dungeon dungeon) {
        this.player = player;
        this.dungeon = dungeon;
    }

    // Initialize the terminal and screen
    public void initScreen(Room room) throws IOException {
        // set w h
        int w = room.getWidth();
        int h = room.getHeight() + UI_BUFFER;

        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(w,h))
                .createTerminal();

        screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.setCursorPosition(null); // hide cursor

        TerminalSize size = screen.getTerminalSize();
        System.out.println("Terminal size: " + size.getColumns() + "x" + size.getRows());
    }

    // Main game loop
    public void run() throws IOException {
        // Let player select a room first
        selectRoom();

        // Get the current room
        Room curRoom = dungeon.getRooms().get(curRoomIndex);


        // Main loop
        while (running) {
            screen.clear();
            // Render the room
            curRoom.render(screen, player);
            // Render UI below dungeon
            renderUI(curRoom);
            screen.refresh();
            // Read player input
            KeyStroke key = screen.readInput();
            if (key != null) {
                handleInput(key, curRoom);
            }
        }

        screen.stopScreen();
    }

    // Render player status bar
    private void renderUI(Room room) {
        TextGraphics tg = screen.newTextGraphics();
        int uiStartY = room.getHeight(); // start drawing below the room
        int legendX = room.getMaxRenderWidth() + 2; // start of legend.

        int cols = screen.getTerminalSize().getColumns();

        // Clear UI area
        for (int i = 0; i < UI_BUFFER; i++) {
            tg.setForegroundColor(TextColor.ANSI.BLACK);
            tg.putString(0, uiStartY + i, " ".repeat(cols));
        }

        // Draw player stats under map
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString(0, uiStartY, "HP: " + player.getHealth());
        tg.putString(0, uiStartY + 1, "ATK: " + player.getAttack() +
                " | STR: " + player.getStrength() +
                " | DEF: " + player.getDefence());
        tg.putString(0, uiStartY + 2, "Current room: " + room.getDesc());

        // Draw legend to the right
        tg.putString(legendX, 0, "Legend:");
        tg.putString(legendX, 1, "# = Wall");
        tg.putString(legendX, 2, "_ = Floor");
        tg.putString(legendX, 3, "~ = Water");
        tg.putString(legendX, 4, "E = Enemy");
        tg.putString(legendX, 5, "@ = Player");
    }

    // Handle player input
    private void handleInput(KeyStroke key, Room curRoom) {
        if (key.getKeyType() == KeyType.Escape) {
            running = false;
            return;
        }

        switch (key.getKeyType()) {
            case ArrowUp -> player.move(0, -1, curRoom);
            case ArrowDown -> player.move(0, 1, curRoom);
            case ArrowLeft -> player.move(-1, 0, curRoom);
            case ArrowRight -> player.move(1, 0, curRoom);
            case Character -> {
                switch (key.getCharacter()) {
                    case 'w' -> player.move(0, -1, curRoom);
                    case 's' -> player.move(0, 1, curRoom);
                    case 'a' -> player.move(-1, 0, curRoom);
                    case 'd' -> player.move(1, 0, curRoom);
                }
            }
        }
    }

    // Room selection screen before entering the dungeon
    private void selectRoom() throws IOException {
        List<Room> rooms = dungeon.getRooms();

        while (true) {
            renderDungeonMap(rooms);
            KeyStroke key = screen.readInput();
            if (key == null) continue;

            switch (key.getKeyType()) {
                case Escape -> { running = false; return; }
                case ArrowUp -> { if (curRoomIndex > 0) curRoomIndex--; }
                case ArrowDown -> { if (curRoomIndex < rooms.size() - 1) curRoomIndex++; }
                case Enter -> { return; }
            }
        }
    }

    // Render the list of rooms for selection
    private void renderDungeonMap(List<Room> rooms) throws IOException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.ANSI.CYAN);
        tg.putString(2, 0, "Select a Dungeon Room (Arrow keys, Enter to start):");

        for (int i = 0; i < rooms.size(); i++) {
            String desc = rooms.get(i).getDesc();
            if (i == curRoomIndex) {
                tg.setForegroundColor(TextColor.ANSI.YELLOW);
                tg.putString(0, i + 2, "> "); // arrow for selected room
            } else {
                tg.setForegroundColor(TextColor.ANSI.CYAN);
                tg.putString(0, i + 2, "  "); // no arrow
            }
            tg.putString(2, i + 2, (i + 1) + ". " + desc);
        }

        screen.refresh();
    }

    public Screen getScreen() {
        return screen;
    }
}
