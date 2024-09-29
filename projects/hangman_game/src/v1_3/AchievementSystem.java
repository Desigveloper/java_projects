package projects.hangman_game.src.v1_3;

import java.util.HashMap;

public class AchievementSystem {
    private final HashMap<String, Boolean> achievements;

    public AchievementSystem() {
        achievements = new HashMap<>();
        achievements.put("First Win", false);
        achievements.put("Perfect Game", false);
        achievements.put("Speed Demon", false);
    }

    public void checkAchievements(GameLogic game) {
        if (!achievements.get("First Win")) {
            achievements.put("First Win", true);
            game.getUi().displayAchievement("First Win");
        }

        if (game.getRemainingGuesses() == game.getDifficulty().guesses) {
            achievements.put("Perfect Game", true);
            game.getUi().displayAchievement("Perfect Game");
        }

        if (game.isTimedMode() && game.getTimeTaken() < 30) {
        achievements.put("Speed Demon", true);
        game.getUi().displayAchievement("Speed Demon");
        }
    }
}