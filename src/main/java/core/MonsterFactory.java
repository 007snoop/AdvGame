package core;

import dungeon.Dungeon;
import dungeon.Room;
import encounters.Bandit;
import encounters.Goblin;
import encounters.GoblinKing;
import entity.Monster;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
/* factory for encounter table, this is where you set up your random encounters.
* */
public class MonsterFactory {
    private Random rand = new Random();
    private static final List<Supplier<Monster>> regMonsters = List.of(
            Goblin::new,
            Bandit::new
            // add more here
    );

    public Monster getRandomMonster() {
        return regMonsters.get(rand.nextInt(regMonsters.size())).get();
    }

    public Monster getBossMonster() { return new GoblinKing(); }
}
