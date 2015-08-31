/**
 * TODO Class Description Class invariants: TODO Invariants list:
 *
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 26, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */

package mknutsen.boggle.bogglegraph;

/**
 * @author Max
 *
 */
public class BoggleTile {

    private String character;

    private int x, y;

    /**
     * Constructor for BoggleTile
     * @param ch
     *        : character on the tile
     * @param x
     *        : x coordinate of the tile
     * @param y
     *        : y coordinate of the tile
     * @param surroundings
     *        : ArrayList of surrounding BoggleTiles
     */
    public BoggleTile(String ch, int x, int y) {
        setCharacter(ch);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Copy Constructor
     * @param x
     *        : BoggleTile to be copied
     */
    public BoggleTile(BoggleTile x) {
        this(x.getCharacter(), x.getX(), x.getY());
    }

    /**
     * @return the character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @param character the character to set
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return character + " at " + x + ", " + y + "\n";
    }

    /**
     * checks to see if BoggleTile other has the same character and coordinates as this boggletile
     * @param other
     *        : BoggleTile to be checked
     * @return true if equal, false otherwise
     */
    public boolean equals(BoggleTile other) {
        return character.equals(other.getCharacter()) && x == other.getX() && y == other.getY();
    }
}
