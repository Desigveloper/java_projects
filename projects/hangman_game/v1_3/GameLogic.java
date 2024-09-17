package projects.hangman_game.v1_3
;

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
    private final Leaderboard leaderboard;
    private int currentScore;
    private GameTimer gameTimer;
    private final boolean isTimedMode;
    private Difficulty difficulty;
    
    public GameLogic(WordBank wordBank, UserInterface ui, boolean isTimedMode) {
        this.wordBank = wordBank;
        this.ui = ui;
        leaderboard = new Leaderboard();
        currentScore = 0;
        this.isTimedMode = isTimedMode;
    }

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

        if (isTimedMode) {
            gameTimer = new GameTimer(
                60, // 60 seconds for the game
                () -> ui.updateTimerDisplay(gameTimer.getSecondsLeft()),
                this::endGame
            );
            gameTimer.start();
        }

        int i = 0; 
        while (remainingGuesses > 0 && !isWordGuessed() && (gameTimer == null || gameTimer.getSecondsLeft() > 0)) {
            ui.displayGameState(currentGuess, remainingGuesses, guessesLetters, hintsRemaining, isTimedMode ? gameTimer.getSecondsLeft() : -1);
            char guess = ui.getGuess();
            processGuess(guess);
            if (i < wordToGuess.length() && (currentGuess[i] != guess)) {
                requestHint();
            }
            i++;
        }
            if (gameTimer != null) {
                gameTimer.stop();
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

    public void requestHint() {
        if (hintsRemaining > 0) {
            ui.askForHint();
            giveHint();
        } else {
            System.out.println("No hint remaining");
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

        if (correctGuess) {
            currentScore += 5 + (isTimedMode ? gameTimer.getSecondsLeft() : 0); // Bonus points for quick guesses in timed mode
        }
    }

    private boolean isWordGuessed() {
        return wordToGuess.equals(new String(currentGuess));
    }

    private void endGame() {
        if (isWordGuessed()) {
            ui.displayWin(wordToGuess);
            currentScore += remainingGuesses * 50; // Bonus points for remaining guesses
            if (isTimedMode) {
                currentScore += gameTimer.getSecondsLeft() * 10; // Bonus points for remaining time
            }
        } else {
            ui.displayLoss(wordToGuess);
        }

        String playerName = ui.getPlayerName();
        leaderboard.addScore(playerName, currentScore);
        ui.displayLeaderboard(leaderboard.getTopScores(5));
    }
}
