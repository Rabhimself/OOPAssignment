package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RailFence rf = new RailFence();
		Scanner console = new Scanner(System.in);
		int choice = 1;
		String s = null;
		CypherBreaker breaker;
		String file = ("4grams.txt");
		do {
			System.out.print("Options \n\t1. Decrypt a string.\n\t2. Decrypt a File.\n\t3. Encrypt and decrypt a predefined String.\n\tChoice:");
			try {
				choice = console.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter only the numbers 1, 2, and 3.");
				choice = 0;
			}
		} while (choice < 1 || choice > 4);

		switch (choice) {
		case 1:// string
			System.out.print("Text: ");
			s = console.nextLine();
			break;
		case 2:
			boolean done = false;
			String fileName= null;
			do {
				try {
					System.out.print("File name: ");
					fileName = console.next();
					s = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
					done = true;
				} catch (FileNotFoundException e) {
					System.out.println("File not found!");
				}
			} while (!done);
			break;
		case 3:
			do {
				choice = 0;
				System.out.print("Enter a key between 2 an 15: ");
				try {
					choice = console.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry.");
				}
				s = rf.encrypt("THISISASTRINGTHESESHOULDBEWORDS", choice);
				System.out.println("Encrypted text: " +s);
			} while (choice == 0);
			break;
		}

		breaker = new CypherBreaker(s);
	}
}
