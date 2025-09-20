import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class lanterna {
    public static void main(String[] args) throws Exception {
        var terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(40,20));
        var screen = terminalFactory.createScreen();
        screen.startScreen();

        int playerX = 10, playerY = 10;

        boolean running = true;

        while (running) {
            screen.clear();

            //drawing water
            screen.setCharacter(5,5, new com.googlecode.lanterna.TextCharacter('~'
            , TextColor.ANSI.BLUE, TextColor.ANSI.BLACK));

            //drawing player
            screen.setCharacter(playerX,playerY, new com.googlecode.lanterna.TextCharacter('@'
            , TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK));

            screen.refresh();

            //wait for input
            KeyStroke key = screen.readInput();
            if (key == null) continue;

            if (key.getKeyType() == KeyType.Escape) {
                running = false;
            } else if (key.getKeyType()==KeyType.Character) {
                switch (key.getCharacter()) {
                    case 'w' -> playerY--;
                    case 's' -> playerY++;
                    case 'a' -> playerX--;
                    case 'd' -> playerX++;
                }
            }
        }
        screen.stopScreen();
    }
}
