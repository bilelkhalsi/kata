package game;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static game.Score.WIN;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Game {

    private static final Predicate<Player> endGamePredicate = p -> WIN == p.getScore();

    /**
     * Return a winner if there is one.
     * @param whoMark
     * @return
     */
    public Optional<Player> play(Stream<Player> whoMark) {
        return whoMark.map(Player::withNextScore).filter(endGamePredicate).peek(System.out::println).findFirst();
    }


}
