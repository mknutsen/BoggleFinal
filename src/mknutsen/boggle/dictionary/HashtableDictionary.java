/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 23, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */
package mknutsen.boggle.dictionary;

import java.io.File;
import java.util.Hashtable;

/**
 * @author Max
 *
 */
public class HashtableDictionary extends BoggleDictionary{
	Hashtable<Integer, String> dictionary;
	
	/**
	 * @param file
	 */
	public HashtableDictionary(String file) {
		super(file);
		dictionary = new Hashtable<Integer, String>(83907);
		setUpDictionary();
	}

	/**
	 * @param word
	 * @return whether or not the word is in the mknutsen.boggle.dictionary
	 */
	boolean checkWord(String word) {
		return dictionary.containsValue(word);
	}

	/**
	 * builds the hash table
	 */
	void setUpDictionary() {
		int i = -1;
		while(scan.hasNext()){
			i++;
			dictionary.put(i,scan.nextLine());
		}
	}
	public void setDictionary(Hashtable<Integer, String> dictionary) {
		this.dictionary = dictionary;
	}
	public Hashtable<Integer, String> getDictionary() {
		return dictionary;
	}

}
