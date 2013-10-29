AUTHOR - MAX KNUTSEN <mknutse1@umbc.edu>
VERSION 1 - 10/29/2013

Graphics.java runs the GUI Boggle where the user can play boggle.
Running ElegantBoggleGraph.java or BruteBoggleGrapj.java anaylzes the board and tries to find as many words possible.
BruteBoggleGraph finds every possible combination of twelve characters (per boggle rules)
then searches through each string to find all of the words. This process takes a few minutes.

ElegantBoggleGraph uses a similar algorithm4;, but using the TrieDictionary, it will not continue developing the path
if it cannot result in a word. This algorithm takes a few seconds, but returns 50 or so fewer words than the Brute method.
