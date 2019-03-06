package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Player {

    private String name;
    private Score score;

    public Player(String name) {
        this(name, Score.ZERO);
    }

    private Player(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public Player withNextScore() {
        this.score = score.next();
        return this;
    }

    public Player withScore(Score score) {
        this.score = score;
        return this;
    }

    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.join(",", "Player : " + name, " Score : " + score);
    }
}
