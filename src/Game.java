import javax.swing.*;
import java.util.ArrayList;

public class Game {
    //instance variables
    ArrayList spaces;
    boolean win = true;


    //methods
    public void playGame() {
        while(!win) {
            System.out.println(spaces);

        }
    }

    //helpers (if needed)

    public Game() {
        // create a JFrame (a window) and with a particular text for the title bar
        JFrame frame = new JFrame("Frame title");

        // apply setting to that clicking X in top right of window will close window and end program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set frame to have 300 width, 200 height
        frame.setSize(300, 200);

        // auto-center the frame on the screen
        frame.setLocationRelativeTo(null);

        // create and add a DisplayPanel to the frame
        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);

        // display the frame (window)
        frame.setVisible(true);
    }
}
