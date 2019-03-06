package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Launcher {

    public static void main(String[] args) {
        Player pl01 = new Player("PL01");
        Player pl02 = new Player("PL02");
        new Match(pl01, pl02).play();

    }
}
