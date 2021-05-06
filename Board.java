package battleship;

import java.util.Scanner;
import java.util.Random;

public class Board {
	
	

	Scanner keyboard = new Scanner(System.in);
	private char[][] board = new char[9][9];
	Random rand = new Random();

	// constructor
	public Board() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}

	}
	
	// constructor with parameter
	public Board(Board copyGrid) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.board[i][j] = copyGrid.board[i][j];
			}
		}
	}

	// take empty position called and assign it to a star
	public void setPositionToStar(int x, int y) {
		board[x][y] = '*';
	}

	// assign the value of the position from the master board to another board
	public void copyFromMasterBoard(Board b, int x, int y) {
		board[x][y] = b.getPosition(x, y);
	}

	

	// set the user ship position to a character
	public void setShip(int shipR, int shipC) {
		board[shipR][shipC] = 's';
	}

	// obtain a position
	public char getPosition(int x, int y) {
		return board[x][y];
	}

	// set the user bomb position to a character
	public void setBomb(int bombR, int bombC) {
		board[bombR][bombC] = 'g';
	}

	// randomize the computer's ships
	public void randomShip() {
		int count = 0;
		while (count < 6) {

			int randIntRow = (int) (Math.random() * 8) + 1;
			int randIntColumn = (int) (Math.random() * 8) + 1;

			if (randIntRow == 0 || randIntColumn == 0) {
				count--;

			} else if (board[randIntRow][randIntColumn] == 0) {
				board[randIntRow][randIntColumn] = 'S';
			}

			else {
				count--;
			}
			count++;

		}
	}

	// randomize the computer's grenades
	public void randomGrenade() {
		int count = 0;
		while (count < 4) {

			int randIntRow = (int) (Math.random() * 8 + 1);
			int randIntColumn = (int) (Math.random() * 8 + 1);

			if (board[randIntRow][randIntColumn] == 0) {
				board[randIntRow][randIntColumn] = 'G';
			}

			else {
				count--;
			}
			count++;

		}
	}

	// print the master board
	public void printBoard() {
		for (int i = 1; i < board.length; i++) {
			for (int y = 1; y < board[i].length; y++) {
				if (board[i][y] == 0) {
					System.out.print("- ");
				} else {
					System.out.print(board[i][y] + " ");
				}

			}
			System.out.println();
		}
	}

	// method to display the game board everytime a player inputs a position
	public void displayPrintBoard() {
		for (int i = 1; i < board.length; i++) {
			for (int y = 1; y < board[i].length; y++) {
				if (board[i][y] == 0) {
					System.out.print("- ");
				} else if (board[i][y] == 's' || board[i][y] == 'S' || board[i][y] == 'g' || board[i][y] == 'G')
					System.out.print("- ");
				else {
					System.out.print(board[i][y] + " ");
				}

			}
			System.out.println();
		}
	}

}
