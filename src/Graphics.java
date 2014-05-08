
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 24, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */

/**
 * @author Max
 *
 */
public class Graphics extends JFrame{
	private static final long serialVersionUID = 1L;
	public Graphics(){
		Board charles  = new Board();
		charles.setPreferredSize(new Dimension(700,500));
		charles.setFocusable(true);
		charles.requestFocusInWindow();
		add(charles);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(711,523);
		setLocationRelativeTo(null);
		setTitle("Connect4");
		setVisible(true);
		//Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(""), new Point(this.getX(), this.getY()), "");
        //this.setCursor(c);//          THESE LINES SET THE CURSOR TO INVISIBLE
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphics b =new Graphics();
		b.setVisible(true);
	}
}
