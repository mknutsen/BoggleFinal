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

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import dictionary.Boggle;
import dictionary.DictionaryTrie;
import dictionary.TrieNode;

/**
 * @author Max
 *
 */
public class BoggleGraphElegant extends BoggleGraph {
	private DictionaryTrie trie = new DictionaryTrie(new File("dictionary.txt"));;
	/**
	 * @param boggin
	 */
	public BoggleGraphElegant(Boggle boggin) {
		super(boggin);
		trie = new DictionaryTrie(new File("dictionary.txt"));
		setUp();
	}

	/* (non-Javadoc)
	 * @see bogglegraph.BoggleGraph#next(bogglegraph.BoggleTile, java.lang.String, java.util.Hashtable)
	 */
	@Override
	ArrayList<String> next(BoggleTile square, String word, Hashtable<Character, int[]> past) {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<BoggleTile> table = getSurroundings(square.getX(),square.getY());
		TrieNode node = trie.getNode(word);
		BoggleTile tile;
		int[] coordinates, newCoordinates;
		Hashtable<Character,int[]> n;
		if(word.length()<12){
			boolean alreadyUsed;
			for(int i=0;i<table.size();i++){
				alreadyUsed = false;
				tile = table.get(i);
				if(node.hasChild(word+tile.getCharacter())){
					if(past.containsKey(tile.getCharacter().charAt(0))){
						coordinates = past.get(tile.getCharacter().charAt(0));
						for(int j=0;i<coordinates.length;j+=2){
							if(coordinates[j] == tile.getX() && coordinates[j+1] == tile.getY()){
								alreadyUsed = true;
							}
						}
						if(!alreadyUsed){
							newCoordinates = new int[coordinates.length+2];
							//System.out.println("OLD COORDINATES:");
							for(int k=0;k<coordinates.length;k++){
								newCoordinates[k] = coordinates[k];
								//System.out.print(coordinates[k]+" ");
							}
							newCoordinates[newCoordinates.length-2] = square.getX();
							newCoordinates[newCoordinates.length-1] = square.getY();
							//System.out.println(newCoordinates[0]+" "+newCoordinates[1]);
							n = (Hashtable<Character, int[]>) past.clone();
							n.put(tile.getCharacter().charAt(0), newCoordinates);
							words.addAll(next(tile,word+square.getCharacter(), past));
						}
					}
				}
			}
		}
		if(trie.checkWord(word) && !word.contains(word)){
			words.add(word);
		}
		return words;
	}

	/* (non-Javadoc)
	 * @see bogglegraph.BoggleGraph#next(bogglegraph.BoggleTile, java.lang.String, java.util.Hashtable)
	 */
//	@Override
//	ArrayList<String> next(BoggleTile square, String word, Hashtable<Character, int[]> past) {
//		ArrayList<String> words = new ArrayList<String>();
//		ArrayList<BoggleTile> table = getSurroundings(square.getX(),square.getY());
//		Hashtable<Character, int[]> n = null;
//		int[] coordinates, newCoordinates;
//		boolean alreadyUsed;
//		
//		if(word.length()<12){
//			alreadyUsed = false;
//			String x;
//			for(BoggleTile tile:table){
//				//System.out.println(word);
//				x = word+tile.getCharacter();
//				//System.out.println(x+" "+trie.checkStem(x));
//				if(trie.checkWord(x) && !words.contains(x)){
//					words.add(x);
//				}
//				if(trie.checkStem(x)){
//					if(past.containsKey(tile.getCharacter().charAt(0))){
//						coordinates = past.get(tile.getCharacter().charAt(0));
//						for(int i=0;i<coordinates.length;i+=2){
//							if(coordinates[i] == tile.getX() && coordinates[i+1] == tile.getY()){
//								alreadyUsed = true;
//							}
//						}
//						if(alreadyUsed){
//							//DO NOTHING
//							//System.out.println("no reusing "+tile.getX()+" "+tile.getY());
//						}
//						else if(!alreadyUsed){
//							newCoordinates = new int[coordinates.length+2];
//							//System.out.println("OLD COORDINATES:");
//							for(int i=0;i<coordinates.length;i++){
//								newCoordinates[i] = coordinates[i];
//								//System.out.print(coordinates[i]+" ");
//							}
//							newCoordinates[newCoordinates.length-2] = square.getX();
//							newCoordinates[newCoordinates.length-1] = square.getY();
//							//System.out.println(newCoordinates[0]+" "+newCoordinates[1]);
//							n = (Hashtable<Character, int[]>) past.clone();
//							n.put(tile.getCharacter().charAt(0), newCoordinates);
//							words.addAll(next(tile,word+square.getCharacter(), past));
//						}
//					}
//					else{
//						coordinates = new int[2];
//						coordinates[0] = tile.getX();
//						coordinates[1] = tile.getY();
//						//System.out.println("NEW coordinates: "+coordinates[0]+" "+coordinates[1]);
//						n = (Hashtable<Character, int[]>) past.clone();
//						n.put(tile.getCharacter().charAt(0), coordinates);
//						words.addAll(next(tile,word+square.getCharacter(), n));
//					}
//				}
//			}
//		}
//		return words;
//	}
	public static void main(String[] args){
		Boggle boggin = new Boggle();
		BoggleGraphElegant x = new BoggleGraphElegant(boggin);
		System.out.println(x+"\n"+x.getWords().size());
	}
}
