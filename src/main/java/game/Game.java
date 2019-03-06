package game;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static game.Score.*;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Game {


    private Player pl01;
    private Player pl02;

    private Predicate<Player> endGamePredicate = p -> WIN == p.getScore();
    private Predicate<Player> deuce = p -> pl01.getScore() == pl02.getScore() && p.getScore() == FORTY;
    private Predicate<Player> shouldResetAdv = p -> (pl01.getScore() == ADV || pl02.getScore() == ADV ) && p.getScore() == FORTY;
    private Predicate<Player> shouldWin = p -> Math.abs(pl01.getScore().getValue() - pl02.getScore().getValue()) >= 1 && p.getScore().getValue() >= FORTY.getValue();

    public Game(Player pl01, Player pl02) {
        this.pl01 = pl01.withScore(ZERO);
        this.pl02 = pl02.withScore(ZERO);
    }

    /**
     * Start game.
     * @param pointStream stream of points
     * @return optional of winner
     */
    public Optional<Player> play(IntStream pointStream) {
        return pointStream.boxed().map(i -> i % 2 == 0 ? pl01 : pl02)
            .map(this::applyDeuce)
            .peek(pl -> System.out.println("Goal : " + pl))
            .filter(endGamePredicate).findFirst();
    }


    /**
     * Apply update score rules.
     * @param pl player who won a point
     * @return player with updated score.
     */
    private Player applyDeuce(Player pl) {
        if (deuce.test(pl)) { // DEUCE ACTIVATED
            return pl.withNextScore();
        }
        if (shouldResetAdv.test(pl)) { // RESET TO DEUCE
            pl01.withScore(FORTY);
            pl02.withScore(FORTY);
            return pl;
        }
        if (shouldWin.test(pl)) {
            return pl01.getScore().getValue() > pl02.getScore().getValue() ? pl01.withScore(WIN) : pl02.withScore(WIN);
        }

        return pl.withNextScore();
    }


}
