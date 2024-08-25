package phraseomatic;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class PhraseoComposer {
    public static void main(String[] args) {
        WordsBox wordsBox = new WordsBox();        

        // Building a phrase
        String phrase = wordsBox.composePhrase();
        
        // Display the result in a dialog box
        System.out.println("What we need is " + phrase);
}
}

class WordsBox {
        private static Random rand = new Random();

        // Make three sets of words to choose from. Add your own!
        private String[] wordListOne = {"24/7", "multi Tiar", "30,OOO foot", "B-to-B",
        "win-win", "front-end", "web-based", "pervasive", "smart",
        "six-sigma", "critical-path" , "dynamic" };

       private String[] wordListTwo = { "empowered", "sticky", "value-added.", "oriented",
        "centric", "distributed", "clustered", "branded", "outside-the-box",
        "positioned", "networked", " focused", "leveraged", "aligned",
        "targeted", "shared", "cooperative", "accelerated" };

       private String[] wordListThree = {"process", "tipping-point", "solution",
        "architecture", "core competency", "strategy", "mindshare",
        "portal" , "space", "vision", "paradigm", "mission" };
        
        WordsBox() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.now();
                System.out.println(localDateTime.format(formatter));
        }

        // Find how many words are each list
        private int len1 = wordListOne.length;
        private int len2 = wordListTwo.length;
        private int len3 = wordListThree.length;

        // Generate three random numbers
        private int rand1 = rand.nextInt(len1);
        private int rand2 = rand.nextInt(len2);
        private int rand3 = rand.nextInt(len3);

        String composePhrase() {
                return (wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".");
        }
}