import javax.swing.*;

public class GuiTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton button = new JButton("Click Here");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
