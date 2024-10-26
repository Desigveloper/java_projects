package projects.hangman_game.src.v1_4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;


public class MultiplayerGame {
    private List<Player> players;
    private int currentPlayerIndex;
    private GameLogic gameLogic;
    private WordBank wordBank;
    private UserInterface ui;
    private boolean isTimedMode;
    private Random random;
    private Map<Player, Integer> sabotagePoints;
    private Map<Player, Integer> sabotageUseCooldown;
    private int roundNumber;

    public MultiplayerGame(WordBank wordBank, UserInterface ui, boolean isTimedMode) {
        this.wordBank = wordBank;
        this.ui = ui;
        this.currentPlayerIndex = 0;
        this.isTimedMode = isTimedMode;
        this.players = new ArrayList<>();
        this.random = new Random();
        this.sabotagePoints = new HashMap<>();
        this.sabotageUseCooldown = new HashMap<>();
        this.roundNumber = 0;
    }

    public void setup() {
        int numPlayers = ui.getNumberOfPlayers();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = ui.getPlayerName();
            players.add(new Player(playerName));
        }

        for (Player player : players) {
            sabotagePoints.put(player, 3); // Start with three sabotage points
            sabotageUseCooldown.put(player, 0);
        }
    }

    public void play() {
        while(players.size() > 1) {
            roundNumber++;
            Player currentPlayer = players.get(currentPlayerIndex);
            ui.displayCurrentPlayer(currentPlayer.getName());

            // Check for special events
            if (roundNumber % 5 == 0) {
                triggerSpecialEvent();
            }

            // Sabotage phase
            if (canUseSabotage(currentPlayer)) {
                applySabotage(currentPlayer);
            } 
            if (random.nextDouble() < 0.3) { // 30% chance to activate sabotage mode
                applySabotage(currentPlayer);
            }

            gameLogic = new GameLogic(wordBank, ui, isTimedMode);
            gameLogic.play();

            int scoreGained = gameLogic.getCurrentScore();
            currentPlayer.addScore(scoreGained);

            // Award sabotage points based on performance
            int sabotagePointsEarned = scoreGained / 50; // 1 point for every 5 score
            sabotagePoints.put(currentPlayer, sabotagePoints.get(currentPlayer) + sabotagePointsEarned);
            ui.displaySabotagePointsEarned(currentPlayer.getName(), sabotagePointsEarned);


            if (gameLogic.isGameLost()) {
                ui.displayPlayerEliminated(currentPlayer.getName());
                players.remove(currentPlayerIndex);
                sabotagePoints.remove(currentPlayer);
                sabotageUseCooldown.remove(currentPlayer);
                if (currentPlayerIndex >= players.size()) {
                    currentPlayerIndex = 0;
                }
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }

            // Reduce cooldowns
            for (Player player : sabotageUseCooldown.keySet()) {
                sabotageUseCooldown.put(player, Math.max(0, sabotageUseCooldown.get(player) - 1));
            }
            ui.displayScoreboard(players, sabotagePoints);
        }

        Player winner = players.get(0);
        ui.displayWinner(winner.getName(), winner.getScore()); 
    }

    private boolean canUseSabotage(Player targetPlayer) {
        return sabotagePoints.get(targetPlayer) > 0 && sabotageUseCooldown.get(targetPlayer) == 0;
    }

    private void applySabotage(Player targetPlayer) {
        ui.displaySabotageActivated(targetPlayer.getName());
        List<Player> otherPlayers = new ArrayList<>(players);
        otherPlayers.remove(targetPlayer);

        Player saboteur = ui.selectSaboteur(otherPlayers);
        String sabotageAction = ui.selectSabotageAction(sabotagePoints.get(saboteur));

        if (sabotageAction.equals("NONE")) {
            return;
        }
        int cost = getSabotageCost(sabotageAction);
        sabotagePoints.put(saboteur, sabotagePoints.get(saboteur) - cost);
        sabotageUseCooldown.put(saboteur, 2); // Set cooldown to 2 rounds

        // Check if target player wants to use counter-sabotage
        if (ui.askUseCounterSabotage(targetPlayer.getName()) && sabotagePoints.get(targetPlayer) >= 2) {
            ui.displayCounterSabotageUsed(targetPlayer.getName());
            sabotagePoints.put(targetPlayer, sabotagePoints.get(targetPlayer) - 2);
            return;
        }

        applySabotageEffect(sabotageAction);
        ui.displaySabotageApplied(saboteur.getName(), targetPlayer.getName(), sabotageAction);
    }
        
        private int getSabotageCost(String action) {
            switch (action) {
                case "SHUFFLE":
                case "REDUCE_TIME":
                case "ADD_FAKE_LETTERS":
                    return 1;
                case "DOUBLE_OR_NOTHING":
                    return 2;
                case "LETTER_LOCK":
                    return 3;
                default:
                    return 0;
            }
        }

        private void applySabotageEffect(String action) {
            switch (action) {
                case "SHUFFLE":
                    gameLogic.shuffleWord();
                    break;
                case "REDUCED_TIME":
                    if (isTimedMode) {
                        gameLogic.reduceTime(15); // Reduce time by 15 seconds
                    }
                    break;
                case "ADD_FAKE_LETTERS":       
                    gameLogic.addFakeLetters(2); // Add 2 fake letters
                    break;
                case "LETTER_LOCK":
                    gameLogic.lockRandomLetter();
                    break;
            }
        }

    private void triggerSpecialEvent() {
        String event = ui.selectSpecialEvent();
        switch (event) {
            case "BONUS_POINTS":
                for (Player player : players) {
                    int bonusPoints = random.nextInt(3) + 1;
                    sabotagePoints.put(player, sabotagePoints.get(player) + bonusPoints);
                }
                ui.displaySpecialEvent("Everyone received 1-3 bonus sabotage points");
            case "RESET_COOLDOWNS":
                for (Player player : players) {
                    sabotageUseCooldown.put(player, 0);
                }
                ui.displaySpecialEvent("All sabotage cooldowns have been reset!");
                break;
            case "WILD_SABOTAGE":
                Player randomPlayer = players.get(random.nextInt(players.size()));
                applySabotage(randomPlayer);
                ui.displaySpecialEvent("A random sabotage was applied to " + randomPlayer.getName() + "!");
                break;
        }
        //ui.displaySabotageApplied(saboteur.getName(), targetPlayer.getName(), sabotageAction);
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