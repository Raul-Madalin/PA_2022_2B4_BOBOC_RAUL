package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    public LinkedBlockingQueue<Player> currentPlayer = new LinkedBlockingQueue<>(1);
    private final long maxTime = 30;   // delay in milis
    public final LinkedBlockingQueue<Integer> maxTimer = new LinkedBlockingQueue<>(1);

    private void startTimer() {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (maxTimer) {
                    maxTimer.notify();
                }
            }
        },
                maxTime * 1000);    // delay to seconds
    }
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        dictionary.populateList();
        for (Player player : players) {
            Runnable runnable = new Player(player.getName(), this, true);
            Thread thread =new Thread(runnable);
            thread.start();
        }

        startTimer();
        synchronized (maxTimer) {
            try {
                maxTimer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Player player : players) {
            player.setRunning(false);
            if (player.getScore() > 0 && player.getName().compareTo("Player 1") == 0)
                System.out.println(player.getName() + " wins !");
            if (player.getScore() < 0 && player.getName().compareTo("Player 2") == 0)
                System.out.println(player.getName() + " wins !");
            if (player.getScore() == 0)
                System.out.println("Tie !");
        }
        System.out.println("Ended game...");
        System.exit(1);
    }
    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1",game, true));
        game.addPlayer(new Player("Player 2", game, true));
        game.play();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }
}