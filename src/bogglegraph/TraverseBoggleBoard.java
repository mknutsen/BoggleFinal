package bogglegraph;

import java.util.ArrayList;
import java.util.Arrays;

import dictionary.Boggle;
/**
 * Given a Boggle object, it finds all of the words (according the dictionary in the Boggle object) that exist on the boggle board
 * @author Max Knutsen <mknutse1@umbc.edu>
 *
 */
public class TraverseBoggleBoard {
	private Boggle boggin;
	private BoggleTile[][] board = new BoggleTile[5][5];
	private ArrayList<String> words;
	private ArrayList<ArrayList<BoggleTile>> wordPaths;
	/**
	 * TraverseBoggleBoard constructor, calls setUp
	 * @param boggin
	 *        : the boggle object to analyze
	 */
	public TraverseBoggleBoard(Boggle boggin){
		this.boggin = boggin;
		words = new ArrayList<String>();
		setUp();
		wordPaths = analyze();
	}
	/**
	 * Runs through the board and calls checkBoard on every cell
	 * @return an arraylist of arraylists of boggletiles. this will make it easy to construct a trajectory and display the found words on the boggle board (each internal arraylist represents a word)
	 */
	public ArrayList<ArrayList<BoggleTile>> analyze() {
		ArrayList<ArrayList<BoggleTile>> wordPaths = new ArrayList<ArrayList<BoggleTile>>();
		ArrayList<BoggleTile> tiles;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
//				System.out.println("In cell: "+i+", "+j);
//				word.addAll(checkPath("", board[i][j], new Hashtable<BoggleTile, Integer>(), new ArrayList<String>()));
				tiles = new ArrayList<BoggleTile>();
				tiles.add(board[i][j]);
				checkPath(tiles, wordPaths, words);
			}
		}
		return wordPaths;
	}
	/**
	 * This is a recursive method that only continues if the node for the character in the trie has children (so if there might be words that follow, it continues looking)
	 * @param word
	 *        : an arraylist of boggletiles to track the current path being analyzed
	 * @param foundWords
	 *        : an ArrayList of words that have been found so far by the algorithm
	 * @return an arraylist of found words (each found word being represented by an arraylist of boggletiles
	 */
	private ArrayList<ArrayList<BoggleTile>> checkPath(ArrayList<BoggleTile> word, ArrayList<ArrayList<BoggleTile>> foundWordPaths, ArrayList<String> foundWords){
		if(boggin.getDictionary().checkWord(toWord(word)) && foundWords.contains(toWord(word)) == false){
			foundWordPaths.add(word);
			foundWords.add(toWord(word));
//			System.out.println(toWord(word));
		}
		if(boggin.getDictionary().checkStem(toWord(word)) == false)
			return foundWordPaths;
		ArrayList<BoggleTile> surroundings = getSurroundings(word.get(word.size()-1));
		ArrayList<BoggleTile> clonedWord;
		for(int i=0;i<surroundings.size();i++){
			if(!word.contains(surroundings.get(i))){
				clonedWord = (ArrayList<BoggleTile>) word.clone();
				clonedWord.add(surroundings.get(i));
				checkPath(clonedWord, foundWordPaths, foundWords);
			}
		}
		return foundWordPaths;
	}
	/**
	 * Converts an arraylist of boggletiles to a string
	 * @param word
	 *        : arraylist of boggle tiles to be converted
	 * @return a string of the boggletile characters concatonated in order
	 */
	private String toWord(ArrayList<BoggleTile> word) {
		// TODO Auto-generated method stub
		String x = "";
		for(BoggleTile w:word)
			x+=w.c;
//		System.out.println(x);
		return x;
	}
	/**
	 * turns an arraylist of boggletile list-words to an arraylist of words represented by strings
	 * @param words
	 *        : arraylist of boggletile arraylists (each one representing a word)
	 * @return an arraylist of the strings (one string per internal arraylist in words)
	 */
	private ArrayList<String> allToWord(ArrayList<ArrayList<BoggleTile>> words){
		ArrayList<String> x = new ArrayList<String>();
		for(int i=0;i<words.size();i++){
			x.add(toWord(words.get(i)));
		}
		return x;
	}
	/**
	 * Gets all legal neighbors for a given tile (including diagonals)
	 * @param tile
	 *        : tile to be checked for neighbors
	 * @return an arraylist<boggletile> of all legal neighbors
	 */
	private ArrayList<BoggleTile> getSurroundings(BoggleTile tile){
		ArrayList<BoggleTile> surroundings = new ArrayList<BoggleTile>();
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				if(i==0 && j==0);
				else if(tile.x + i < 0 || tile.x + i >= 5 || tile.y + j < 0 || tile.y + j >= 5);
				else{
					surroundings.add(board[tile.x + i][tile.y + j]);
				}
			}
		}
		return surroundings;
	}
	/**
	 * Turns the boggle objects board into a 2D array of boggletiles
	 */
	private void setUp() {
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				board[i][j] = new BoggleTile(i,j,boggin.getBoard()[i][j].charAt(0));
			}
		}
	}
	/**
	 * Wrapper class for the boggle board so each tile contains its character and the coordinates at which it is located
	 * @author Max
	 */
	public class BoggleTile{
		int x,y;
		char c;
		/**
		 * Constructor for BoggleTile
		 * @param x
		 *        : [x][y] in a 2D array
		 * @param y
		 *        : [x][y] in a 2D array
		 * @param c
		 *        : the character that the boggletile holds
		 */
		BoggleTile(int x, int y, char c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
		/**
		 * I dont think this is needed, but the hashCode is the ascii value for the character concatonated with the x and y values
		 */
		public int hashCode(){
			int ascii = c;
			return ascii*100+x*10+y;
		}
		/**
		 * Checks equivalence with other tile
		 * @param other
		 *        : other tile
		 * @return true if x, y, and c are equivalent; false otherwise
		 */
		public boolean equals(BoggleTile other){
			return c == other.c && x == other.x && y == other.y;
		}
		public String toString(){
			return c+" @ "+x+" "+y;
		}
	}
	/**
	 * @return the arraylist of arraylist of boggletiles (each internal arraylist being a word)
	 */
	public ArrayList<ArrayList<BoggleTile>> getWordPaths() {
		return (ArrayList<ArrayList<BoggleTile>>) wordPaths.clone();
	}
	/**
	 * @return all the words as strings
	 */
	public ArrayList<String> getWords() {
		return (ArrayList<String>) words.clone();
	}
	/**
	 * Gets maximum total for the board
	 * @return total score for all the words the algorithm found
	 */
	public int getBoardScore(){
		int total  = 0;
		for(String word:words)
			total+=boggin.getScore(word);
		return total;
	}
	/**
	 * Simple test.
	 * Finds all the words in the board, copies it to an array and then sorts it and prints it so i could verify that there were no duplicates
	 */
	public static void main(String[] args){
			TraverseBoggleBoard x = new TraverseBoggleBoard(new Boggle());
	//		System.out.println(x.boggin.toString());
			x.analyze();
			
			String[] y = new String[x.words.size()];
			for(int i=0;i<y.length;i++){
				y[i] = x.words.get(i);
			}
			Arrays.sort(y);
			for(String word:y){
				System.out.print(word+", ");
			}
			System.out.println("\n"+x.getBoardScore());
	 	}
}
