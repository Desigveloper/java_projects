package guessed_game;

import java.util.Random;

public class GuessGame {
    private Random rand = new Random();
    // Instance variable of three players
    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        // Create three player objects
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        // Declare guesses by the three players
        int p1Guess = 0;
        int p2Guess = 0;
        int p3Guess = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        //target number player hass to guess
        int targetNember = rand.nextInt(10);
        System.out.println("I am thinking of a number between 0 and 9......");

        while(true) {
            System.out.println("Number to guess is: " + targetNember);

            // Calling each player guess method
            p1.guess();
            p2.guess();
            p3.guess();

            // Get each player guess by access player class instance number variable
            p1Guess = p1.number;
            System.out.println("Player one guessed " + p1Guess); 
            
            p2Guess = p2.number;
            System.out.println("Player two guessed " + p2Guess); 
            
            p3Guess = p3.number;
            System.out.println("Player three guessed " + p3Guess);


            //Check each players guess for a match
            if (p1Guess == targetNember) {
                p1isRight = true;
            }
            
            if (p2Guess == targetNember) {
                p2isRight = true;
            }
            
            if (p3Guess == targetNember) {
                p3isRight = true;
            }

            // Check if any of the players guessed correct
            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player one guessed right? " + p1isRight);
                System.out.println("Player two guessed right? " + p2isRight);
                System.out.println("Player three guessed right? " + p3isRight);
                break; // game over, so break out of the loop
            }
            else {
                // we must keep going because nobody got it right!
                System.out.println("Players will have to try again");
            } //end if/else
        } // end while
    } // end method

} // end class
