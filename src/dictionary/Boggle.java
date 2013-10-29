package dictionary;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;


/**
 * @author Max
 *
 */
public class Boggle {
	private DictionaryTrie dictionary;
	private String[][] board;
	private Random rand;
	private Hashtable<String, Integer> foundWords;
	private final String[] dice = {"AAAFRS","AEEGMU","CEIILT","DHLNOR", "FIPRSY", "AAEEEE", "AEGMNN", "CEILPT", "DDLNOR", "GORRVW", "AAFIRS", "AFIRSY", "CEIPST", 
								   "EIIITT", "HIPRRY", "ADENNN", "BJKQXZ", "DHHNOT", "EMOTTT", "NOOTUW", "AEEEEM", "CCNSTW", "DHHLOR", "ENSSSU", "OOOTTU"};
	/**
	 * Constructor for Boggle
	 * Creates new Boggle board 5x5 array of strings and randomizes it
	 */
	public Boggle(){
		setDictionary(new DictionaryTrie(new File("dictionary.txt")));
		foundWords = new Hashtable<String, Integer>();
		rand = new Random();
		board = new String[5][5];
		randomizeBoard();
	}
	public Boggle(String[][] x){
		this();
		board = x;
	}

	/**
	 * Takes the DICE and picks a random letter for each dice and then selects a random place for the dice to be
	 */
	private void randomizeBoard() {
		ArrayList<String> temp = new ArrayList<String>();
		String x="";
		for(int i = 0; i<dice.length;i++){
			x = ""+dice[i].charAt(rand.nextInt(dice[i].length()));
			temp.add(x);
		}
		int random;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				random = rand.nextInt(temp.size());
				board[i][j]=temp.get(random);
				temp.remove(random);
			}
		}
	}
	public Hashtable<String, Integer> getFoundWords(){
		return foundWords;
	}
	public ArrayList<String> getFoundWordArrayList(){
		ArrayList<String> words = new ArrayList<String>();
		Enumeration<String> x = foundWords.keys();
		while(x.hasMoreElements()){
			words.add(x.nextElement());
		}
		return words;
	}
	/**
	 * @return the board
	 */
	public String[][] getBoard() {
		return board;
	}
	public String toString(){
		String output = "";
		for(int i = 0;i < board.length; i++){
			for(int j=0;j<board[0].length;j++){
				output+="[ "+board[i][j]+"] ";
			}
			output+="\n";
		}
		return output;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(String[][] board) {
		this.board = board;
	}
	public int getScore(String x){
		int y = x.length();
		if(y <=4) return 1;
		else if(y==5) return 2;
		else if(y==6) return 3;
		else if(y==7) return 5;
		else return 11;
	}
	public void parseString(String str){
		for(int i = 3 ; i<=str.length(); i++){
			checkWord(str.substring(0,i));
		}
	}

	/**
	 * @return the dictionary
	 */
	public DictionaryTrie getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary the dictionary to set
	 */
	public void setDictionary(DictionaryTrie dictionary) {
		this.dictionary = dictionary;
	}
	public int getTotalScore(){
		int total = 0;
		Object[] x = foundWords.values().toArray();
		for(Object word:x){
			int num = (int)(word);
			total+=num;
		}
		return total;
	}

	/**
	 * checks to see if the word is in the dictionary
	 * @param String
	 * @return if word is in the dictionary
	 */
	public boolean checkWord(String str) {
		if(dictionary.checkWord(str)){
			if(foundWords.containsKey(str))
				return false;
			foundWords.put(str,new Integer(getScore(str)));
			return true;
		}
		else return false;
	}

	/**
	 * @param words
	 */
	public int analyzeList(ArrayList<String> words) {
		// TODO Auto-generated method stub
		System.out.println("starting to analyze list");
		for(String word:words){
			//System.out.println("Parsing "+word);
			parseString(word);
		}
		System.out.println("done parsing");
		Enumeration<String> values = foundWords.keys();
		String nextValue;
		while(values.hasMoreElements()){
			nextValue = values.nextElement();
			System.out.println(nextValue);
		}
		System.out.println("Total score: "+getTotalScore());
		return foundWords.size();
	}
}
