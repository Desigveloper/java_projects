package projects.hangman_game.src.v1_3;

public class HangmanGame {
    public static void main(String[] args) {
        WordBank wordBank = new WordBank();
        UserInterface ui = new UserInterface();
        
        boolean playAgain = true;
        
        while (playAgain) {
            boolean isTimedMode = ui.askTimeMode();
            GameLogic game = new GameLogic(wordBank, ui, isTimedMode);
            game.play();
            playAgain = ui.askPlayAgain();
        }
        ui.displayGoodbye();
    }
}
