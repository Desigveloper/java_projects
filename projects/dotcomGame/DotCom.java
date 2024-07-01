package projects.dotcomGame;
import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;
    // private int numberOfHits = 0;

    /**
     * Sets the location cells of the DotCom object.
     *
     * @param  locations  the ArrayList of strings representing the location cells to set
     * @return           void
     */
    public void setLocationCells(ArrayList<String> locations) {
        this.locationCells = locations;      
    }

    /**
     * Sets the name of the DotCom object.
     *
     * @param  objName  the name to set for the DotCom object
     */
    public void setName(String objName) {
        this.name = objName;
    }

    /**
     * Retrieves the name of the object.
     *
     * @return the name of the object as a string
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks the user's guess against the list of location cells and returns the result.
     *
     * @param  userInput  the user's guess as a string
     * @return            the result of the guess: "miss", "hit", or "kill"
     */
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {

            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + "  :( ");
            } else {
                result = "hit";
            }
        }
        //Statement for debugging input against location cell
        // System.out.println("Checking " + userInput + " against " + locationCells + " for " +
            //name + ": " + result);
        return result;
    }
}
