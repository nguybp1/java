/*Assignment4.java
 *September 22, 2015
 *This program simulates a lighter version of Minesweeper that can only move down and right
 */

import java.util.*;

public class MineSweeper {
	public static void main(String[] args) {
		// declaring variables
		Scanner in = new Scanner(System.in);
		int i = 0, mines = 0;
		char p;
		boolean boom = false, win = false;
		int temp = 0, temp2 = 0, counter = 0, countdown = 0;
		Random rnd = new Random();
		// welcome!
		System.out.println("Welcome!");
		System.out.println("Are you an expert or newbie?");
		// do while for i is < 3
		do {
			System.out.printf("Enter board size: ");
			i = in.nextInt();
		} while (i < 3);
		// if else statement for mines
		if (i > 3) {
			mines = i - 2;
		} else {
			mines = 1;
		}

		// declaring an array and setting it to _
		char[][] array = new char[i][i];
		for (int q = 0; q < i; q++) {
			for (int w = 0; w < i; w++) {
				array[q][w] = '_';
			}
		}
		// setting the first [0][0] to P and putting [i - 1][i - 1] to B temp.
		array[0][0] = 'P';
		array[i - 1][i - 1] = 'B';
		// placing mines randomly using random next int
		while (mines > 0) {
			temp = rnd.nextInt(i);
			temp2 = rnd.nextInt(i);
			// placing mines can not be equal to P or B
			if (array[temp][temp2] != 'P' && array[temp][temp2] != 'B') {
				array[temp][temp2] = 'B';
				mines--;
			}
		}
		// setting the array of [i-1][i-1] back to _
		array[i - 1][i - 1] = '_';
		// print the board
		printBoard(array);
		// do while for the game and movements
		do {
			// asking for the person to whether they want to move right or left
			p = errorBoard();

			for (int k = i; k > 0; k--) {
				for (int j = i; j > 0; j--) {
					// finding P and move right one
					if (array[k - 1][j - 1] == 'P' && p == 'r') {
						// tracking the movements of going right
						counter++;
						// if the counter for right if higehr than i-1, then it
						// is going off the board
						if (counter > i - 1) {
							System.out.printf("*** Going off the board\n");
							// subtracts the counter and asks the question
							// again.
							counter--;
						} else if (array[k - 1][j] == 'B') {// if the choice
															// made is == B then
															// the game finishes
															// with a Boom!
							boom = true;
						} else {// if everything else if fine then move right
								// and print the board
							array[k - 1][j] = 'P';
							array[k - 1][j - 1] = '_';
							printBoard(array);
						}
					}
					// finding P move down one
					if (array[k - 1][j - 1] == 'P' && p == 'd') {
						// tracking the movements of going down
						countdown++;
						// if the counter for down is higher than i-1, then the
						// board is going off
						if (countdown > i - 1) {
							System.out.printf("*** Going off the board\n");
							// subtracts the counter and asks the question again
							countdown--;
						} else if (array[k][j - 1] == 'B') {// if the choice
															// made is == B then
															// the game finishes
															// with a Boom!
							boom = true;
						} else {// if everything else if fine then move down and
								// print the board
							array[k][j - 1] = 'P';
							array[k - 1][j - 1] = '_';
							printBoard(array);
						}
					}
					// if the array arrives to the bottom right then you win!
					if (array[i - 1][i - 1] == 'P') {
						win = true;
					}
				}
			}
		} while (!boom && !win);
		// display winner
		if (win == true) {
			System.out.println("You Win!");
		}
		// display you lose with a Boom
		if (boom == true) {
			System.out.printf("Boom!");
		}
	}

	// testing functions out
	// printing the board
	public static void printBoard(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// asking for input for down or right
	public static char errorBoard() {
		char pos;
		Scanner in = new Scanner(System.in);
		do {
			System.out.printf("<d>own or <r>ight? ");
			pos = in.next().charAt(0);
		} while (pos != 'r' && pos != 'd');
		return pos;
	}
}
