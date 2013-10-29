/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 21, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Max
 *
 */
public abstract class BoggleDictionary {
	Scanner scan;
	public BoggleDictionary(File file){
		scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	abstract boolean checkWord(String word);
	abstract void setUpDictionary();
}
