/**
 * I would set up the graph by first creating a 4x4 array of BoggleTiles. These would each hold a character and a hash
 * table. The hash table would have characters as keys and array lists as values. The value array list would be the
 * references to each neighbor with that letter. In this way we can easily look at a tile, decide what letters are
 * around it, and jump to the next tile. Encapsulating the boggle tile array should be a boggle graph object. This
 * should contain a method asking isWordInGtaph. The graph object should also have a hash with letters mapped to array
 * lists of boggle tiles. This will be useful to get the search started. Then, I'll you should have to do is: In the
 * graph: Pop off the first letter If letter is in hash For each tile in array list If ( canMakeWordUsingTile(tile, rest
 * of word) Return true Return false
 * <p/>
 * Then your tiles should do a similar form of recursion where they pop off the first letter, see if it's in the tile's
 * hash, then send the rest of the word to EACH of its neighbors with that letter and repeat!
 *
 * @author Max
 */
package mknutsen.boggle.bogglegraph;

import mknutsen.boggle.dictionary.Boggle;

import java.util.ArrayList;
import java.util.Hashtable;

public class BoggleGraphBrute extends BoggleGraph {

    /**
     * Constructor for the BoggleGraph class
     * @param boggin
     *        : Boggle board to be graphed and analyzed
     */
    public BoggleGraphBrute(Boggle boggin) {
        super(boggin);
        setUp();

    }

    public static void main(String[] args) {
        String[] x = {
                "R", "S", "C", "L", "S", "D", "E", "I", "A", "E", "G", "N", "T", "R", "P", "I", "A", "E", "S", "O", "L",
                "M", "I", "D", "C"};
        String[][] y = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                y[i][j] = x[i * 5 + j];
            }
        }
        //		Boggle boggin2 = new Boggle(y);
        Boggle boggin = new Boggle();
        System.out.println("RANDOMIZED BOARD\n" + boggin);
        BoggleGraph graph = new BoggleGraphBrute(boggin);
        System.out.println("TOTAL WORDS FOUND " + boggin.analyzeList(graph.getWords()));
        //		System.out.println("BEST BOARD EVER BOARD\n"+boggin2);
        //		BoggleGraph graph2 = new BoggleGraphBrute(boggin2);
        //		System.out.println("TOTAL WORDS FOUND "+boggin2.analyzeList(graph2.getWords()));
        /*System.out.println("Number of words: "+boggin.analyzeList(graph.getWords()));
		System.out.println("Score: "+boggin.getTotalScore());*/
    }

    /* (non-Javadoc)
     * @see mknutsen.boggle.bogglegraph.BoggleGraph#next(mknutsen.boggle.bogglegraph.BoggleTile, java.lang.String,
     * java.util.Hashtable)
     */
    @Override
    public ArrayList<String> next(BoggleTile square, String word, Hashtable<Character, int[]> past) {
        //System.out.println("Next: "+word);
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<BoggleTile> table = getSurroundings(square.getX(), square.getY());
        Hashtable<Character, int[]> n = null;
        int[] coordinates, newCoordinates;
        boolean alreadyUsed;
        if (word.length() < 12) {
            alreadyUsed = false;
            for (BoggleTile tile : table) {
                //System.out.println(word);
                if (past.containsKey(tile.getCharacter().charAt(0))) {
                    coordinates = past.get(tile.getCharacter().charAt(0));
                    for (int i = 0; i < coordinates.length; i += 2) {
                        if (coordinates[i] == tile.getX() && coordinates[i + 1] == tile.getY()) {
                            alreadyUsed = true;
                        }
                    }
                    if (alreadyUsed) {
                        //DO NOTHING
                        //System.out.println("no reusing "+tile.getX()+" "+tile.getY());
                    } else if (!alreadyUsed) {
                        newCoordinates = new int[coordinates.length + 2];
                        //System.out.println("OLD COORDINATES:");
                        for (int i = 0; i < coordinates.length; i++) {
                            newCoordinates[i] = coordinates[i];
                            //System.out.print(coordinates[i]+" ");
                        }
                        newCoordinates[newCoordinates.length - 2] = square.getX();
                        newCoordinates[newCoordinates.length - 1] = square.getY();
                        //System.out.println(newCoordinates[0]+" "+newCoordinates[1]);
                        n = (Hashtable<Character, int[]>) past.clone();
                        n.put(tile.getCharacter().charAt(0), newCoordinates);
                        words.addAll(next(tile, word + square.getCharacter(), past));
                    }
                } else {
                    coordinates = new int[2];
                    coordinates[0] = tile.getX();
                    coordinates[1] = tile.getY();
                    //System.out.println("NEW coordinates: "+coordinates[0]+" "+coordinates[1]);
                    n = (Hashtable<Character, int[]>) past.clone();
                    n.put(tile.getCharacter().charAt(0), coordinates);
                    words.addAll(next(tile, word + square.getCharacter(), n));
                }
            }
        } else {
            words.add(word);
        }
        return words;
    }
}
