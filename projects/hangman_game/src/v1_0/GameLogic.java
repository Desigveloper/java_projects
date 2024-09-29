package projects.hangman_game.src.v1_0;

import java.util.HashSet;

public class GameLogic {
    private final WordBank wordBank;
    private final UserInterface ui;
    private String wordToGuess;
    private char[] currentGuess;
    private HashSet<Character> guessesLetters;
    private int remainingGuesses;

    public GameLogic(WordBank wordBank, UserInterface ui) {
        this.wordBank = wordBank;
        this.ui = ui;
    }

    public void play() {
        initializeGame();

        while (remainingGuesses > 0 && !isWordGuessed()) {
            ui.displayGameState(currentGuess, remainingGuesses, guessesLetters);
            char guess = ui.getGuess();
            processGuess(guess);
        }
        endGame();
    }

    private void initializeGame() {
        wordToGuess = wordBank.getRandomWord();
        currentGuess = new char[wordToGuess.length()];

        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }

        guessesLetters = new HashSet<>();
        remainingGuesses = 6;
    }

    private void processGuess(char guess) {
        if (guessesLetters.contains(guess)) {
            ui.displayAlreadyGuessed();
            return;
        }

        guessesLetters.add(guess);
        
        boolean correctGuess = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess[i] = guess;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            remainingGuesses--;
        }
    }

    private boolean isWordGuessed() {
        return wordToGuess.equals(new String(currentGuess));
    }

    private void endGame() {
        if (isWordGuessed()) {
            ui.displayWin(wordToGuess);
        } else {
            ui.displayLoss(wordToGuess);
        }
    }
}
