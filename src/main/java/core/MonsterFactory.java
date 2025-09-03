package core;

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
    private static final List<Supplier<Monster>> monsters = List.of(
            Goblin::new,
            Bandit::new/*,
            GoblinKing::new */
            // add more here
    );

    public Monster getRandomMonster() {
        return monsters.get(rand.nextInt(monsters.size())).get();
    }

}
