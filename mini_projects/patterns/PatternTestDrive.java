package mini_projects.patterns;
import javax.swing.JOptionPane;

public class PatternTestDrive {
    public static void main(String[] args) {
        String strChar = "*";
        String strRows = JOptionPane.showInputDialog(null, "Enter number of Steps(rows)");
        int rows = Integer.parseInt(strRows);

        drawPattern(strChar, rows);
    }

    static void drawPattern(String strChar, int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(strChar);
            }
            System.out.println("\n");
        }
    }
}
