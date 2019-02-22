package com.senecacollege.tester;
import com.senecacollege.workshop4_task1.*;
import com.senecacollege.workshop4_task2.*;
import com.senecacollege.workshop4_task3.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class TesterClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//task1
		Hangman hangman = new Hangman();
		hangman.play();
		
		//task2
		boolean whileFlag = true;	
		String textName = "";
		do {
			System.out.print("Enter a filename: ");
			
			try {
				textName = input.next();
				CountLetter countLetter = new CountLetter(textName);	
				whileFlag = countLetter.getFlag();
				if(whileFlag == false)
					countLetter.count();
			}catch(NoSuchElementException e) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
				whileFlag = true;
			}catch(Exception e) {
				System.err.println(e);
				whileFlag = true;
			}
		}while(whileFlag);
		
		//task3
		whileFlag = true;
		int phoneNum = 0;
		do {
			System.out.print("Enter phone number: ");
			
			try {
				phoneNum = input.nextInt();
				PhoneRemember phoneWord = new PhoneRemember(phoneNum);
				whileFlag = phoneWord.getFlag();
			}catch(NoSuchElementException e) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
				whileFlag = true;
			}catch(Exception e) {
				System.err.println(e);
				whileFlag = true;
			}
			
		}while(whileFlag);
		
	}
}
