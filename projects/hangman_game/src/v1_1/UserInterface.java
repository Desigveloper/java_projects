package projects.hangman_game.src.v1_1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import projects.hangman_game.src.v1_1.GameLogic.Difficulty;

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
        HashSet<Character> guessesLetters, int hintsRemaining) {
            System.out.println("\nWord: " + new String(currentGuess));
            System.out.println("Guesses left: " + remainingGuesses);
            System.out.println("Guessed letters: " + guessesLetters);
            System.out.println("Hints remaining: " + hintsRemaining);
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
} 
