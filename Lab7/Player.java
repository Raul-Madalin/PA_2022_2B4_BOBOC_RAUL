package Setup;

import Setup.Game;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player implements Runnable{

    private String name;
    private Game game;
    private boolean running;
    CopyOnWriteArrayList<Tile> hand = new CopyOnWriteArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CopyOnWriteArrayList<Tile> getHand() {
        return hand;
    }

    public void setHand(CopyOnWriteArrayList<Tile> hand) {
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word = extracted.toString();
        game.getBoard().addWord(this, word);
        return true;
    }

    @Override
    public void run() {
        hand.addAll(game.getBag().extractTiles(7));
        while(!running){
            getHand();
            String word = "";
            for(Tile it : hand){
                word += it.getLetter();
            }
            if(!word.isEmpty()){
                game.getBoard().addWord(this,word);
            }
            hand.clear();
            hand.addAll(game.getBag().extractTiles(7));
        }
    }
}
