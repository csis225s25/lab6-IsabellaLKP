import java.awt.*;
import javax.swing.*;

/**
 * creating our very own art project 
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Isabella Pafundi
 * @author Colin Fisher
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel  {

    @Override
    public void paintComponent(Graphics g)  {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        
        //Oval
        g.setColor(Color.BLUE);
        g.fillOval(getWidth()/2-15, getHeight()/2, 30,30);
        //Rectangle
        g.setColor(Color.RED);
        g.fillRect(getWidth()/2+15, getHeight()/2-10, 30, 20);

        //line
        g.setColor(Color.BLACK);
        g.drawLine(getWidth()/2,250,200,250);

        //polygon
        int[] x = {getWidth()/2,40,70};
        int[] y={getHeight()/2,100,150};
        g.fillPolygon(x, y , 3);
        //arc
        g.drawArc(getWidth()/2-10,getHeight()/2-25, 50,50,  90, 180);

    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
