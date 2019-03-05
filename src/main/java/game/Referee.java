package game;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Referee {

    public static final BiFunction<Player, Player, Player> whoMark = (pl01, pl02) -> {
        int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        return (random % 2 == 0) ? pl01 : pl02;
    };

    private String name;

    public Referee(String name) {
        this.name = name;
    }
}
