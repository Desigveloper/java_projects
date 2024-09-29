package projects.hangman_game.src.v1_0;

import java.util.ArrayList;
import java.util.Random;

public class WordBank {
    private final ArrayList<String> words;
    private final Random random;
 
    public WordBank() {
        words = new ArrayList<>();
        //Add words to the list
        words.add("JAVA");
        words.add("PROGRAMMING");
        words.add("HANGMAN");
        words.add("BACKEND");
        // Add more words

        random = new Random();
    }

    public String getRandomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
