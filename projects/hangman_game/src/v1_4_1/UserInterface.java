package projects.hangman_game.src.v1_4_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import java.util.List;
import projects.hangman_game.src.v1_4_1.GameLogic.Difficulty;
import projects.hangman_game.src.v1_4_1.MultiplayerGame.Player;


public class UserInterface {
    private final Scanner sc;

    public UserInterface() {
        sc =  new Scanner(System.in);
    }

    public void displaySabotageActivated(String playerName) {
        System.out.println("\n🚨 Sabotage Mode activated for " + playerName + "'s turn! 🚨");
    }

    public Player selectSaboteur(List<Player> players) {
        System.out.println("Select a player to apply sabotage:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine()) - 1;
                if (choice >= 0 && choice < players.size()) {
                    return players.get(choice);
                } else  {
                    System.out.println("Invalid choice. Please try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String selectSabotageAction() {
        System.out.println("Select a sabotage action: ");
        System.out.println("1: Shuffle the word");
        System.out.println("2. Reduce time (Timed mode only)");
        System.out.println("3. Add fake letters");

        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: return "SHUFFLE";
                    case 2: return "REDUCE_TIME";
                    case 3: return "ADD_FAKE_LETTERS";
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void displaySabotageApplied(String saboteurName, String targetName, String action) {
        System.out.println(saboteurName + " applied " + action + " sabotage to " + targetName + "!");
    }

    public void displayFakeLetters(List<Character> fakeLetters) {
        System.out.println("Beware of fake letters: " + fakeLetters);
    }

    public String selectCategory(ArrayList<String> categories) {
        System.out.println("Select a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine()) - 1;
                if (choice >= 0 && choice < categories.size()) {
                    return categories.get(choice);
                } else {
                    System.out.println("Invalid choice. Please try again");
                }
            } catch (NumberFormatException e) {
               System.out.println("Please enter a valid number.");
            }
        }
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
            System.out.println("=".repeat(40));
        }

        public void updateTimerDisplay(int secondsLeft) {
            System.out.println("\rTime left: " + secondsLeft + " seconds");
        }

        public boolean askForHint() {
            while (true) {
                System.out.print("Do you want to use a hint? (y/n): ");
                String input = sc.nextLine().trim().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    return input.equals("y");
                }
                System.out.println("Invalid input. Please enter 'y' or 'n'");
            }
        }

        public char getGuess() {
            while (true) {
                System.out.print("Enter your guess: ");
                String input = sc.nextLine().trim().toUpperCase();
                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                    return input.charAt(0);
                }
                System.out.println("Invalid input. Please enter a single letter.");
            }
        }

        public void displayAlreadyGuessed() {
            System.out.println("You already guessed that letter!");
        }

        public void displayWin(String word) {
            System.out.println("\n🎉 Congratulations! You guessed the word: " + word);
        }

        public void displayLoss(String word) {
            System.out.println("\n😢 Game over! The word was: " + word);
        }

        public boolean askPlayAgain() {
            while (true) {
                System.out.println("Do you want to play again? (y/n)");
                String input = sc.nextLine().trim().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    return input.equals("y");
                }
                System.out.println("Invalid input. Please enter 'y' or 'n'");
            }
        }

        public void displayGoodbye() {
            System.out.println("Thanks for playing Hangman!");
        }

        public Difficulty selectDifficulty() {
            while (true) {    
                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    return switch (choice) {
                        case 1 -> Difficulty.EASY;
                        case 2 -> Difficulty.MEDIUM;
                        case 3 -> Difficulty.HARD;
                        default -> {
                            System.out.println("Invalid choice. Please try again.");
                            yield null;
                        }
                    };
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }

        public String getPlayerName() {
            System.out.print("Enter your name: ");
            return sc.nextLine().trim();
        }

        public void displayLeaderboard(ArrayList<Leaderboard.Score> topScores) {
            System.out.println("\nTop Scores:");
            System.out.println("=".repeat(30));
            for (int i = 0; i < topScores.size(); i++) {
                Leaderboard.Score score = topScores.get(i);
                System.out.printf("%d. %-15s %d pts%n", (i + 1), score.playerName, score.score);
            }
            System.out.println("=".repeat(30));     
        }
        
        public boolean  askTimeMode() {
            while (true) {
                System.out.print("Do you want to play in timed mode? (y/n): ");
                String input = sc.nextLine().trim().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    return input.equals("y");
                }
                System.out.println("Invalid input. Please enter 'y' or 'n'");
            }
        }

        public void displayWordDefinition(String word, String definition) {
            System.out.println("\nWord: " + word);
            System.out.println("Definition: " + definition);
        }

        public void displayAchievement(String achievement) {
            System.out.println("\n🏅 Achievement Unlocked: " + achievement + " 🏅");
        }

        public int selectPowerUp(ArrayList<String> powerUps) {
            System.out.println("Select a power-up:");
            for (int i = 0; i < powerUps.size(); i++) { 
                System.out.println((i + 1) + ". " + powerUps.get(i));
            }
            while (true) { 
                try {
                    int choice = Integer.parseInt(sc.nextLine()) - 1;
                    if (choice >= 0 && choice < powerUps.size()) {
                        return choice;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
            }
        }
    }

    public int getNumberOfPlayers() {
        while (true) {
            System.out.print("Enter the number of players (2-4): ");
            try {
                int numPlayers = Integer.parseInt(sc.nextLine());
                if (numPlayers >= 2 && numPlayers <= 4) {
                    return numPlayers;
                } else {
                    System.out.println("Plaese enter a number between 2 and 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public String getPlayerName(int playerNumber) {
        System.out.print("Enter name for Player " + playerNumber + ": ");
        return sc.nextLine().trim();
    }

    public void displayCurrentPlayer(String playerName) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Current player: " + playerName);
        System.out.println("=".repeat(40));
    }

    public void displayPlayerEliminated(String playerName) {
        System.out.println("\n" + playerName + " has been eliminated!");
    }

    public void displayScoreboard(List<MultiplayerGame.Player> players) {
        System.out.println("\nCurrent Scores:");
        for (MultiplayerGame.Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public void displayWinner(String playerName, int score) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🏆 " + playerName + " wins with a score of " + score + "! 🏆");
        System.out.println("=".repeat(40));
    }

    public boolean askMultiplayerMode() {
        while (true) {
            System.out.println("Do you want to play in multiple player mode (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("n")) {
                return input.equals("y");
            }
            System.out.println("Invalid input. Please enter 'y' or 'n'");
        }
    }

} 
