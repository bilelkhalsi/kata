package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public class Launcher {

    public static void main(String[] args) {
        Referee referee = new Referee("REF#1");
        Player pl01 = new Player("PL01");
        Player pl02 = new Player("PL02");
        Game game = Game.builder().referee(referee).firstPlayer(pl01).secondPlayer(pl02).build();
        Player winner = game.play();
        System.out.println("===========SCORE===========");
        System.out.println(game.toString());
    }
}
