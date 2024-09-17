package projects.hangman_game.v1_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import projects.hangman_game.v1_3.GameLogic.Difficulty;


public class UserInterface {
    private final Scanner sc;

    public UserInterface() {
        sc =  new Scanner(System.in);
    }

    public String selectCategory(ArrayList<String> categories) {
        System.out.println("Select a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        int choice = Integer.parseInt(sc.nextLine()) - 1;
        return categories.get(choice);
    }

    public void displayGameState(char[] currentGuess, int remainingGuesses,
        HashSet<Character> guessesLetters, int hintsRemaining, int secondsLeft) {
            System.out.println("\nWord: " + new String(currentGuess));
            System.out.println("Guesses left: " + remainingGuesses);
            System.out.println("Guessed letters: " + guessesLetters);
            System.out.println("Hints remaining: " + hintsRemaining);

            if (secondsLeft >= 0 ) {
                System.out.println("Time left: " + secondsLeft + " seconds");
            }
        }

        public void updateTimerDisplay(int secondsLeft) {
            System.out.println("\rTime left: " + secondsLeft + " seconds");
        }

        public boolean askForHint() {

            System.out.print("Do you want to use a hint? (y/n): ");
            return sc.nextLine().equalsIgnoreCase("y");
        }

        public char getGuess() {
            System.out.print("Enter your guess: ");
            return sc.nextLine().toUpperCase().charAt(0);
        }

        public void displayAlreadyGuessed() {
            System.out.println("You already guessed that letter!");
        }

        public void displayWin(String word) {
            System.out.println("Congratulations! You guessed the word: " + word);
        }

        public void displayLoss(String word) {
            System.out.println("Game over! The word was: " + word);
        }

        public boolean askPlayAgain() {
            System.out.println("Do you want to play again? (y/n)");
            return sc.nextLine().equalsIgnoreCase("y");
        }

        public void displayGoodbye() {
            System.out.println("Thanks for playing Hangman!");
        }

        public Difficulty selectDifficulty() {
            int choice = Integer.parseInt(sc.nextLine());

            return switch (choice) {
                case 1 -> Difficulty.EASY;
                case 2 -> Difficulty.MEDIUM;
                case 3 -> Difficulty.HARD;
                default -> null;
            };
        }

        public String getPlayerName() {
            System.out.print("Enter your name: ");
            return sc.nextLine();
        }

        public void displayLeaderboard(ArrayList<Leaderboard.Score> topScores) {
            System.out.println("\nTop Scores:");
            for (int i = 0; i < topScores.size(); i++) {
                Leaderboard.Score score = topScores.get(i);
                System.out.println((i + 1) + ". " + score.playerName + ": " + score.score);
            }       
        }
        
        public boolean  askTimeMode() {
            System.out.print("Do you want to play in timed mode? (y/n)");
            return sc.nextLine().equalsIgnoreCase("y");
        }
} 
