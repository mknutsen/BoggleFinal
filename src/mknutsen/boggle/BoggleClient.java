package mknutsen.boggle;

import mknutsen.boggle.dictionary.Boggle;
/**
 * TODO Class Description
 * Class invariants:
 * TODO Invariants list:
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 23, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */

/**
 * @author Max
 *
 */
public class BoggleClient {
	public static void main(String[] args) {
		Boggle boggin = new Boggle();
		System.out.println(boggin);
		System.out.println(boggin.getTotalScore());
	}

}
