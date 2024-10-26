package projects.hangman_game.src.v1_4_1;

import java.util.HashMap;

public class WordDefinition {
    private HashMap<String, String> definitions;

    public WordDefinition() {
        definitions = new HashMap<>();

        //sample definitions
        definitions.put("ELEPHANT", "A large mammal with long trunk and tusks.");
        definitions.put("GIRAFFE", "A tall African mammal with a very long neck and legs,");
        /* More definitions to be added as needed*/
    }

    public String getDefinition(String word) {
        return definitions.getOrDefault(word, "Definition not available.");
    }
}