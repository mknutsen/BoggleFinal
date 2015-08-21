/**
 * TODO Class Description Class invariants: TODO Invariants list:
 *
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 21, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */
package mknutsen.boggle.dictionary;

import java.util.Scanner;

/**
 * @author Max
 */
public abstract class BoggleDictionary {

    Scanner scan;

    public BoggleDictionary(String fileName) {
        scan = null;
        getClass().getResourceAsStream(fileName);
        scan = new Scanner(getClass().getResourceAsStream(fileName));
    }

    abstract boolean checkWord(String word);

    abstract void setUpDictionary();
}
