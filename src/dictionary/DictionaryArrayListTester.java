/**
 * TODO Class Description
 * TODO Invariants List
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 21, 2013
 */
package dictionary;

import java.io.File;
import java.util.Scanner;

/**
 * 
 */
public class DictionaryArrayListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("starting");
		DictionaryArrayList cat = new DictionaryArrayList(new File("dictionary2.txt"));
		cat.printDictionaryToFile(new File("dict2.txt"));
	}

}
