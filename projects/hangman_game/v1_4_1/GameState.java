package projects.hangman_game.v1_4_1;

import java.util.HashSet;
public abstract class GameState {
    public void  displayGameState(char[] currentGuess, int remainingGuesses, HashSet<Character> guessedLetters,
                int hintsRemaining, int secondsLeft){};
}
