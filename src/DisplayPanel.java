import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

// this class is a subclass of JPanel
public class DisplayPanel extends JPanel {

    public DisplayPanel() { }

    /* the system calls the paintComponent method automatically when
       you add the DisplayPanel to the frame in order to "paint it" onto
       the frame (i.e. display it); NEVER call this method explicitly!! */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // always put this
        Graphics2D g2d = (Graphics2D) g; // cast g to a 2D graphics object

        // create a Rectangle object (note: this is a built-in Rectangle class)
        Rectangle rect1 = new Rectangle(70, 30);

        // set rectangle's location to be x = 50, y = 30;
        // note that (0, 0) is TOP LEFT corner (not bottom left),
        // and +x direction is to the right, and +y direction is DOWN (not up)
        rect1.setLocation(50, 30);

        // draw rectangle on the screen with red pen
        g2d.setStroke(new BasicStroke(3)); // 3 is pen "thickness"
        g2d.setColor(Color.RED); // set draw color to red
        g2d.draw(rect1); // draw rectangle
    }
}