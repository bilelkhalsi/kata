package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Player {

    private String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        score = Score.ZERO;
    }

    public void mark() {
        this.score = score.next();
    }

    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.join(",", "Player : " + name, " Score : " + score.getValue());
    }
}
