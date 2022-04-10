package Setup;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Tile> letters = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            Tile tile = new Tile(c, 1);
            this.letters.add(tile);
        }
    }

    public List<Tile> getLetters() {
        return letters;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(i));
        }
        return extracted;
    }
}
