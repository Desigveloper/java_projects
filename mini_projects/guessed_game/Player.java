package guessed_game;

import java.util.Random;

public class Player {
    private Random rand = new Random();
    int number = 0; // where the guess number goes

    public void guess() {
        number = rand.nextInt(10);
        System.out.println("I'm guessing " + number);
    }

}
