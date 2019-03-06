package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

@DisplayName("game test")
class GameTest {

    private Player pl01 = new Player("pl01"), pl02 = new Player("pl02");
    private Game sut = new Game(pl01, pl02);

    @Test
    void should_launch_game_and_return_no_winner() {
        IntStream points = IntStream.of(2, 4, 5, 7);
        Optional<Player> winner = sut.play(points);
        Assertions.assertEquals(winner, Optional.empty());
    }

    @Test
    void should_launch_game_and_return_pl01_winner() {
        IntStream points = IntStream.of(2, 4, 6, 8, 10);
        Optional<Player> winner = sut.play(points);
        Assertions.assertEquals(winner.get(), pl01);
    }

    @Test
    void should_launch_game_and_return_pl02_winner() {
        IntStream points = IntStream.of(1, 3, 5, 7);
        Optional<Player> winner = sut.play(points);
        Assertions.assertEquals(winner.get(), pl02);
    }


}