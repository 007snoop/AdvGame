package encounters;

import entity.Monster;

public class Goblin extends Monster {
    // basic goblin encounter now uses super class
    public Goblin() {
        super("Goblin"
        ,15
        ,3
        ,3
        ,1
        , """
                              /(.-""-.)\\
                          |\\  \\/      \\/  /|
                          | \\ / =.  .= \\ / |
                          \\( \\   o\\/o   / )/
                           \\_, '-/  \\-' ,_/
                             /   \\__/   \\
                             \\ \\__/\\__/ /
                           ___\\ \\|--|/ /___
                         /`    \\      /    `\\
                        /       '----'       \\
                        """);
    }
}

