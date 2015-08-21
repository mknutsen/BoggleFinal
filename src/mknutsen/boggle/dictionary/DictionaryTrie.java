/**
 * BoggleDictionary using Trie search method
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 22, 2013
 */
package mknutsen.boggle.dictionary;

import java.io.File;
import java.util.Scanner;

public class DictionaryTrie extends BoggleDictionary{
	private TrieNode root;
	public DictionaryTrie(String dictionary){
		super(dictionary);
		root =  new TrieNode(' ');
		setUpDictionary();
	}
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
	 * checks to see if word is in the mknutsen.boggle.dictionary
	 * @param word
	 * @return true if word is in mknutsen.boggle.dictionary
	 */
	public boolean checkWord(String word){
		word = word.toLowerCase();
		boolean x =  root.checkWord(word);
//		System.out.println(word +" is "+ x);
		return x;
	}
	/**
	 * Checks stem of word to see if its part of a word in the mknutsen.boggle.dictionary
	 * @param str
	 *        : String of stem to check
	 * @return true if stem is in the mknutsen.boggle.dictionary, false otherwise
	 */
	public boolean checkStem(String str){
		return root.checkStem(str);
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
