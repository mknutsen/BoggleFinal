/**
 * TODO Class Description
 * TODO Invariants List
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 21, 2013
 */
package mknutsen.boggle.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DictionaryArrayList extends BoggleDictionary{
	private ArrayList<String> dictionary;
	public DictionaryArrayList(String dictionary){
		super(dictionary);
		this.dictionary = new ArrayList<String>();
		setUpDictionary();
	}
	void setUpDictionary(){
		//int i=0;
		String x;
		x = scan.nextLine();
		dictionary.add(x);
		while(!dictionary.get(dictionary.size()-1).equals("zzz")){
			//		while(true){
			//System.out.println(i);
			//i++;
			x = scan.nextLine();
			if(x.length()>=3){
				x=x.toLowerCase();
				dictionary.add(x);
			}
		}
	}
	/**
	 * @return the mknutsen.boggle.dictionary
	 */
	public ArrayList<String> getDictionary() {
		return dictionary;
	}
	/**
	 * @param dictionary the mknutsen.boggle.dictionary to set
	 */
	public void setDictionary(ArrayList<String> dictionary) {
		this.dictionary = dictionary;
	}
	public void  removeTwoLetterWords(){
		int i =0;
		while(i<dictionary.size()){
			System.out.println(dictionary.get(i).length());
			if(dictionary.get(i).length()<=2){
				dictionary.remove(i);
			}
			else{
				i++;
			}
		}
	}
	public void printDictionaryToFile(File x){
		PrintWriter write = null;
		try {
			write = new PrintWriter(x);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dictionary.size());
		for (int i = 0; i < dictionary.size(); i++){
			System.out.println(dictionary.get(i));
			write.println(dictionary.get(i));
		}
		write.close();
	}
	public boolean checkWord(String word){
		for(String x:dictionary){
			if(x.equals(word))
				return true;
		}
		return false;
	}
	public void checkLength(){
		int longestWord = 0;
		for(String x:dictionary){
			System.out.println(x.length());
			if(x.length() > longestWord)
				longestWord = x.length();
		}
		System.out.println("longest word: "+longestWord);
	}
}
