/**
 * TODO Class Description Class invariants: TODO Invariants list:
 *
 * @author Max Knutsen <mknutse1@umbc.edu>
 * @version Sep 23, 2013
 * @project CMSC 202 - Fall 2013 - Project #
 * @section #01
 */
package mknutsen.boggle.dictionary;

import java.util.Scanner;

/**
 * @author Max
 *
 */
public class HashtableTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        System.out.println("starting");
        HashtableDictionary cat = new HashtableDictionary(("mknutsen/boggle/dictionary.txt"));
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Input a word");
            input = scan.next();
            System.out.println(cat.checkWord(input));
        }
        scan.close();
    }

}
