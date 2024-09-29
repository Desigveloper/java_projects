package projects.hangman_game.src.v1_4_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WordBank {
    private final HashMap<String, ArrayList<String>> categories;
    private final Random random;
 
    public WordBank() {
        categories = new HashMap<>();
        random = new Random();

        // initialize categories
        categories.put("Animals", new ArrayList<>(List.of("ELEPHANT", "GIRAFFE", "PENGUIN", "CAMEL", "SHEEP", "BUTTERFLY", "CROCODILE", "LION", "BUFFALO", "DOLPHIN")));
        categories.put("Countries", new ArrayList<>(List.of("BRAZIL", "FRANCE", "JAPAN", "AUSTRALIA", "CAMEROON", "SOUTH AFRICA", "BURKINA FASO", "CROATIA", "LIBERIA", "GHANA")));
        categories.put("Programming", new ArrayList<>(List.of("VARIABLE", "OBJECTS", "ARRAY", "PHP", "LINKEDLIST", "JAVASCRIPT", "COLLECTION", "JAVA", "PYTHON", "ALGORITHM")));
    }

    public ArrayList<String> getCategories() {
        return new ArrayList<>(categories.keySet());
    }

    public String getRandomWord(String category) {
        ArrayList<String> words = categories.get(category);
        return words.get(random.nextInt(words.size()));
    }
}
