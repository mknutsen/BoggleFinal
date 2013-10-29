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
public class DictionaryTrieTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("starting");
		DictionaryTrie cat = new DictionaryTrie(new File("dictionary.txt"));
		String input = "";
		while(!input.equals("quit")){
			System.out.println("Input a word");
			input = scan.next();
			System.out.println(cat.checkWord(input));
		}
		scan.close();
	}

}
