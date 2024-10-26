package projects.hangman_game.src.v1_4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MultiplayerGame {
    private List<Player> players;
    private int currentPlayerIndex;
    private GameLogic gameLogic;
    private WordBank wordBank;
    private UserInterface ui;
    private boolean isTimedMode;
    private Random random;

    public MultiplayerGame(WordBank wordBank, UserInterface ui, boolean isTimedMode) {
        this.wordBank = wordBank;
        this.ui = ui;
        this.currentPlayerIndex = 0;
        this.isTimedMode = isTimedMode;
        this.players = new ArrayList<>();
        this.random = new Random();
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

            if (random.nextDouble() < 0.3) { // 30% chance to activate sabotage mode
                applySabotage(currentPlayer);
            }
            gameLogic = new GameLogic(wordBank, ui, isTimedMode);
            gameLogic.play();

            currentPlayer.addScore(gameLogic.getCurrentScore());

            if (gameLogic.isGameLost()) {
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

    private void applySabotage(Player targetPlayer) {
        ui.displaySabotageActivated(targetPlayer.getName());
        List<Player> otherPlayers = new ArrayList<>(players);
        otherPlayers.remove(targetPlayer);

        Player saboteur = ui.selectSaboteur(otherPlayers);
        String sabotageAction = ui.selectSabotageAction();

        switch (sabotageAction) {
            case "SHUFFLE":
                gameLogic.shuffleWord();
                break;
            case "REDUCE TIME":
                if (isTimedMode) {
                    gameLogic.reduceTime(15); // Reduce time by 15 seconds
                }
                break;
            case "ADD FAKE LETTERS":
                gameLogic.addFakeLetters(2); // Add 2 fake letters
                break;
        }
        ui.displaySabotageApplied(saboteur.getName(), targetPlayer.getName(), sabotageAction);
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