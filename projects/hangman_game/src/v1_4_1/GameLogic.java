package projects.hangman_game.src.v1_4_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class GameLogic extends GameState {
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
    private ArrayList<String> powerUps;
    private AchievementSystem achievementSystem;
    private WordDefinition wordDefinition;
    private List<Character> fakeLetters;
    private Random random;
    
    public GameLogic(WordBank wordBank, UserInterface ui, boolean isTimedMode) {
        this.wordBank = wordBank;
        this.ui = ui;
        leaderboard = new Leaderboard();
        currentScore = 0;
        this.isTimedMode = isTimedMode;
        this.powerUps = new ArrayList<>();
        this.powerUps.add("Extra Time");
        this.powerUps.add("Reveal Letter");
        this.powerUps.add("Skip Word");
        this.achievementSystem = new AchievementSystem();
        this.wordDefinition = new WordDefinition();
        this.fakeLetters = new ArrayList<>();
        this.random = new Random();
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

        while (remainingGuesses > 0 && !isWordGuessed() && (gameTimer == null || gameTimer.getSecondsLeft() > 0)) {
            ui.displayGameState(currentGuess, remainingGuesses, guessesLetters, hintsRemaining, isTimedMode ? gameTimer.getSecondsLeft() : -1);
            
            // Offer power-up before each guess
            if (!powerUps.isEmpty()) {
                int powerUpChoice = ui.selectPowerUp(powerUps);
                usePowerUp(powerUpChoice);
            }
            char guess = ui.getGuess();
            processGuess(guess);
            if (ui.askForHint() && hintsRemaining > 0) {
                giveHint();
            }
        }
            if (gameTimer != null) {
                gameTimer.stop();
            }
            endGame();
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

        if (isWordGuessed()) {
            achievementSystem.checkAchievements(this);
        }
    }

    private void endGame() {
        if (isWordGuessed()) {
            ui.displayWin(wordToGuess);
            currentScore += remainingGuesses * 50; // Bonus points for remaining guesses
            if (isTimedMode) {
                currentScore += gameTimer.getSecondsLeft() * 10; // Bonus points for remaining time
            }
            achievementSystem.checkAchievements(this);
        } else {
            ui.displayLoss(wordToGuess);
        }

        ui.displayWordDefinition(wordToGuess, wordDefinition.getDefinition(wordToGuess));
        String playerName = ui.getPlayerName();
        leaderboard.addScore(playerName, currentScore);
        ui.displayLeaderboard(leaderboard.getTopScores(5));
    }

    private void usePowerUp(int choice) {
        switch (choice) {
            case 0 -> addExtraTime();
            case 1 -> revealLetter();
            case 2 -> skipWord();
        }
        powerUps.remove(choice);
    }

    private void addExtraTime()  {
        if (isTimedMode && gameTimer != null) {
            gameTimer.addTime(30);
        }
    }

    private void revealLetter() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (currentGuess[i] == '_') {
                currentGuess[i] = wordToGuess.charAt(i);
                break;
            }
        }
    }

    private void skipWord() {
        wordToGuess = wordBank.getRandomWord(currentCategory);
        currentGuess = new char[wordToGuess.length()];
        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }
        guessesLetters.clear();
        remainingGuesses = difficulty.guesses;
    }

    // Getter method for AchievementSystem
    public int getCurrentScore() {
        return currentScore;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public boolean isTimedMode() {
        return isTimedMode;
    }

    public int getTimeTaken() {
        return isTimedMode ? 60 - gameTimer.getSecondsLeft() : 0;
    }

    public UserInterface getUi() {
        return ui;
    }
    /************* End Of Getter for Achievements**************/
    
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

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
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
    

    private boolean isWordGuessed() {
        return wordToGuess.equals(new String(currentGuess));
    } 
    
    public boolean isGameLost() {
        return remainingGuesses <= 0;
    }

    public void shuffleWord() {
        List<Character> chars = new ArrayList<>();
        for (char ch : wordToGuess.toCharArray()) {
            chars.add(ch);
        }
        Collections.shuffle(chars);
        StringBuilder shuffledWord = new StringBuilder();
        for (char ch : chars) {
            shuffledWord.append(ch);
        }
        wordToGuess = shuffledWord.toString();
    }

    public void reduceTime(int seconds) {
        if (isTimedMode && gameTimer != null) {
            gameTimer.reduceTime(seconds);
        }
    }

    public void addFakeLetters(int count) {
        for (int i = 0; i < count; i++) {
            char fakeLetter;
            do {
                fakeLetter = (char) (random.nextInt(26) + 'A');
            } while (wordToGuess.indexOf(fakeLetter) != -1 || fakeLetters.contains(fakeLetter));
             fakeLetters.add(fakeLetter);
        }
    }
    @Override
    public void displayGameState(char[] currentGuess, int remainingGuesses, HashSet<Character> guessedLetters,
                int hintsRemaining, int secondsLeft) {
                super.displayGameState(currentGuess, remainingGuesses, guessedLetters, hintsRemaining, secondsLeft);
                if (!fakeLetters.isEmpty()){
                    ui.displayFakeLetters(fakeLetters);
                }
    }
}
