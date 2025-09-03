package dungeon;

import core.MonsterFactory;
import encounters.Goblin;
import entity.Monster;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovementTest {

    Player player = new Player("Hero");
    Monster goblin = new Goblin();
    MonsterFactory spawn = new MonsterFactory();
    Dungeon dungeon = new Dungeon(spawn, 5);
    Room room = new Room("Test room", spawn, 12,10);

    @Test
    @DisplayName("Player starting location")
    public void testPlayerStartsAtCorrectPosition() {
        assertEquals(1, player.getX(), "Player should start at x=1");
        assertEquals(1, player.getY(), "Player should start at y=1");
    }

    @Test
    @DisplayName("Tests player moves right")
    public void testPlayerMovesRight() {
        int oldX = player.getX();
        player.move(1,0,room);
        assertEquals(oldX + 1 , player.getX());
    }

    @Test
    @DisplayName("Tests player moves down")
    public void testPlayerMovesDown() {
        int oldY = player.getY();
        player.move(0,1,room);
        assertEquals(oldY + 1, player.getY());
    }

    @Test
    @DisplayName("Tests Players cannot move through walls")
    public void testPlayerCannotMoveThroughWall() {
        player.setX(0);
        player.setY(1);

        int oldX = player.getX();
        player.move(-1, 0, room);
        assertEquals(oldX, player.getX(), "Player should not move into a wall");
    }

    @Test
    @DisplayName("Tests Player should not leave bounds")
    public void testPlayerCannotLeaveRoomBounds() {
        player.setX(room.getWidth() - 1);
        int oldX = player.getX();
        player.move(1,0,room);
        assertEquals(oldX, player.getX(), "Player should not leave bounds of room");
    }

}
