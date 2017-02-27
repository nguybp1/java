/*Assigment9.java
 * November 4 ,2015
 * This programs paints 11 red circles on the frame and fills certain circles to red with a background color of cyan 
 */
 
import javax.swing.*;
import java.awt.*;

public class Assignment9 {

	public static void main(String[] args) {
		JFrame f = new JFrame("Assignemnt 9");
		OPanel o = new OPanel();
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(o);
	}
}

class OPanel extends JPanel {
	// constructor
	public OPanel() {
		setBackground(Color.CYAN);
	}

	public void paintComponent(Graphics g) {
		int counter =0;
		super.paintComponent(g);
		g.setColor(Color.RED);
		for (int i = 10; i < 120; i += 10) {
			counter++;
			//System.out.println(counter + "\t" + i);
			if (counter == 2 || counter == 6 || counter == 10) {
				g.fillOval(i, i, 30, 30);
				g.drawOval(i, i, 30, 30);		
			} else {
				g.drawOval(i, i, 30, 30);
			}
		}
	}
}