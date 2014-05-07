package bogglegraph;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import dictionary.Boggle;
import dictionary.DictionaryTrie;

public class TraverseBoggleBoard {
	private Boggle boggin;
	private BoggleTile[][] board = new BoggleTile[5][5];
	public TraverseBoggleBoard(Boggle boggin){
		this.boggin = boggin;
		setUp();
	}

	public ArrayList<String> analyze() {
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<BoggleTile> tiles;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
//				System.out.println("In cell: "+i+", "+j);
//				word.addAll(checkPath("", board[i][j], new Hashtable<BoggleTile, Integer>(), new ArrayList<String>()));
				tiles = new ArrayList<BoggleTile>();
				tiles.add(board[i][j]);
				checkPath(tiles, word);
			}
		}
		return word;
	}

	private ArrayList<String> checkPath(String x, BoggleTile boggleTile, Hashtable<BoggleTile, Integer> pastTiles, ArrayList<String> words) {
		pastTiles.put(boggleTile, 1);
		x += boggleTile.c;
		if(boggin.getDictionary().checkWord(x)){
			words.add(x);
//			System.out.println(x);
		}
		if(boggin.getDictionary().checkStem(x) == false){
			return words;
		}
		ArrayList<BoggleTile> surroundings = getSurroundings(boggleTile);
		for(int i = 0; i < surroundings.size(); i++){
			if(pastTiles.containsKey(surroundings.get(i)) == false){
				words.addAll(checkPath(x, surroundings.get(i), (Hashtable<BoggleTile, Integer>)pastTiles.clone(), words));
			}
		}
		return words;
	}
	private ArrayList<String> checkPath(ArrayList<BoggleTile> word, ArrayList<String> foundWords){
		if(boggin.getDictionary().checkWord(toWord(word))){
			foundWords.add(toWord(word));
//			System.out.println(toWord(word));
		}
		if(boggin.getDictionary().checkStem(toWord(word)) == false)
			return foundWords;
		ArrayList<BoggleTile> surroundings = getSurroundings(word.get(word.size()-1));
		ArrayList<BoggleTile> clonedWord;
		for(int i=0;i<surroundings.size();i++){
			if(!word.contains(surroundings.get(i))){
				clonedWord = (ArrayList<BoggleTile>) word.clone();
				clonedWord.add(surroundings.get(i));
				checkPath(clonedWord, foundWords);
			}
		}
		return foundWords;
	}
	private String toWord(ArrayList<BoggleTile> word) {
		// TODO Auto-generated method stub
		String x = "";
		for(BoggleTile w:word)
			x+=w.c;
//		System.out.println(x);
		return x;
	}

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
	private void setUp() {
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				board[i][j] = new BoggleTile(i,j,boggin.getBoard()[i][j].charAt(0));
			}
		}
	}

	private class BoggleTile{
		int x,y;
		char c;
		BoggleTile(int x, int y, char c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
		public int hashCode(){
			int ascii = c;
			return ascii*100+x*10+y;
		}
		public boolean equals(BoggleTile other){
			return c == other.c && x == other.x && y == other.y;
		}
		public String toString(){
			return c+" @ "+x+" "+y;
		}
	}
	public static void main(String[] args){
		TraverseBoggleBoard x = new TraverseBoggleBoard(new Boggle());
//		System.out.println(x.boggin.toString());
		System.out.println(x.analyze().size());
 	}
}
