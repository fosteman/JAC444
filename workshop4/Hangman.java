package com.senecacollege.workshop4_task1;

import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Hangman {
	private static final String FILENAME = "./src/com/senecacollege/workshop4_task1/hangman.txt";
	String[] words;

	public Hangman(){
		String line = "";
		try {
			File file = new File(FILENAME);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				words = line.split(" ");
			}
		}catch(FileNotFoundException e) {
			System.err.println(e);
		}catch(Exception e) {
			System.err.println(e);
		}

	}
	
	public void play() {
		
		Scanner input = new Scanner(System.in);
		int missedCount;
		char YN;
		
		do {
			char inputChar;
			missedCount = 0;
			String word = words[(int)(Math.random() * words.length)];		
			String userAnswer = "";
			String YNInput = "", userInput = "";
			int i, userAnswerCount = 0;
			
			for(i = 0; i < word.length(); i++) {
				userAnswer += "*";
			}

			do {
				int inTheWordCount = 0;
				do {
					try {
						System.out.print("(Guess) Enter a letter in word " + userAnswer + " > ");
						userInput = input.next();
						
						if(userInput.length() > 1) {
							System.err.println("Only input letter, not string");
						}
					}catch(NoSuchElementException e) {
						System.err.println(e);
					}
				}while(userInput.length() == 0 || userInput.length() > 1);
				
				inputChar = userInput.charAt(0);
				
				for(i = 0; i < word.length(); i++) {
					if(userAnswer.charAt(i) == inputChar) {
						System.out.println("\t" + inputChar + " is already in the word");
						inTheWordCount++;
						break;
					}else {
						if(word.charAt(i) == inputChar) {
							String newUserAnswer = userAnswer.substring(0, i) + inputChar + userAnswer.substring(i+1);
							userAnswer = newUserAnswer;
							userAnswerCount++;
							inTheWordCount++;
						}
					}	
				}
				
				if(inTheWordCount == 0) {
					System.out.println("\t" + inputChar + " is not in the word");
					missedCount++;
				}
			}while(userAnswerCount != word.length());
			
			System.out.println("The word is program. You missed " + missedCount + " time");
			
			do {
				System.out.print("Do you want to guess another word? Enter y or n> ");
				YNInput = input.next();
				YN = YNInput.charAt(0);
				if(YN != 'y' && YN != 'Y' && YN != 'n' && YN != 'N') {
					System.out.println("Please enter Y(y) or N(n)");
				}
			}while((YN != 'Y' && YN != 'y' && YN != 'N' && YN != 'n') || YNInput.length() > 1);
			
		} while(YN == 'Y' || YN == 'y');
	
	}

}
