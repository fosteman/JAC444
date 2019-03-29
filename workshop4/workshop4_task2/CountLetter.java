package com.senecacollege.workshop4_task2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CountLetter {
	private ArrayList<String> sentenceArray = new ArrayList<String>();
	private boolean flag = true;
	private int[] letterCount = new int[26];
	
	public CountLetter(String fileName) {
		String line = "";
		
		for(int i = 0; i < letterCount.length; i++) {
			letterCount[i] = 0;
		}
		
		try {
			File file = new File("./src/com/senecacollege/workshop4_task2/" + fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				sentenceArray.add(line);
			}
			
			flag = false;
		}catch(FileNotFoundException e) {
			System.err.println("File Not Found");
			flag = true;
		}catch(Exception e) {
			System.err.println(e);
			flag = true;
		}
	}
	
	public boolean getFlag() {
		return flag;
	}
	
	public void count() {
		//ASCII. A-Z: 65-90, a-z: 97-122
		for(String sentence: sentenceArray) {
			for(int i = 0; i < sentence.length(); i++) {
				int letter = (int)sentence.charAt(i);
				if(letter >= 65 && letter <= 90) {
					addCount(letter - 65);
				}else if(letter >= 97 && letter <= 122) {
					addCount(letter - 97);
				}
			}
		}
		
		countPrint();
	}
	
	public void addCount(int letterPlace) {
		letterCount[letterPlace]++;
	}
	
	public void countPrint() {
		for(int i = 0; i < letterCount.length; i++) {
			System.out.println("Number of " + (char)(i + 65) + "'s: " + letterCount[i]);
		}
	}
}
