
import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 26, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */

/**
 * @author Max
 *
 */
public class CircularButton extends Button {
	private int radius;
	/**
	 * given the x,y coordinate of the center and the radius r
	 * @param x
	 * @param y
	 * @param r
	 * @param i
	 * @param text
	 * @param row
	 * @param col
	 */
	public CircularButton(int x, int y, int r, Image i, int row, int col, String text) {
		super(x, y, r, r, i, text, row, col);
		setRadius(r);
		// TODO Auto-generated constructor stub
	}
	public CircularButton(int x, int y, int r, int row, int col, String text) {
		super(x, y, r, r, text, row, col);
		setRadius(r);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
		//System.out.println(radius+"   "+this.radius);
	}
	public boolean isInside(MouseEvent e){
		double deltaX = (e.getX() - getStartX());
		double deltaY = (e.getY() - getStartY());
		double distance = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
//		System.out.println("You clicked "+e.getX()+"  "+e.getY());
//		System.out.println("center is: "+getStartX()+"  "+getStartY());
//		System.out.println("distance is "+deltaX+" + "+deltaY+" = "+distance+"\nradius is "+radius);
		return (distance < radius);
	}
	public int equals(CircularButton x){
		if (x.getStartX() == getStartX() && x.getStartY() == getStartY() && getRadius() == x.getRadius())
			return 1;
		else return 0;
	}

}
