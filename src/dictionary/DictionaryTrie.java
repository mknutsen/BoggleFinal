/**
 * BoggleDictionary using Trie search method
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 22, 2013
 */
package dictionary;

import java.io.File;
import java.util.Scanner;

public class DictionaryTrie extends BoggleDictionary{
	private TrieNode root;
	public DictionaryTrie(File dictionary){
		super(dictionary);
		root =  new TrieNode(' ');
		setUpDictionary();
	}
	/**
	 * @param nextLine
	 */
	public void setUpDictionary() {
		while(scan.hasNext()){
			root.addWord(scan.nextLine());
		}
	}
	/**
	 * @return the root
	 */
	public TrieNode getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(TrieNode root) {
		this.root = root;
	}
	/**
	 * checks to see if word is in the dictionary
	 * @param word
	 * @return true if word is in dictionary
	 */
	public boolean checkWord(String word){
		word = word.toLowerCase();
		return root.checkWord(word);
	}
	/**
	 * Checks stem of word to see if its part of a word in the dictionary
	 * @param str
	 *        : String of stem to check
	 * @return true if stem is in the dictionary, false otherwise
	 */
	public boolean checkStem(String str){
		return root.checkStem(str);
	}
	public static void main(String[] args){
		System.out.println();
		DictionaryTrie x  = new DictionaryTrie(new File("dictionary.txt"));
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		while(!temp.equals("q")){
			System.out.println("Is stem? "+x.checkStem(temp));
			System.out.println("Is word? "+x.checkWord(temp));
			temp = scan.nextLine();
		}
	}
	/**
	 * @param word
	 * @return
	 */
	public TrieNode getNode(String word) {
		// TODO Auto-generated method stub
		return root.getNode(word);
	}
}
