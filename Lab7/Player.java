package compulsory;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private static int score;

    private static int turn = 1;

    public Player(String name, Game game, boolean running) {
        this.name = name;
        this.game = game;
        this.running = true;
        this.score = 0;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        //we create a word with all the extracted tiles;
        StringBuilder word = new StringBuilder();

        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }

        game.getBoard().addWord(this, word.toString());

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter word, " + name + ":");
        String userInput = scan.nextLine();

        if (game.getDictionary().isWord(userInput) && checkUserInput(userInput, String.valueOf(word))) {
            for (int i = 0; i < userInput.length(); i++) {
                //score += game.getBag().findPointsByLetter(userInput.charAt(i)) * userInput.length();
                setScore(score, game.getBag().findPointsByLetter(userInput.charAt(i)) * userInput.length() * turn);
            }
        } else {
            System.out.println("Invalid word");//fie pt ca nu este alcatuit doar din litere extrase, fie pt ca nu este cuvant
            //score += 0;
            setScore(score, 0);
        }
        System.out.println(getName() + "'s score: " + getScore());
        //setScore(score);
        turn *= -1;
        return true;
    }

    private boolean checkUserInput(String userInput, String word) {
        int nr=0;
        for(int i=0;i<userInput.length();i++){
            for(int j=0;j<word.length();j++){
                if(userInput.charAt(i)==word.charAt(j)){
                    nr++;
                    break;
                }
            }
        }
        return nr == userInput.length();
    }

    @Override
    public void run() {
        while (running) {
            synchronized (game.currentPlayer) {
                try {
                    game.currentPlayer.put(this);
                } catch (InterruptedException e) {
                    try {
                        game.currentPlayer.wait();

                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            if (!running) break;
            try {
                submitWord();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                game.currentPlayer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (game.currentPlayer) {
                game.currentPlayer.notify();
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setScore(int score, int add) {
        this.score = score + add;
    }

    public boolean isRunning() {
        return running;
    }
}