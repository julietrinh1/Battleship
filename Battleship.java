//---------------------------------------
// Assignment 4
// Written by: William Chong 40176360 and 
//             Julie Trinh 40175335
// For COMP 248 section R - Fall 2020
//---------------------------------------

//This program simulates a Battleship game against the computer

package battleship;

import java.util.Scanner;
import java.util.Random;

public class Battleship {

	public static void main(String[] args) {

		// Print out the greeting message
		System.out.println("\\---------------------------------------------\\\n"
				+ "/                 Battleship                  /\n"
				+ "\\---------------------------------------------\\\n");

		System.out.println("Hi, let's play Battleship!");

		// Create instance of random class
		Scanner keyboard = new Scanner(System.in);
		Board gameBoard = new Board(); // create a game board of row and column 9;

		Board boardToDisplay = new Board(gameBoard);//create a game board to display as it gets updated

		/**
		 * USER PLACES HIS SHIPS *
		 */
		for (int i = 0; i < 6; i++) {
			System.out.print("Enter the coordinates of your ship #" + (i + 1) + ": ");
			String coordinateShip = keyboard.next();// Read the user input for the coordinates
			char shipRowChar = coordinateShip.toUpperCase().charAt(0); // Store the first character of the coordinate
			int shipRow = 0;
			char shipColChar = coordinateShip.charAt(1);// Store the second character of the coordinate
			int shipCol = Character.getNumericValue(shipColChar);// change the second character to an integer

			if (shipRowChar == 'A') {// Compare the first character to a letter and store the row value accordingly
				shipRow = 1;

			} else if (shipRowChar == 'B') {
				shipRow = 2;

			} else if (shipRowChar == 'C') {
				shipRow = 3;

			} else if (shipRowChar == 'D') {
				shipRow = 4;

			} else if (shipRowChar == 'E') {
				shipRow = 5;

			} else if (shipRowChar == 'F') {
				shipRow = 6;

			} else if (shipRowChar == 'G') {
				shipRow = 7;

			} else if (shipRowChar == 'H') {
				shipRow = 8;

			} else {
				System.out.println("Sorry, coordinates outside the grid. try again.");
				i--;
				continue;
			}
			if (shipCol > 0 && shipCol <= 8) {// make sure that the column value is not out of bound
				if (gameBoard.getPosition(shipRow, shipCol) == 0) {// make sure that there is nothing at this
					// position
					gameBoard.setShip(shipRow, shipCol);
				} else {// reiterate if wrong input
					System.out.println("sorry, coordinates already used. try again.");
					i--;
					continue;
				}
			} else {// reiterate if wrong input
				System.out.println("Sorry, coordinates outside the grid. try again.");
				i--;
				continue;
			}

		}

		/**
		 * USER PLACE HIS GRENADES *
		 */
		for (int b = 0; b < 4; b++) {
			System.out.print("Enter the coordinates of your grenade #" + (b + 1) + ": ");
			String coordinateGrenade = keyboard.next();// Read the user input for the coordinates
			char grenadeRowChar = coordinateGrenade.toUpperCase().charAt(0); // Store the first character of the
			// coordinate
			int grenadeRow = 0;
			char grenadeColChar = coordinateGrenade.charAt(1);// Store the second character of the coordinate
			int grenadeCol = Character.getNumericValue(grenadeColChar);// change the second character to an integer

			if (grenadeRowChar == 'A') {// Compare the first character to a letter and store the row value accordingly
				grenadeRow = 1;

			} else if (grenadeRowChar == 'B') {
				grenadeRow = 2;

			} else if (grenadeRowChar == 'C') {
				grenadeRow = 3;

			} else if (grenadeRowChar == 'D') {
				grenadeRow = 4;

			} else if (grenadeRowChar == 'E') {
				grenadeRow = 5;

			} else if (grenadeRowChar == 'F') {
				grenadeRow = 6;

			} else if (grenadeRowChar == 'G') {
				grenadeRow = 7;

			} else if (grenadeRowChar == 'H') {
				grenadeRow = 8;

			} else {// output if the character is not correct
				System.out.println("Sorry, coordinates outside the grid. try again.");
				b--;
				continue;
			}

			if (grenadeCol > 0 && grenadeCol <= 8) {// make sure that the column value is not out of bound
				if (gameBoard.getPosition(grenadeRow, grenadeCol) == 0) {// make sure that there is nothing at this
					// position
					gameBoard.setBomb(grenadeRow, grenadeCol);
				} else {// reiterate if wrong input
					System.out.println("sorry, coordinates already used. try again.");
					b--;
					continue;
				}
			} else {// reiterate if wrong input
				System.out.println("Sorry, coordinates outside the grid. try again.");
				b--;
				continue;
			}
		}

		gameBoard.randomShip();// randomize the ships of computer
		gameBoard.randomGrenade();// randomize the grenades of computer

		// Everything is set
		System.out.println("OK, the computer placed its ships and grenades at random. Let's play");

		// Display an empty board
		System.out.println();
		gameBoard.displayPrintBoard();

		// Initialize values
		int player1 = 0;// points of the players for when they sink the opponent ships
		int player2 = 0;
		boolean gameFinished = false;
		boolean playerPlayAgain = false;
		boolean computerPlayAgain = false;

		while (!gameFinished) {

			for (int player = 0; player < 2; player++) {
				

//	                if(player == 0){
//	                    System.out.println("This is Player's turn");
//	                }
//	                else{
//	                    System.out.println("This is Computer's turn");
//	                }
				int x = 0;
				int y = 0;

				// Player's turn
				if (player == 0) {

					System.out.print("Position of your rocket: ");
					String input = keyboard.next();
					char x_char = input.toUpperCase().charAt(0); // Store the first character of the coordinate

					if (x_char == 'A') {// Compare the first character to a letter and store the row value accordingly
						x = 1;

					} else if (x_char == 'B') {
						x = 2;

					} else if (x_char == 'C') {
						x = 3;

					} else if (x_char == 'D') {
						x = 4;

					} else if (x_char == 'E') {
						x = 5;

					} else if (x_char == 'F') {
						x = 6;

					} else if (x_char == 'G') {
						x = 7;

					} else if (x_char == 'H') {
						x = 8;
					} else {
						System.out.println("Sorry false input : " + x_char);
						continue;
					}
					char y_char = input.charAt(1);// Store the second character of the coordinate
					y = Character.getNumericValue(y_char);// change the second character to an integer

					// Number validation (y)
					if (y < 1 || y > 8) {
						System.out.println("Sorry, the coordinates of your rocket are outside of the grid.");
						continue;
					}
				} else {
					// computer's turn

					x = (int) (Math.random() * 8 + 1);
					y = (int) (Math.random() * 8 + 1);

					System.out.println("Position of my rocket: " + getLetter(x) + y);

				}

				// ---- we finished getting position to launch rocket

				// the player plays an already called coordinate
				if (boardToDisplay.getPosition(x, y) != 0) {
					System.out.println("position already called.");
					boardToDisplay.printBoard();
				} // the player hits nothing
				else if (gameBoard.getPosition(x, y) == 0) {
					System.out.println("nothing.");
					boardToDisplay.setPositionToStar(x, y);
					boardToDisplay.printBoard();
				} // the player hits a ship
				else if (gameBoard.getPosition(x, y) == 'S' || gameBoard.getPosition(x, y) == 's') {
					System.out.println("ship hit.");

					if (gameBoard.getPosition(x, y) == 'S') {
						player1++; // Player gets one point

						if (player1 == 6) { // if player get 6 points, he wins the game
							System.out.println("You win!");
							System.out.println("Thank you for playing and see you soon!");
							
							gameBoard.printBoard(); //print master board
							System.exit(0); // end game
						}
						boardToDisplay.copyFromMasterBoard(gameBoard, x, y);//update display board
						boardToDisplay.printBoard();//print display board
					} else if (gameBoard.getPosition(x, y) == 's') {
						player2++; // computer gets one point
						if (player2 == 6) {// if computer gets 6 points, player loses the game
							System.out.println("You lose!");
							System.out.println("Thank you for playing and see you soon!");
							
							gameBoard.printBoard();//print master board
							System.exit(0);// exit the game
						}
						boardToDisplay.copyFromMasterBoard(gameBoard, x, y); //update display board
						boardToDisplay.printBoard();// print the display board
					}

				} // the player hits a grenade
				else if (gameBoard.getPosition(x, y) == 'g' || gameBoard.getPosition(x, y) == 'G') {
					System.out.println("boom! grenade.");

					if (player == 0) {
						computerPlayAgain = true;// make the boolean true to allow the computer to play twice in a row
					} else {
						playerPlayAgain = true;// make the boolean true to allow the player to play twice in a row
					}
					boardToDisplay.copyFromMasterBoard(gameBoard, x, y);//update display board
					boardToDisplay.printBoard();//print display board
					continue;//restart from the beginning of for loop
				}

				//if playerPlayAgain is true
				//stops the extra turn
				if (playerPlayAgain) {
					playerPlayAgain = false;//change it to false
					player = -1; 
				}
				//if computerPlayAgain is true
				//stops the extra turn
				if (computerPlayAgain) {
					player = 0;
					computerPlayAgain = false;//change it to false
				}

			}
			
		}

	}

	// to obtain an integer from a character input
//	public static int getInteger(int n) {
//		int number = 0;
//		if (n == 'A') {// Compare the first character to a letter and store the row value accordingly
//			number = 1;
//
//		} else if (n == 'B') {
//			number = 2;
//
//		} else if (n == 'C') {
//			number = 3;
//
//		} else if (n == 'D') {
//			number = 4;
//
//		} else if (n == 'E') {
//			number = 5;
//
//		} else if (n == 'F') {
//			number = 6;
//
//		} else if (n == 'G') {
//			number = 7;
//
//		} else if (n == 'H') {
//			number = 8;
//		} else {
//			number = 0;
//		}
//		return number;
//
//	}
	
	
	//to obtain a character from an integer
	public static char getLetter(int r) {
		char letter = 'A';
		if (r == 1) {// Compare the first character to a letter and store the row value accordingly
			letter = 'A';

		} else if (r == 2) {
			letter = 'B';

		} else if (r == 3) {
			letter = 'C';

		} else if (r == 4) {
			letter = 'D';

		} else if (r == 5) {
			letter = 'E';

		} else if (r == 6) {
			letter = 'F';

		} else if (r == 7) {
			letter = 'G';

		} else if (r == 8) {
			letter = 'H';
		} else {
			letter = 0;
		}
		return letter;
	}

}
