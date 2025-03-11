import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import javax.swing.event.*;

/**
 * It will create a window that opens up and counts the amount of times you press on the window.
 * It will also have a reset button to reset the amount of times you clicked.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Isabella Pafundi
 * @author Colin Fisher
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable {
    private int count = 0; //Tracks the amount of clicks
    private String toDisplay = "Mouse Press Count: " + count; //adds the Mouse Press Count to see
	JButton reset = new JButton("Reset"); //Adds a reset jbutton
	

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MousePressCounter");
		frame.setPreferredSize(new Dimension(500, 500));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);
						reset.setLocation(frame.getWidth()/2-reset.getWidth()/2, frame.getHeight()-reset.getWidth());


				FontMetrics fm = g.getFontMetrics();

				
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
                repaint();
			}
            
		};
		frame.add(panel);
		panel.add(reset);
		reset.addMouseListener(this);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);


		// display the window we've created
		frame.pack();
		frame.setVisible(true);
        
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == reset){//if the source is reset button then reset the count.
			count = 0;
			toDisplay = "Mouse Press Count: " + count;
		}
		else{ //otherwise add to the count.
			count++;
        	toDisplay = "Mouse Press Count: " + count;
		}
        
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
