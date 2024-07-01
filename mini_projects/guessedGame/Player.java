package mini_projects.guessedGame;

public class Player {
    int number = 0; // where the guess number goes

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("I'm guessing " + number);
    }

}
