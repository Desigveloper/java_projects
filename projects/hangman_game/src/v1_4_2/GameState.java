package projects.hangman_game.src.v1_4_2;

import java.util.HashSet;
public abstract class GameState {
    public void  displayGameState(char[] currentGuess, int remainingGuesses, HashSet<Character> guessedLetters,
                int hintsRemaining, int secondsLeft){};

    protected void endGame(){};
}
