package projects.hangman_game.src.v1_0;

public class HangmanGame {
    public static void main(String[] args) {
        WordBank wordBank = new WordBank();
        UserInterface ui = new UserInterface();
        GameLogic game = new GameLogic(wordBank, ui);

        boolean playAgain = true;

        while (playAgain) {
            game.play();
            playAgain = ui.askPlayAgain();
        }
        ui.displayGoodbye();
    }
}
