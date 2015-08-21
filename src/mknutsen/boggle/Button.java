package mknutsen.boggle;

import java.awt.Image;
import java.awt.event.MouseEvent;
/**
 * 
 * @author Max
 *
 */

public class Button implements Comparable<Button> {
	private int startX, endX, startY, endY, row, col;
	private String text;
	private Image image;
	public Button(int x, int y, int l, int w, Image i, String text, int row, int col){
		setRow(row);
		setCol(col);
		setStartX(x);
		setStartY(y);
		setEndX(x+l);
		setEndY(y+w);
		setText(text);
		setImage(null);
	}
	public Button(int x, int y, int l, int w, String text, int row, int col){
		this(x,y,l,w,null,text, row ,col);
	}
	public Button(int x, int y, int l, int w, Image i, int row, int col){
		this(x, y, l, w, i, null, row, col);
	}
	/**
	 * Determines if mouse event occurs inside the given button
	 * @param e :
	 * 		MouseEvent
	 * @return true if MouseEvent e was inside the Button
	 */
	public boolean isInside(MouseEvent e){
		if(e.getX() >= startX && e.getX() <=endX && e.getY() <= endY && e.getY() >= startY){
			return true;
		}
		return false;
	}
	/**
	 * @param otherButton :
	 * 		 just any other button
	 * @return 1 if buttons start in  the same place; 0 otherwise
	 */
	public int compareTo(Button otherButton) {
		if(row == otherButton.row && col == otherButton.col){
			return 1;
		}
		return 0;
	}
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}
	/**
	 * @param startX the startX to set
	 */
	public void setStartX(int startX) {
		this.startX = startX;
	}
	/**
	 * @return the endX
	 */
	public int getEndX() {
		return endX;
	}
	/**
	 * @param endX the endX to set
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}
	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}
	/**
	 * @param startY the startY to set
	 */
	public void setStartY(int startY) {
		this.startY = startY;
	}
	/**
	 * @return the endY
	 */
	public int getEndY() {
		return endY;
	}
	/**
	 * @param endY the endY to set
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
}
