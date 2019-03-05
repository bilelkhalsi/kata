package game;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Launcher {

    public static void main(String[] args) {
        Player pl01 = new Player("PL01");
        Player pl02 = new Player("PL02");

        Supplier<Player>  goalSupplier =  () -> new Random().nextInt()%2 == 0 ? pl01 : pl02;
        Stream<Player> goalStream = Stream.generate(goalSupplier).peek(System.out::println);
        Supplier<Optional<Player>> winnerSupplier = () -> new Game().play(goalStream);
        System.out.println(Stream.generate(winnerSupplier).filter(Optional::isPresent).findFirst().get().toString());
    }
}
