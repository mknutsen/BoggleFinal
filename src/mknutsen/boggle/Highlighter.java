package mknutsen.boggle;

import java.awt.*;

/**
 * TODO Class Description Class invariants: TODO Invariants list:
 *
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 25, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */

/**
 * @author Max
 */
public class Highlighter extends CircularButton {

    private static final int radius = 50;

    private static Image image;

    /**
     * Constructs highlighter
     *
     * @param x-coordinate
     * @param y-coordinate
     * @param length
     * @param width
     */
    public Highlighter(int x, int y, String text, int row, int col) {
        super(x, y, radius, image, row, col, text);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs highlighter with the same pro	perties as the given button
     *
     * @param Button
     */
    public Highlighter(CircularButton b) {
        super(b.getStartX(), b.getStartY(), b.getRadius(), image, b.getRow(), b.getCol(), b.getText());
    }

    /**
     * Sets the permanent highlighter image
     *
     * @param ImageIcon
     */
    public static void setHighlighterImage(Image i) {
        image = i;
    }

    /**
     * @return highlighter image
     */
    public static Image giveImage() {
        return image;
    }
}
