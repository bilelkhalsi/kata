package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static game.Score.WIN;

@DisplayName("game test")
class GameTest {

    private Player pl01 = new Player("pl01"), pl02 = new Player("pl02");
    private Referee referee = new Referee("referee");
    private Game sut = Game.builder().referee(referee).firstPlayer(pl01).secondPlayer(pl02).build();

    @Nested
    @DisplayName("Test game builder")
    class BuilderTest {

        @Test
        @DisplayName("should create game instance")
        void should_build_game_instance() {
            Assertions.assertNotNull(Game.builder().referee(referee).firstPlayer(pl01).secondPlayer(pl02).build());
        }

        @Test
        @DisplayName("should throw exception : missing referee")
        void should_throw_missing_referee() {
            NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> Game.builder().firstPlayer(pl01).secondPlayer(pl02).build());
            Assertions.assertEquals("missing referee", exception.getMessage());
        }

        @Test
        @DisplayName("should throw exception : missing player")
        void should_throw_missing_player() {
            NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> Game.builder().referee(referee).firstPlayer(pl01).build());
            Assertions.assertEquals("missing player", exception.getMessage());
        }

    }

    @Test
    void should_launch_game_and_return_winner() {
        Player winner = sut.play();
        Assertions.assertNotNull(winner);
        Assertions.assertEquals(WIN, winner.getScore());
    }
}