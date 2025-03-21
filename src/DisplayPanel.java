import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class DisplayPanel extends JPanel {

    // create instance variables to store (x, y) location of rectangle
    private int rectX;
    private int rectY;

    // create instance variable for Rectangle, so we can access it in different methods
    private Rectangle rect1;

    public DisplayPanel() {
        // set starting position of rectangle to be (50, 30)
        rectX = 50;
        rectY = 30;

        // initialize rect1 here (not in paintComponent)
        rect1 = new Rectangle(70, 30);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        rect1.setLocation(rectX, rectY);  // set location to (rectX, rectY)
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        g2d.draw(rect1);
    }

    public void setRect1(int x, int y) {
        rect1.setLocation(x,y);
    }
}