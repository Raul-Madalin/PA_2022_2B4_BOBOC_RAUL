package Setup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            System.out.println(player.getName());
            for(Player it : players){
                new Thread(it).start();
            }
            while(!bag.getLetters().isEmpty()){
                // TODO make players actually take letters out so the game can actually stop
            }
            for(Player it : players){
                it.setRunning(false);
            }
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static void main (String args[]) {
        Game game = new Game();
        var players = IntStream.rangeClosed(1,3).mapToObj(i -> new Player("Player" + i)).toArray(Player[]::new);
        IntStream.rangeClosed(0,2).forEach(i -> game.addPlayer(players[i]));
        game.play();
    }
}
