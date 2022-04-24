package compulsory;

import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private final HashMap<Integer, Tile > letters = new HashMap<>();

    public Bag() {
        int key = 0;
        List<Integer> numberList=Arrays.asList(9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1);
        int index=0;
        for (char c = 'a'; c < 'z'; c++) {
            List<Integer> nrPointsList=Arrays.asList(1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10);

            for(int nrTiles = 0; nrTiles <numberList.get(index) ; nrTiles++){
                letters.put(key++, new Tile(c, nrPointsList.get(index)));
            }
            index++;
        }
    }
    public int findPointsByLetter(char letter){
        for (HashMap.Entry<Integer,Tile> entry: letters.entrySet())
        {
            Tile value = entry.getValue();
            if (value.getLetter() == letter) {
                return value.getPoints();
            }

        }
        return 0;
    }
    public HashMap<Integer, Tile> getLetters() {
        return letters;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>(howMany);
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }

            List<Integer> tileIntegers = letters.keySet().stream().collect(Collectors.toList());

            int maxIndex = tileIntegers.size() - 1;
            Random random = new Random();
            int indexLetter = random.nextInt(maxIndex);
            indexLetter = tileIntegers.get(indexLetter);

            Tile tile = letters.get(indexLetter);
            extracted.add(new Tile(tile.getLetter(), tile.getPoints() ));
            letters.remove(indexLetter);
        }
        return extracted;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "letters=" + letters +
                '}';
    }
}