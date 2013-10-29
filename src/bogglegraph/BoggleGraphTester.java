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

import dictionary.Boggle;

/**
 * @author Max
 *
 */
public class BoggleGraphTester {
	public static void main(String[] args){
		String[] x = {"R", "S", "C", "L", "S",
			  	"D", "E", "I", "A", "E",
				"G", "N", "T", "R", "P",
				"I", "A", "E", "S", "O",
				"L", "M", "I", "D", "C"};
		String[][] y = new String[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				y[i][j] = x[i*5+j];
			}
		}
		Boggle boggin = new Boggle(y);
		Boggle boggin2 = new Boggle(y);
		BoggleGraph[] boggleGraphs = {new BoggleGraphElegant(boggin), new BoggleGraphBrute(boggin2)};
		int words1, words2;
		//System.out.println(boggleGraph);
		words1= boggin.analyzeList(boggleGraphs[0].getWords());
		words2=boggin2.analyzeList(boggleGraphs[1].getWords());
		System.out.println("\n"+words1+"\n"+words2+"\n");
		System.out.println(boggin);
		printArrayListDifferences(boggleGraphs[0].getWords(),boggin2.getFoundWordArrayList());
	}
	public static void printArrayListDifferences(ArrayList<String> one,ArrayList<String> two){
		System.out.println("Stuff that is unique to arrayList one");
		for(String word:one){
			if(!two.contains(word)){
				System.out.println(word);
			}
		}
		System.out.println("Stuff that is unique to arrayList two");
		int i =0;
		for(String word:two){
			if(!one.contains(word)){
				System.out.println(i+") "+word);
				i++;
			}
		}
	}
}
