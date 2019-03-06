package game;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author p091569 on 06/03/2019
 * @project Kata
 */
public class Match {

    private Map<Player, Integer> scores= new HashMap<>();
    private Predicate<Player> shouldWin = p -> scores.values().containsAll(Arrays.asList(6, 4));
    private Stream<Game> gameStream;

    public Match(Player pl01, Player pl02) {
        scores.put(pl01, 0);
        scores.put(pl02, 0);
        this.gameStream = Stream.generate(() -> new Game(pl01, pl02));
    }

    public Optional<Game> play() {
        return gameStream
            .filter(game -> game.play(IntStream.iterate(1, i -> new Random().nextInt())).isPresent())
            .peek(System.out::println)
            .peek(game -> {
                Player winner = game.winner().get();
                scores.put(winner, scores.get(winner) + 1 );
            })
            .filter(game -> shouldWin.test(game.winner().get()))
            .findFirst();
    }
}
