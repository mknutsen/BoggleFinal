/**
 * TODO Class Description
 * TODO Invariants List
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 21, 2013
 */
package mknutsen.boggle.dictionary;

import java.io.File;

/**
 * 
 */
public class DictionaryArrayListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("starting");
		DictionaryArrayList cat = new DictionaryArrayList(("mknutsen/boggle/dictionary2.txt"));
		cat.printDictionaryToFile(new File("mknutsen/boggle/dict2.txt"));
	}

}
