package projects.hangman_game.src.v1_0;


import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;

    public UserInterface() {
        sc =  new Scanner(System.in);
    }

    public void displayGameState(char[] currentGuess, int remainingGuesses,
        HashSet<Character> guessesLetters) {
            System.out.println("\nWord: " + new String(currentGuess));
            System.out.println("Guesses left: " + remainingGuesses);
            System.out.println("Guessed letters: " + guessesLetters);
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
}
