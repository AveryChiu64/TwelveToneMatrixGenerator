


//==============================================================================
// Program name - Game of Divisors
// Author - Avery Chiu
// Date - 2018/03/03
// Programming Language, version number - Eclipse Java EE IDE for Web Developers.
//Version: Neon.1a Release (4.6.1)
//Build id: 20161007-1200
// ==============================================================================
//Function: The program runs the game of divisors (the description is on line 41)
//Input: The user inputs an action they want to do in the game 
//Output: The output will be the new value of N(n) after a a player has chosen what
//operation they would like to use on the number
//The computer will output the winner 
//(whoever forces their opponent to not be able to make any more moves) 
//Process: The program will accept the user or users operation they would like to perform
//on the number N
//They either divide by a factor or subtract 1 
//Until N is equal to 1 
//Then the program will ask the user if they want to play again
//==============================================================================
//								VARIABLES
// - let n represent the number of the integer written on the screen for the players(type int)
// - let gameType represent user input to choose which game they want to play(type String)
// - let playerInput represent player 1 and player 2's input(type int)
// - let player1Turns represent the number of times player 1 plays(type int)
// - let player2Turns represent the number of times player 2 plays(type int)
// - let computerDivison represent the number that the computer divides by
// - let playerNumber represent the number of the player who is playing their turn(type int)
// - let br represent an object used for user input (type BufferedReader)
// - let rand represent an object used to generate random numbers(type Random)
//==============================================================================

import java.io.*;//import the java.io library for 
import java.util.Random;//import's the random library to help generate random numbers

public class GameOfDivisors {// beginning of class GameOfDivisors
	public static void main(String[] args) throws IOException {// beginning of
																// main method

		// System objects
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();

		// Game variables
		int n, playerInput, player1Turns = 0, player2Turns = 0, computerDivision = 0, playerNumber;
		String gameType;

		// description of the game and introduction
		System.out.println("Welcome to the Game of Divisors");
		System.out.println("This is a simple game");
		System.out.println("The game works like this... ");
		System.out.println();
		System.out.println("=======================================================================================");
		System.out.println("\t\t\t\t\tRULES\t\t\t\t\t");
		System.out.println();
		System.out.print(" - There will be a positive integer written on the screen");
		System.out.println(" called 'N' at the start of the game");
		System.out.println(" - Each player gets one move per turn and you alternate ");
		System.out.print(" - On each move, the player can subtract 1 from");
		System.out.println("'N' or divide it by any factor of 'N' except 1 and itself(N)");
		System.out.println(" - You cannot decrease the 'N' if it is equal to 1");
		System.out.println(" - When a player is unable to make a move (N=1), then they lose and the opposistion wins");
		System.out.println();
		System.out.println("========================================================================================");
		System.out.println();
		System.out.println("Would you like to play with another human or robot?");
		System.out.println("\t1. Enter 1 to play with another human");
		System.out.println("\t2. Enter 2 to play with a Avery The Robot");
		System.out.println("\t3. Enter 3 to return to the main menu");
		System.out.println();
		System.out.println("========================================================================================");
		gameType = br.readLine();// reads the type of game the user wants to
									// play
		while (true)// the loop allows the user to keep on playing
			// until they choose to exit the game

			// ==============================================================================
			// This is gameType 1 (human vs human)
			// ==============================================================================
			if (gameType.equals("1")) {
				System.out.println("You have chosen to play with another player");
				n = rand.nextInt(91) + 10;// generates a random number for 'n'
											// (between 100-10)
				player1Turns = 0;// resets the number of moves that each player
									// made
				player2Turns = 0;// so it isn't carried over from a previous
									// match
				for (playerNumber = 1; playerNumber <= 2; playerNumber++) {

					// the for loop allows the two players to
					// keep alternating
					// if playerNumber is 1 it is player 1's turn, if it is 2 it
					// is player 2's turn
					// this allows us to count the number of times a certain
					// player goes
					if (n == 1)
						break;// if n is equal to 1 the game will end
					if (playerNumber == 1)
						player1Turns++;// counts the number of times player 1
										// goes
					else if (playerNumber == 2)
						player2Turns++;// counts the number of times player 2
										// goes

					// these are options for the players
					System.out.println("\tIt is player " + playerNumber + "'s turn");
					System.out.println("\n\t'N' is " + n);
					System.out.println("\t1. To subtract by 1, type 1");
					System.out.println("\t2. To divide by a number, type a number to divide by(enter a divisor)");
					
					while (true) {// beginning of while loop to catch exceptions
						try {// lets the user enter certain input
							playerInput = Integer.parseInt(br.readLine());// accepts
																			// numerical
																			// values
							if (playerInput != n && n % playerInput == 0 && playerInput > 0)
								// checks to make sure that the player input is
								// not equal to one
								// and that they divide by a proper factor of
								// 'n'so there is no deciamls
								break;// breaks out of the while loop if it is a
										// numerical value
							else {// prompts users to enter proper numbers and
									// to follow the rules
								System.out.println("Please enter a proper factor of " + n + " so that");
								System.out.println("the quotient is a  whole number greater than 1");
							} // end of else statement to make sure users enter
								// proper integers and follows the
								// rules
						} catch (NumberFormatException e) {
							// catches this exception if the user
							// enters non-numerical values

							System.out.println("Please enter a number");
							// prompts the user to enter a real number
						} // end of catch that catches if the user enters
							// non-numerical values
						catch (ArithmeticException e) {// catches this exception
														// if the user tries to
														// divide by zero
							// prompts the user to enter another number
							System.out.println("You cannot divide by zero,please enter another number");
						} // end of catch that catches ArithmeticExceptions
					} // end of while loop to catch exceptions
					if (playerInput == 1)// checks if the player has entered 1
						n--;// subtracts 1 from 'n'
					else
						n = n / playerInput;// divides 'n' by the player input
					if (playerNumber == 2)// checks if player 2 has just done
											// his turn
						playerNumber = 0;// if so it changes it back to player
											// 1's turn
					System.out.println("=======================================================================");

				} // end of game for loop (the game has ended)
				if (player1Turns == player2Turns) {// checks if player1 has had
													// the same
					// amount of moves as player 2
					// if so it must mean that player 1 could not play, that is
					// why he lost
					System.out.println("'N' is now equal to 1, no more moves can be made by player 1");
					System.out.println("Player 2 has won the game");
				} // end of if statement that tells the reader player 2 has won
				else {
					System.out.println("'N' is now equal to 1, no more moves can be made by player 2");
					System.out.println("Player 1 has won the game");
					// if player 1 has more moves than player 2
					// that means that player 2 was unable to move
					// thus player 1 wins
				} // end of else statement that tells reader that player 1 has
					// won

				// these statements ask the reader if they want to play
				// again
				System.out.println();
				System.out.println("Would you like to play again?");
				System.out.println("\t1. Enter 1 for a rematch");
				System.out.println("\t2. Enter 2 to play with a Avery The Robot");
				System.out.println("\t3. Enter 3 to return to the main menu");
				System.out.println();
				System.out.println("=======================================================================");

				gameType = br.readLine();// reads the type of game the user
											// wants to play
			} // end of gameType 1

			// ==============================================================================
			// This is gameType 2 (human vs robot)
			// ==============================================================================

			else if (gameType.equals("2")) {
				System.out.println("You have chosen to play with a Avery The Robot");
				n = rand.nextInt(91) + 10;// generates a random number for 'n'
											// (between 100-10)
				player1Turns = 0;// resets the number of moves that each player
									// made
				player2Turns = 0;// so it isn't carried over from a previous
									// match
				while (true) {// runs game 1 against a robot and keeps running
								// until the user breaks out
					if (n == 1)// checks if 'n' is equal to 1
						break;// breaks out the game if 'n' is equal to 1
					player1Turns++;// counts the number of times player 1 goes
					System.out.println("\tIt is player 1's turn");
					System.out.println("\n\t'N' is " + n);
					System.out.println("\t1. To subtract by 1, type 1");
					System.out.println("\t2. To divide by a number, type a number to divide by(enter a divisor)");
					while (true) {// beginning of while loop to catch exceptions
						try {// lets the user enter certain input
							playerInput = Integer.parseInt(br.readLine());// accepts
																			// numerical
																			// values
							if (playerInput != n && n % playerInput == 0 && playerInput > 0)
								// checks to make sure that the player input is
								// not equal to one
								// and that they divide by a proper factor of
								// 'n'so there is no decimals
								break;// breaks out of the while loop if it is a
										// numerical value
							else {// prompts users to enter proper numbers and
									// to follow the rules
								System.out.println("Please enter a proper factor of " + n + " so that");
								System.out.println("the quotient is a  whole number greater than 1");
							} // end of else statement to make sure users enter
								// proper integers and follow
								// rules
						} catch (NumberFormatException e) {
							// catches this exception if the user
							// enters non-numerical values
							System.out.println("Please enter a number");
							// prompts the user to enter a real number
						} // end of catch that catches if the user enters
							// non-numerical values
						catch (ArithmeticException e) {// catches this exception
														// if the user tries to
														// divide by zero
							System.out.println("You cannot divide by zero,please enter another number");
							// prompts the user to enter another number
						} // end of catch that catches ArithmeticExceptions
					} // end of while loop to catch exceptions
					if (playerInput == 1)// checks if the player enters 1
						n--;// subtracts 1 from 'n'
					else
						n = n / playerInput;// divides 'n' by the player input
					System.out.println("=======================================================================");
					if (n == 1)// checks if 'n' is equal to 1
						break;// breaks out the game if 'n' is equal to 1
					player2Turns++;// counts the number of times player 2 goes
					System.out.println("\tIt is Avery the Robot's turn");
					System.out.println("\n\t'N' is " + n);
					computerDivision = 5;// sets the initial value to divide 'n'
											// by as 5
					if (n > 8) {// checks if n is greater than 8
						while (n % computerDivision != 0 && computerDivision > 2) {
							// checks to see if computerDivison is a factor of
							// 'n' which is greater than 1
							computerDivision--;
							// if computerDivison is not a factor it will
							// subtract 1 and check
							// if the numbers between 2-5 are factors
						} // end of while loop to find factors of 'n'

						if (n % computerDivision == 0) {// checks if
														// computerDivison is a
														// factor of n
							System.out.println("Avery the Robot has divided by " + computerDivision);
							n = n / computerDivision;
						} // end of if statement that divides n by one of its
							// factors (computerDivision)
						else {// if no factor between 2-5 can be found the
								// computer will automatically
								// subtract 1
							System.out.println("Avery the Robot has subtracted 1");
							n--;// subtracts 1 from n
						} // end of else statement that subtracts 1
					} else if (n <= 8) { // checks if n is less than or equal to
											// 8
						n--;
						System.out.println("Avery the Robot has subtracted 1");
						// the bot will have a better chance of winning by
						// subtracting one when the
						// values are lower
						// this forces his opponent to deal with prime numbers
						// such
						// as 7,5,3 and
						// it forces his opponent to subtract as well
					} // end of check to see if n is less than or equal to 8
					if (n >= 10)
						System.out.println("\tMWahaha you will never defeat me");
					// The bot will aggravate the user with his mean comments
					// while
					// n is greater or equal to 10

					System.out.println("=======================================================================");
				} // end of game loop (the game has ended)
				if (player1Turns == player2Turns) {// checks if player1 has had
													// the same
					// amount of moves as player 2
					// if so it must mean that player 1 could not play, that is
					// why he lost
					System.out.println("'N' is now equal to 1, no more moves can be made by player 1");
					System.out.println("Avery the Robot has won the game");
					System.out.println("'Mwahaha you pitiful human, you will never beat me'");
				} // end of if statement that tells the reader player 2 has won
				else {
					System.out.println("'N' is now equal to 1, no more moves can be made by Avery the Robot");
					System.out.println("Player 1 has won the game");
					System.out.println("'Aww man you beat me'");
					// if player 1 has more moves than player 2
					// that means that player 2 was unable to move
					// thus player 1 wins
				} // end of else statement that tells reader that player 1 has
					// won

				// ask the user if they want to play again
				System.out.println();
				System.out.println("Would you like to play again?");
				System.out.println("\t1. Enter 1 to play with a human");
				System.out.println("\t2. Enter 2 to have a rematch with the Avery The Robot");
				System.out.println("\t3. Enter 3 to return to the main menu");
				System.out.println();
				System.out.println("=======================================================================");

				gameType = br.readLine();// reads the type of game the user
											// wants to play

			} // end of gameType 2
			else if (gameType.equals("3")) {
				System.out.println("You have left the game.Thanks for playing!");
				break;// breaks out of the loop so the user
				// can return to the main menu
			} // end of gameType 3

			else {
				System.out.println("Please choose an option");
				// prompts the user to choose another option
				gameType = br.readLine();// reads the type of game the user
											// wants to play

				n = rand.nextInt(91) + 10;// generates a random number for 'n'
											// (between 100-10)

			} // end of default gameType (this occurs if the user does not
				// choose a correct option)

		MainMenu.main(args);// calls upon the MainMenu class
		// to return the user to the main menu
	}// end of main method

}// end of class GameOfDivisors













































































































