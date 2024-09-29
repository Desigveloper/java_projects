package projects.hangman_game.src.v1_2;

import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard {
    private final ArrayList<Score> scores;

    public Leaderboard() {
        scores = new ArrayList<>();
    }

    public void addScore(String playerName, int score) {
        scores.add(new Score(playerName, score));
        Collections.sort(scores);
    }

    public ArrayList<Score> getTopScores(int n) {
        return new ArrayList<>(scores.subList(0, Math.min(n, scores.size())));
    }

    public class Score implements Comparable<Score> {
        String playerName;
        int score;

        public Score(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }


        @Override
        public int compareTo(Score other) {
            return other.score - this.score; // Sort in descending order
        }

        public String getPlayerName() {
            return playerName;
        }
    }
}
