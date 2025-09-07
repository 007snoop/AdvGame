package dungeon;

import core.MonsterFactory;
import entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {
    private List<Room> room = new ArrayList<>();
    private Random rand = new Random();

    public Dungeon(MonsterFactory mf, int roomCount) {
        List<String> availableDesc = new ArrayList<>(List.of(Room.ROOM_DESC));
        for (int i = 0; i < roomCount; i++) {
            if (availableDesc.isEmpty()) break;
            int index = rand.nextInt(availableDesc.size());
            String desc = availableDesc.remove(index);


            //boss room
            Room bossRoom = new Room(desc, mf);
            if (i == roomCount -1) {
                Monster boss = mf.getBossMonster();
                bossRoom.setBoss(boss);
            }

            room.add(new Room(desc, mf));
        }
    }

    public List<Room> getRoom() {
        return room;
    }
}
