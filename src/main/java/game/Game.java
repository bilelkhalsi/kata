package game;

import java.util.Objects;
import java.util.function.Predicate;

import static game.Score.WIN;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Game {


    private Player winner;

    private Player player1;

    private Player player2;

    private Referee referee;

    private static final Predicate<Player> continueGamePredicate = p -> WIN != p.getScore();

    private Game(Referee referee, Player player1, Player player2) {
        this.referee = referee;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player play() {
        Player p = player2;
        for (; continueGamePredicate.test(player1) && continueGamePredicate.test(player2); p = Referee.whoMark.apply(player1, player2)) {
            p.mark();
            System.out.println(toString());
        }
        this.winner = continueGamePredicate.test(player1) ? player2 : player1;
        return this.winner;
    }

    @Override
    public String toString() {
        return String.join("\n", "{", player1.toString(), player2.toString(), "}");
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Game builder
     */
    public static class Builder {

        private Player player1;

        private Player player2;

        private Referee referee;

        public Builder referee(Referee referee) {
            this.referee = referee;
            return this;
        }

        public Builder firstPlayer(Player player) {
            this.player1 = player;
            return this;
        }

        public Builder secondPlayer(Player player) {
            this.player2 = player;
            return this;
        }

        public Game build() {
            Objects.requireNonNull(this.referee, "missing referee");
            Objects.requireNonNull(this.player1, "missing player");
            Objects.requireNonNull(this.player2, "missing player");
            return new Game(referee, player1, player2);
        }
    }


}
