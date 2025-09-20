package dungeon;

import core.MonsterFactory;
import entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {
    private List<Room> rooms = new ArrayList<>();
    private Random rand = new Random();

    public Dungeon(MonsterFactory mf, int roomCount, int w, int h) {
        List<String> availableDesc = new ArrayList<>(List.of(Room.ROOM_DESC));
        for (int i = 0; i < roomCount; i++) {
            if (availableDesc.isEmpty()) break;
            int index = rand.nextInt(availableDesc.size());
            String desc = availableDesc.remove(index);

            Room room = new Room(desc, mf, w, h);
            if (i == roomCount -1) {
                Monster boss = mf.getBossMonster();
                room.setBoss(boss);
            }
            rooms.add(room);
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
