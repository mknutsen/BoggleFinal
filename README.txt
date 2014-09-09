AUTHOR - MAX KNUTSEN <mknutse1@umbc.edu>
VERSION FINAL - May, 2014

This project is an implimentation of the classic Hasboro board game in an electronic form.
The board is randomized by taking the values from the boggle dice and selecting one value from each dice randomly and then placing it randomly on the board. Using the real boggle dice values ensures a decent letter distribution, so there are not boards that have no vowels.
The dictionary is contained in a Trie - a tree data structure in which each each node contains a letter and has a branch for each letter that could come after it in a word.

Graphics.java runs the GUI Boggle, programmed in swing, where the user can play boggle.
Graphics were created by myself or Remy Bustani, who doesn't have a website or a linkedIn.

I thought it would be cool to come up with an algorithm that finds all of the legal words on a boggle board that are in the dictionary. My two methods of solving this problem are found in the bogglegraph package.
The brute force method goes through the board and finds every possible string of twelve letters on the board, and the passes those strings to a parser that determines if theere are any words contained in that list. This method works but took the computer several minutes to compute, so I tried coming up with a different method.
The file labeled as elegant employs a similar tactic, but, using the trie that holds the dictionary, it stops it's current search if the current stem does not have any possible way of becoming a word. This method runs instantly on any competant machine.

As a note to anyone who actually reads this: I programmed this in my spare time during my first semester in college as a fun project. While the code does represent my ability to problem solve, research advanced concepts on my own, and go from idea to product; it does not reflect my ability to thoughtfully design code, nor does it reflect my ability to express my ideas through comments and commit messages. I have since learned of many areas that I need to improve on in the area of code readability and fluidity, and I am continuing to attempt to improve in these areas.
