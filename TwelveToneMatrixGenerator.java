
//==============================================================================
// Program name - SerialismGenerator
// Author - Avery Chiu
// Date - 2018/04/15
// Programming Language, version number - Java 9
// ==============================================================================
//Definition:The program creates 12 tone rows
//Input: The user chooses whether they want a 12 tone row or not
//Output: 12 tone rows
//Process: The program will check the user input and then produce a 12 tone row by shuffling 
//12 numbers in an array. The array will be outputed as musical notes for the user.
//==============================================================================
/**main method:
 * This procedural method is called automatically and is used to organize the calling of other methods defined in the class
 *
 * -----------------------------List of Local Variables------------------------
 * notes -an array that stores a 12 tone row (type int[])
 * matrix - an array that has holds the 12 tone matrix (type int[][])
 * choice1 - the user chooses how they want their 12 tone row to be made (type int)
 * choice2- the user chooses whether they want to make a matrix or not (type int)
 * sg - object used to access methods in the SerialismGenerator class(type SerialismGenerator)
 * 
 *
 * @param args;type String;
 * @throws IO Exception
 * @return void
 */

import java.io.*;

public class SerialismGenerator {// Beginning of SerialismGenerator class
	public static void main(String[] args) throws IOException {// Beginning of main method

		// Variables
		int[] notes = new int[12];
		int[][] matrix = new int[12][12];
		int choice1, choice2;
		SerialismGenerator sg = new SerialismGenerator();

		// Introduction
		System.out.println("---------------------MAIN MENU----------------------------");
		System.out.println("Weclome to the 12 Tone Matrix Generator created by Avery Chiu");
		System.out.println("This program generates 12 tone rows and matrices randomly for music");
		System.out.println("Note: In serialism, the note names do not matter as each note is equal");
		System.out.println("Thus, each note is given a value from 0-11");
		System.out.println("This is an example that is used by the computer");
		System.out.println("You will notice that each row will always start on 0");
		System.out.println("This is so the matrix can be created");
		System.out.println("You can assign each number its own note, but this is just");
		System.out.println("for reference");
		System.out.println("0=C");
		System.out.println("1=C#/Db");
		System.out.println("2=D");
		System.out.println("3=D#/Eb");
		System.out.println("4=E");
		System.out.println("5=F");
		System.out.println("6=F#/Gb");
		System.out.println("7=G=7");
		System.out.println("8=G#/Ab");
		System.out.println("9=A");
		System.out.println("10=A#/Bb");
		System.out.println("11=B");
		System.out.println("--------------------READING THE MATRIX-------------------------");
		System.out.println("Prime Rows: Left to Right");
		System.out.println("Inversion Rows: Top to Bottom");
		System.out.println("Retograde Rows: Right to left");
		System.out.println("Retrograde-Inversion Rows:Bottom to Top");

		// Method Calls
		choice1 = sg.inputOne();
		while (choice1 != 3) {// Checks if the user wants to exit the program or not
			if (choice1 == 1)
				notes = sg.shuffle(notes);
			else
				notes = sg.inputNotes(notes);

			sg.output(notes);
			choice2 = sg.inputTwo();
			if (choice2 == 1) {// Checks to make sure the user wants a matrix
				matrix = sg.matrixGenerator(notes);
				sg.outputMatrix(matrix);
			} // End of check to make sure the user wants a matrix
			choice1 = sg.inputOne();
		} // End of check to see if the user wants to exit the program
		System.out.println("Thank you for using the 12 tone row generator");

	}// End of main method
	/**
	 * inputOne Method: This functional methods checks what option the user wants to choose
	 * 
	 *-----------------------------List of Local Variables------------------------
	 * choice – used to accept which choice the user chooses(type int).
	 * br- an object used to read input from a file(type BufferedReader).
	 * 
	 * 
	 * @param none
	 * @throws IO Exception
	 * @return choice(type int)
	 */

	int inputOne() throws IOException {// Beginning of input method

		//Variables
		int choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// User prompts
		System.out.println("---------------------------------------------------------");
		System.out.println("1. Enter 1 if you would like to the computer to make a 12 tone row");
		System.out.println("2. Enter 2 if you would like to write your own row");
		System.out.println("3. Enter 3 if you would like exit the program");
		System.out.println("---------------------------------------------------------");
		while (true) {// Loop to check for proper input
			try {
				choice = Integer.parseInt(br.readLine());
				if (choice == 1 || choice == 2 || choice == 3)
					break;
				else
					System.out.println("You must choose option 1,2 or 3");
			} catch (NumberFormatException e) {// Catches improper input
				System.out.println("Please enter a proper option");

			} // End of catch
		} // End of loop to check for proper input
		return choice;
	}// End of input method
	/**
	 * shuffle Method: This functional methods generates and shuffles a twelve tone row
	 * 
	 *-----------------------------List of Local Variables------------------------
	 * noOfNotes - represents the number of notes in a twelve tone row (type int).
	 * temp - a variable to store a temporary value to help with swapping numbers (type int).
	 * 
	 * @param notes-an array that stores a 12 tone row (type int[])
	 * @throws none
	 * @return notes-an array that stores a 12 tone row (type int[])
	 */

	int[] shuffle(int[] notes) {// Beginning of shuffle method
		//Variables
		int noOfNotes = 12, temp = 0;

		for (int i = 0; i < noOfNotes; i++)// Initializes each number in the array to a note
			notes[i] = i;

		for (int i = 1; i < noOfNotes; i++) {// Beginning of loop to shuffle
			int s = i + (int) (Math.random() * (noOfNotes - i));
			temp = notes[s];
			notes[s] = notes[i];
			notes[i] = temp;
		} // End of loop to shuffle
		return notes;
	}// End of shuffle method

	/**
	 * inputNotes Method: This functional methods allows the user to enter their own twelve tone row
	 * 
	 *-----------------------------List of Local Variables------------------------
	 *br- an object used to read input from a file(type BufferedReader).
	 *twelveToneRow - the twelve tone row that is written by the user (type String).
	 *inputRow- the twelve tone row that is split up into an array (type String[]).
	 *check- a variable to check if the user has entered a value greater than 11(type boolean)
	 *
	 * 
	 * @param notes-an array that stores a 12 tone row (type int[])
	 * @throws IOException
	 * @return notes-an array that stores a 12 tone row (type int[])
	 */

	int[] inputNotes(int[] notes) throws IOException {// Beginning of inputNotes method
		// Variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String twelveToneRow;
		String[] inputRow = new String[12];
		boolean check = true;

		System.out.println("Please enter a proper 12 tone row in numbers with commas");
		System.out.println("between each note/number");
		System.out.println("Also please start with 0 to make sure the matrix is created properly");
		System.out.println("Eg 0,1,11,3...");
		System.out.println("If more than 12 tones are written the excess notes will be ommited");
		while (true) {// Beginning of loop
			try {// Beginning of try
				twelveToneRow = br.readLine();
				inputRow = twelveToneRow.split(",");
				check = true;
				for (int i = 0; i < 11; i++) {
					notes[i] = Integer.parseInt(inputRow[i]);
					if (notes[i] > 11)
						check = false;
				}

				if (notes[0] == 0 && check == true)
					break;
				else
					System.out.println("Please enter a proper twelve tone row");
				System.out.println("Make sure the first note is 0 so that the ");
				System.out.println("matrix can be made properly ");
			} catch (Exception e) {// Beginning of catch
				System.out.println("Please enter a proper twelve tone row");
			} // End of catch
		} // End of while loop
		return notes;
	}// End of inputNotes method

	/**
	 * inputNotes Method: This procedural method outputs a twelve tone row
	 * 
	 * @param notes-an array that stores a 12 tone row (type int[])
	 * @throws none
	 * @return none
	 */
	void output(int[] notes) {// Beginning of output method

		System.out.println("The row is");
		for (int i = 0; i < notes.length; i++)
			System.out.print(notes[i] + " ");
		System.out.println();
		System.out.println("or an example in standard note names");
		for (int i = 0; i < notes.length; i++) {// Beginning of loop to check each element
			switch (notes[i]) {// Beginning of switch case to convert each number to a musical note
			case 0:
				System.out.print("C ");
				break;
			case 1:
				System.out.print("C#/Db ");
				break;
			case 2:
				System.out.print("D ");
				break;
			case 3:
				System.out.print("D#/Eb ");
				break;
			case 4:
				System.out.print("E ");
				break;
			case 5:
				System.out.print("F ");
				break;
			case 6:
				System.out.print("F#/Gb ");
				break;
			case 7:
				System.out.print("G ");
				break;
			case 8:
				System.out.print("G#/Ab ");
				break;
			case 9:
				System.out.print("A ");
				break;
			case 10:
				System.out.print("A#/Bb ");
				break;
			case 11:
				System.out.print("B ");
				break;

			}// End of switch case to convert each number to a musical note

		} // End of loop to check each element
		System.out.println();
	}// End of output method

	/**
	 * inputTwo Method: This functional methods checks what option the user wants to choose
	 * 
	 *-----------------------------List of Local Variables------------------------
	 * choice – used to accept which choice the user chooses(type int).
	 * br- an object used to read input from a file(type BufferedReader).
	 * 
	 * 
	 * @param none
	 * @throws IO Exception
	 * @return choice(type int)
	 */
	int inputTwo() throws IOException {// Beginning of inputTwo Method
		// Variables
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		// User prompts
		System.out.println("---------------------------------------------------------");
		System.out.println("1. Enter 1 if you would like to make a 12 tone matrix");
		System.out.println("2. Enter 2 if you don't want a matrix");
		System.out.println("---------------------------------------------------------");

		while (true) {// Loop to check for proper input
			try {
				choice = Integer.parseInt(br.readLine());
				if (choice == 1 || choice == 2)
					break;
				else
					System.out.println("You must choose option 1 or 2");
			} catch (NumberFormatException e) {// Catches improper input
				System.out.println("Please enter a proper option");

			} // End of catch
		} // End of loop to check for proper input
		return choice;

	}// End of inputTwo method

	/**
	 * matrixGenerator Method: This functional methods creates a matrix
	 * 
	 *-----------------------------List of Local Variables------------------------
	 *matrix - the 12 by 12 matrix created from the twelve tone row(type int[][])
	 *
	 * 
	 * @param notes-an array that stores a 12 tone row (type int[])
	 * @throws IOException
	 * @return matrix
	 */
	int[][] matrixGenerator(int[] notes) {// Beginning of matrixGenerator method

		// Variables
		int[][] matrix = new int[12][12];

		for (int i = 0; i < 12; i++)
			matrix[0][i] = notes[i];// Fills the first row with the original row

		for (int i = 1; i < 12; i++) {
			matrix[i][0] = 12 - matrix[0][i];// Fills the first column with the inversion
			if (matrix[i][0] == 12)
				matrix[i][0] = 0;
		}
		for (int i = 1; i < 12; i++) {// Beginning of outer loop
			for (int j = 1; j < 12; j++) {// Beginning of inner loop
				matrix[i][j] = matrix[i][0] + matrix[0][j];// Fills the rest of the row
				if (matrix[i][j] > 11)// Makes sure the numbers aren't greater than 11
					matrix[i][j] -= 12;

			} // End of inner loop
		} // End of outer loop

		return matrix;

	}// End of matrixGenerator method

	/**
	 * outputMatrix Method: This procedural method outputs a twelve tone row
	 * 
	 * @param matrix - the 12 by 12 matrix created from the twelve tone row(type int[][])
	 * @throws none
	 * @return none
	 */
	void outputMatrix(int[][] matrix) {// Beginning of outputMatrix method

		System.out.println("------------------------------IN NUMBERS----------------------------");
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
		System.out.println("------------------------EXAMPLE IN STANDARD NOTE NAMES---------------------------");

		for (int i = 0; i < 12; i++) {// Beginning of loop to check each row
			for (int j = 0; j < 12; j++) {// Beginning of inner loop to check each column
				switch (matrix[i][j]) {// Beginning of switch case to convert each number to a musical note
				case 0:
					System.out.print("C\t");
					break;
				case 1:
					System.out.print("C#/Db\t");
					break;
				case 2:
					System.out.print("D\t");
					break;
				case 3:
					System.out.print("D#/Eb\t");
					break;
				case 4:
					System.out.print("E\t ");
					break;
				case 5:
					System.out.print("F \t");
					break;
				case 6:
					System.out.print("F#/Gb\t");
					break;
				case 7:
					System.out.print("G\t");
					break;
				case 8:
					System.out.print("G#/Ab\t");
					break;
				case 9:
					System.out.print("A\t");
					break;
				case 10:
					System.out.print("A#/Bb\t");
					break;
				case 11:
					System.out.print("B\t");
					break;

				}// End of switch case to convert each number to a musical note
			} // End of loop to check each column
			System.out.println();
		} // End of loop to check each row

	}// end of outputMatrix method

}// End of SerialismGenerator class
