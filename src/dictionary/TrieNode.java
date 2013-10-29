/**
 * TODO Class Description
 * TODO Invariants List
 * @author Mac Knutsen <mknutse1@umbc.edu>
 * @version Sep 22, 2013
 */
package dictionary;

import java.util.ArrayList;

public class TrieNode {

	private char c;
	private ArrayList<TrieNode> children;
	private boolean isWord;
	/**
	 * Constructor for Node
	 * @param c
	 * @param children
	 * @param isWord
	 */
	public TrieNode(char c, ArrayList<TrieNode> children, boolean isWord){
		this.c = c;
		this.children = children;
		this.isWord = isWord;
	}
	/**
	 * Constructor for Node
	 * @param c
	 */
	public TrieNode(char c){
		this(c, null, false);
		children = new ArrayList<TrieNode>();
	}
	/**
	 * Constructor for Node
	 * @param c
	 * @param isWord
	 */
	public TrieNode(char c, boolean isWord){
		this(c,null,isWord);
	}

	/**
	 * @return the character
	 */
	public char getC() {
		return c;
	}
	/**
	 * @param c the character to set
	 */
	public void setC(char c) {
		this.c = c;
	}
	/**
	 * @return the children
	 */
	public ArrayList<TrieNode> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<TrieNode> children) {
		this.children = children;
	}
	/**
	 * @return the isWord
	 */
	public boolean isWord() {
		return isWord;
	}
	/**
	 * @param isWord the isWord to set
	 */
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	/**
	 * Adds child for the next string and then passes it forwards
	 * @param String that needs to be processed by the trie
	 */
	public void addWord(String nextLine) {
		String nextLetter = "";
		if(nextLine.length()>1)
			nextLetter = nextLine.substring(1);
		if(nextLine.equals("")){
			isWord = true;
		}
		else{
			boolean isChild = false;
			int i = 0;
			while(i<children.size() && !isChild){
				if(children.get(i).getC() == nextLine.charAt(0)){
					isChild = true;
					children.get(i).addWord(nextLetter);
				}
				else
					i++;
			}
			if(!isChild){
				children.add(new TrieNode(nextLine.charAt(0)));
				children.get(children.size()-1).addWord(nextLetter);
			}
		}
	}
	/**
	 * @param word
	 * @return true if word, false if not
	 */
	public boolean checkWord(String word) {
		if(word.equals(""))
			return isWord;
		String nextLetter = "";
		if(word.length()>1){
			nextLetter = word.substring(1);
		}
		for(int i=0;i<children.size();i++){
			if(children.get(i).getC() == word.charAt(0)){
				return children.get(i).checkWord(nextLetter);
			}
		}
		return false;
	}
	/**
	 * Recursive method that checks if stem is in the dictionary
	 * @param str
	 *        : String of stem to check
	 * @return true if stem is in the dictionary, false otherwise
	 */
	public boolean checkStem(String str) {
		str  = str.toLowerCase();
		if(str.length() == 0){
			return true;
		}
		else{
			char nextLetter  = str.charAt(0);
			if(str.length() == 1)
				str = "";
			else
				str = str.substring(1);
			for(TrieNode child:children){
				if(child.getC() == nextLetter){
					return child.checkStem(str);
				}
			}
			return false;
		}
	}
	/**
	 * @param word
	 * @return
	 */
	public TrieNode getNode(String word) {
		// TODO Auto-generated method stub
		if(word.length() == 0){
			return this;
		}
		char nextLetter = word.charAt(0);
		if(word.length()==1)
			word = "";
		else
			word = word.substring(1);
		for(int i=0;i<children.size();i++){
			if(children.get(i).getC() == nextLetter){
				
			}
		}
		return null;
	}
	/**
	 * @param string
	 * @return
	 */
	public boolean hasChild(String string) {
		// TODO Auto-generated method stub
		for(TrieNode node:children){
			if(string.charAt(0) == node.getC()){
				return true;
			}
		}
		return false;
	}
}
