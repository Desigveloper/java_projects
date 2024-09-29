package projects.hangman_game.src.v1_4_2;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private int secondsLeft;
    private final Timer timer;
    private TimerTask task;
    private final Runnable onTimerTick;
    private final Runnable onTimerEnd;

    public GameTimer(int seconds, Runnable onTimerTick, Runnable onTimerEnd) {
        this.secondsLeft = seconds;
        this.onTimerTick = onTimerTick;
        this.onTimerEnd = onTimerEnd;
        this.timer = new Timer();
    }

    public void reduceTime(int seconds) {
        secondsLeft = Math.max(0, secondsLeft - seconds);
        onTimerTick.run();
    }

    public void start() {
        task = new TimerTask() {
            @Override
            public void run() {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    onTimerTick.run();
                } else {
                    timer.cancel();
                    onTimerEnd.run();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }
    
    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void addTime(int extraTime) {
        secondsLeft += extraTime;
       // throw new UnsupportedOperationException("Unimplemented method 'addTime'");
    }
}
