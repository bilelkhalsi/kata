package game;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Launcher {

    public static void main(String[] args) {
        Player pl01 = new Player("PL01");
        Player pl02 = new Player("PL02");

        IntStream pointStream = IntStream.iterate(1, i -> new Random().nextInt());

        new Game(pl01, pl02).play(pointStream);

    }
}
