package projects.hangman_game.src.v1_4_2;


public class HangmanGame {
    public static void main(String[] args) {
        WordBank wordBank = new WordBank();
        UserInterface ui = new UserInterface();
        
        boolean playAgain = true;
        
        while (playAgain) {
            boolean isMultiplayerMode = ui.askMultiplayerMode();
            boolean isTimedMode = ui.askTimeMode();
            if (isMultiplayerMode) {
                MultiplayerGame game = new MultiplayerGame(wordBank, ui, isTimedMode);
                game.setup();
                game.play();
            } else {

                GameLogic game = new GameLogic(wordBank, ui, isTimedMode);
                game.play();
            }
            playAgain = ui.askPlayAgain();
        }
        ui.displayGoodbye();
    }
}
