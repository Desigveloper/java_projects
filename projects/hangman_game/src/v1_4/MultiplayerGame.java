package projects.hangman_game.src.v1_4;

import java.util.ArrayList;
import java.util.List;


public class MultiplayerGame {
    private List<Player> players;
    private int currentPlayerIndex;
    private GameLogic gameLogic;
    private WordBank wordBank;
    private UserInterface ui;
    private boolean isTimedMode;

    public MultiplayerGame(WordBank wordBank, UserInterface ui, boolean isTimedMode) {
        this.wordBank = wordBank;
        this.ui = ui;
        this.currentPlayerIndex = 0;
        this.isTimedMode = isTimedMode;
        this.players = new ArrayList<>();
    }

    public void setup() {
        int numPlayers = ui.getNumberOfPlayers();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = ui.getPlayerName();
            players.add(new Player(playerName));
        }
    }

    public void play() {
        while(players.size() > 1) {
            Player currentPlayer = players.get(currentPlayerIndex);
            ui.displayCurrentPlayer(currentPlayer.getName());

            gameLogic = new GameLogic(wordBank, ui, isTimedMode);
            gameLogic.play();

            currentPlayer.addScore(gameLogic.getCurrentScore());

            if (gameLogic.isTimedMode()) {
                ui.displayPlayerEliminated(currentPlayer.getName());
                players.remove(currentPlayerIndex);

                if (currentPlayerIndex >= players.size()) {
                    currentPlayerIndex = 0;
                }
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
            ui.displayScoreboard(players);
        }

        Player winner = players.get(0);
        ui.displayWinner(winner.getName(), winner.getScore()); 
    }

    static class Player {
        private String name;
        private int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        public void addScore(int points) {
            score += points;
        }
    }
}