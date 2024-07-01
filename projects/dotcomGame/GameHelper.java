package projects.dotcomGame;

import java.io.*;
//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

// Helps get a user input from the command line
public class GameHelper {
    private final String alphabets = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    //Scanner sc = new Scanner(System.in);
    


    /**
     * Retrieves user input from the command line.
     *
     * @param  prompt  the message prompt to display to the user
     * @return         the user input as a lowercase string
     */
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + ": ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            //inputLine = sc.nextLine();

            if (inputLine.length() == 0)
                return null;

        } catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    /**
     * Places a dot com of the specified size on the grid, randomly selecting a starting location.
     * The dot com is represented by a list of alpha-numeric coordinates (e.g. "a1", "b2", etc.).
     *
     * @param  comSize  the size of the dot com to place
     * @return          a list of alpha-numeric coordinates representing the dot com's location
     */
    public ArrayList<String> placeDotCom(int comSize) {
        // List to hold the alpha-numeric coordinates of the dot com
        ArrayList<String> alphaCells = new ArrayList<String>();

        // Array to hold the coordinate values of the dot com (e.g. 0, 1, 2, etc.)
        String [] alphaCoords = new String[comSize];

        // Temporal string for concatenation
        String temp = null;

        // Array to hold the candidate coordinates for the dot com
        int [] coords = new int[comSize];

        // Counter for the number of attempts to place the dot com
        int attempts = 0;

        // Flag to indicate if a valid location has been found for the dot com
        boolean success = false;

        // Current start location for the dot com
        int location = 0;

        // Increment for the horizontal placement of the dot com
        int incre = 1;

        // Increment is set to the grid length if the dot com is placed vertically
        if ((comCount % 2) == 1) {
            incre = gridLength;
        }

        // Attempt to place the dot com on the grid
        while (!success && attempts++ < 200) {
            Random randNum = new Random();
            location = randNum.nextInt(gridSize); // Get a random starting point

            int x = 0;
            success = true;      // Assume success

            // Attempt to place the dot com on the grid
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incre;

                    // Check if the dot com goes out of bounds
                    if (location >= gridSize) {
                        success = false;
                    } else if (x > 0 && (location % gridLength == 0)) { // Check if out of bounds on the right edge
                        success = false;
                    }
                } else {
                    success = false; // Found an already used location
                }
            }
        }

        // Place the dot com on the grid and generate the alpha-numeric coordinates
        int x = 0;
        int row = 0;
        int column = 0;

        while (x < comSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;

            temp = String.valueOf(alphabets.charAt(column));

            alphaCoords[x] = temp.concat(Integer.toString(row));
            x++;
        }

        for(int i = 0; i < comSize; i++) {
            alphaCells.add(alphaCoords[i]);
        }
        //System.out.println("Placed DotCom at: " + alphaCells); // Cheat: For statement debugging
        return alphaCells;
    }
}