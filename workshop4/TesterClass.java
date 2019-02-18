package com.senecacollege.tester;
import com.senecacollege.workshop4_task1.*;
import com.senecacollege.workshop4_task2.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class TesterClass {
	public static void main(String[] args) {
		
		//task1
//		Hangman hangman = new Hangman();
//		hangman.play();
		
		//task2
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		String textName = "";
		do {
			System.out.print("Enter a filename:");
			
			try {
				textName = input.next();
				CountLetter countLetter = new CountLetter(textName, flag);	
				flag = countLetter.getFlag();
			}catch(NoSuchElementException e) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
				flag = true;
			}
		}while(flag);
		
		
		
	}
}
