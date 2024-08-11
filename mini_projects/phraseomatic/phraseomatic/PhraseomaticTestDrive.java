package phraseomatic;
import java.util.Random;

import javax.swing.JOptionPane;

public class PhraseomaticTestDrive {
        private static Random rand = new Random();
    public static void main(String[] args) {
        // Make three sets of words to choose from. Add your own!
        String[] wordListOne = {"24/7", "multi Tiar", "30,OOO foot", "B-to-B",
                "win-win", "front-end", "web-based", "pervasive", "smart",
                "six-sigma", "critical-path" , "dynamic" };

        String[] wordListTwo = { "empowered", "sticky", "value-added.", "oriented",
                "centric", "distributed", "clustered", "branded", "outside-the-box",
                "positioned", "networked", " focused", "leveraged", "aligned",
                "targeted", "shared", "cooperative", "accelerated" };

        String[] wordListThree = {"process", "tipping-point", "solution",
                "architecture", "core competency", "strategy", "mindshare",
                "portal" , "space", "vision", "paradigm", "mission" };

        // Find how many words are each list
        int len1 = wordListOne.length;
        int len2 = wordListTwo.length;
        int len3 = wordListThree.length;

        // Generate three random numbers
        int rand1 = rand.nextInt(len1);
        int rand2 = rand.nextInt(len2);
        int rand3 = rand.nextInt(len3);

        // Building a phrase
        String phrase = (wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".");
        
        // Display the result in a dialog box
        JOptionPane.showMessageDialog(null, "What we need is " + phrase);
    }
}