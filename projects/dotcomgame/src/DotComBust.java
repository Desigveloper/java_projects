package projects.dotcomgame.src;

import java.util.ArrayList;
import java.util.List;



public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
   
    private int numOfGuesses = 0;


    // create and initialize the DotCom objects with names and locations.
    // Display brief instructions to the user
    void setUpGame() {
        DotCom go2DotCom = new DotCom();
        DotCom petDotCom = new DotCom();
        DotCom askMeDotCom = new DotCom();

        go2DotCom.setName("Pets.com");
        petDotCom.setName("Go2.com");
        askMeDotCom.setName("AskMe.com");

        dotComsList.add(petDotCom);
        dotComsList.add(askMeDotCom);
        dotComsList.add(go2DotCom);


        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com, Go2.com, AskMe.com");
        System.out.println("Try to sink them all in fewer number of guesses");

        // Place each DotCom at a random location on the grid
        // and store the location in the DotCom object.
        for (DotCom dotCom: dotComsList) {
            List<String> newLocation = helper.placeDotCom(3);

            dotCom.setLocationCells(newLocation);

            // Cheat: Statement for debugging. Shows name and location of each Dotcom
        }
    }


        // asks the player for guesses and calls the checkUserGuessO method
        // until all the DotCom objects are removed from play.
        public void startPlaying() {
            while (!dotComsList.isEmpty()) {
                String userGuess = helper.getUserInput("Enter a guess");
                checkUserGuess(userGuess);
        
            }

            finishGame();
        }

    /**
     * Checks the user's guess against the list of DotCom objects.
     *
     * @param  userGuess   the user's guess as a String
     * @return              void
     */
        public void checkUserGuess(String userGuess) {
            numOfGuesses++;

            String result = "miss";
            DotCom dotComToRemove = null;

            for (DotCom dotComToKill: dotComsList) {
                result = dotComToKill.checkYourself(userGuess);

                if (result.equals("hit") || result.equals("kill"))  {
                    if (result.equals("kill")) {
                        dotComToRemove = dotComToKill;
                    }
                    break;
                }
            }
                
            if (dotComToRemove != null) {
                dotComsList.remove(dotComToRemove);
            }
            
            System.out.println(result);
        }

        
        /**
         * prints a message about the user's performance, based on how many guesses
         * it took to sink all of the DotCom objects.
         *
         */
        public void finishGame() {
            System.out.println("All Dot Coms are dead! Your stock is now worthless");

            if (numOfGuesses < 15) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
                System.out.println(" You got out before your options sank.");
            }
            else {
                System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
                System.out.println("Fish are dancing with your options");
            }
        }


    /**
     * The main function that initializes a new instance of the DotComBust game,
     * sets up the game, and starts playing.
     *
     * @param  args  the command-line arguments passed to the program
     */
        public static void main(String[] args) {
            DotComBust game = new DotComBust();
            game.setUpGame();
            game.startPlaying();
        }
}
