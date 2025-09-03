package dungeon;

import core.MonsterFactory;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Room> room = new ArrayList<>();

    public Dungeon(MonsterFactory mf, int roomCount) {
        for (int i = 0; i < roomCount; i++) {
            room.add(new Room(mf));
        }
    }

    public List<Room> getRoom() {
        return room;
    }
}
