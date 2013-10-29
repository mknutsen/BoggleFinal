/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Oct 11, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */
package bogglegraph;

import java.util.ArrayList;
import java.util.Hashtable;

import dictionary.Boggle;

/**
 * @author Max
 *
 */
public abstract class BoggleGraph {
	protected BoggleTile[][] board;
	protected ArrayList<String> words;
	/**
	 * Constructor for BoggleGraphs
	 * Copies the given boggle and then runs the method next on each cell
	 * @param boggin
	 *        : Boggle board to be used as the basis for the boggle graph
	 */
	public BoggleGraph(Boggle boggin){
		words = new ArrayList<String>();
		board = new BoggleTile[5][5];
		for(int i=0;i<5;i++){
			System.out.println("Starting to copy the row");
			for(int j=0;j<5;j++){
				System.out.println("copying cell "+i+" "+j);
				board[i][j] = new BoggleTile(boggin.getBoard()[i][j], i,j);
			}
		}
		System.out.println("Done copying the board");
	}
	protected void setUp(){
		Hashtable<Character, int[]> tempHash;
		int[] coordinates;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.println("in cell "+i+" "+j+": "+board[i][j].getCharacter());
				tempHash = new Hashtable<Character, int[]>();
				coordinates = new int[2];
				coordinates[0] = i;
				coordinates[1] = j;
				tempHash.put(board[i][j].getCharacter().charAt(0),coordinates);
				words.addAll(next(board[i][j],"", tempHash));
				System.out.println("Size: "+words.size());
			}
		}
	}
	/**
	 * Abstract method next is a recursive method that recieves a starting tile
	 * and calls itself on all of the tiles surrounding it
	 * @param square
	 *        : Starting BoggleTile
	 * @param word
	 *        : String, running total of the word so far
	 * @param past
	 *        : Hashtable<Character, int[]> of used characters. the int[] holds the coordinate points
	 * @return ArrayList<String> of words found
	 */
	abstract ArrayList<String> next(BoggleTile square, String word, Hashtable<Character, int[]> past);
	
	/**
	 * gets the BoggleTiles surrounding a specific x,y coordinate
	 * @param x
	 *        : x coordinate
	 * @param y
	 *        : y coordinate
	 * @return an ArrayList<BoggleTile> of the surroundings
	 */
	public ArrayList<BoggleTile> getSurroundings(int x, int y) {
		//System.out.println("in getsurroundings");
		//System.out.println("SURROUNDINGS FOR "+board[x][y]);
		ArrayList<BoggleTile> craig = new ArrayList<BoggleTile>();
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				if(i+x > 0 && i +x < 5 && j+y > 0 && j+y<5){
					//System.out.println("I and J: "+i+" "+j);
					craig.add(new BoggleTile(this.board[i+x][j+y]));
					//System.out.println(board[i+x][j+y]);
				}
				if(i+x > 0 && i + x < 5){
					//System.out.println("I and J: "+i+" "+j);
					craig.add(new BoggleTile(this.board[i+x][y]));
					//System.out.println(board[i+x][y]);
				}
				if(j+y > 0 && j+y<5){
					//System.out.println("I and J: "+i+" "+j);
					craig.add(new BoggleTile(this.board[x][j+y]));
					//System.out.println(board[x][j+y]);
				}
			}
		}
		int i;
		for(int j=0;j<craig.size();j++){
			i=j+1;
			while(i<craig.size()){
				if(craig.get(i).isEqual(craig.get(j))){
					craig.remove(i);
				}
				else i++;
			}
		}
		for(i=0;i<craig.size();i++){
			if(craig.get(i).isEqual(board[x][y])){
				craig.remove(i);
			}
		}
		//System.out.println("leaving getsurroundings with "+craig.size()+" surroundings");
		return craig;
	}
	
	/**
	 * @return the ArrayList of words
	 */
	public ArrayList<String> getWords(){
		return words;
	}
	/**
	 * @return String of all the words in ArrayList<String> words
	 */
	public String toString(){
		String str = "";
		for(String word:words){
			str+=word+"\n";
		}
		return str;
	}
}