package Setup;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> dictionary = new ArrayList<>();

    public synchronized void addWord(Player player, String word) {
        dictionary.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return "Setup.Board{" +
                "dictionary=" + dictionary +
                '}';
    }
}
