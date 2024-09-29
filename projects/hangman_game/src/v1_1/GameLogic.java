package projects.hangman_game.src.v1_1;

import java.util.HashSet;

public class GameLogic {
    private final WordBank wordBank;
    private final UserInterface ui;
    private String wordToGuess;
    private char[] currentGuess;
    private HashSet<Character> guessesLetters;
    private int remainingGuesses;
    private String currentCategory;
    private int hintsRemaining;
    
    public GameLogic(WordBank wordBank, UserInterface ui) {
        this.wordBank = wordBank;
        this.ui = ui;
    }
    private Difficulty difficulty;

    private void showDifficultyMenu() {
        System.out.println("Select difficulty:\n1. Easy\n2. Medium\n3. Hard");
    }
    
    public enum Difficulty {
        EASY(8, 5), MEDIUM(6, 7), HARD(4, 9);
        
        final int guesses;
        final int minWordLength;

        Difficulty(int guesses, int minWordLength) {
            this.guesses = guesses;
            this.minWordLength = minWordLength;
        }

    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void play() {
        currentCategory = ui.selectCategory(wordBank.getCategories());
        initializeGame();

        while (remainingGuesses > 0 && !isWordGuessed()) {
            ui.displayGameState(currentGuess, remainingGuesses, guessesLetters, hintsRemaining);
            
            if (hintsRemaining > 0 && ui.askForHint()) {
                giveHint();
            } else {
                char guess = ui.getGuess();
                processGuess(guess);
            }
        }
        endGame();
    }

    private void giveHint() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (currentGuess[i] == '_') {
                currentGuess[i] = wordToGuess.charAt(i);
                hintsRemaining--;
                break;
            }
        }
    }

    private void initializeGame() {
        showDifficultyMenu();
        setDifficulty(ui.selectDifficulty());

        do {
            wordToGuess = wordBank.getRandomWord(currentCategory);
        } while (wordToGuess.length() < difficulty.minWordLength);

        currentGuess = new char[wordToGuess.length()];

        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }

        guessesLetters = new HashSet<>();
        remainingGuesses = difficulty.guesses;
        hintsRemaining = 2; //Starting with 2 hints
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
