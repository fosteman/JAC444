package com.senecacollege.workshop5.task3;
import java.util.Scanner;

public class ConnectFour {
	Scanner input = new Scanner(System.in);
	private boolean winnerFlag;
	private String winner;
	private final int ROWNUM = 7;
	private final int COLNUM = 7;
	private int count;
	private String row[][] = new String[ROWNUM][COLNUM];
	
	public ConnectFour() {
		winnerFlag = false;
		count = 0;
		initializeRow(row);
	};
	
	public void displayRow(String row[][]) {
		for(int i = 0; i < ROWNUM; i++) {
			System.out.print("|");
			for(int j = 0; j < COLNUM; j++) {
				if(row[i][j] == "") {
					System.out.print(" ");
				}else {
					System.out.print(row[i][j]);
				}
				System.out.print("|");
			}
			System.out.println();	
		}
		
	}
	
	public void play() {
		while(winnerFlag == false) {
			String colour;
			display();
			System.out.print("Drop a ");
			if(count % 2 == 0) {
				System.out.print("red");
				colour = "R";
			}else {
				System.out.print("yellow");
				colour = "Y";
			}
			System.out.print(" disk at a column (0-6): "); 
			int columnNum = input.nextInt();
			write(columnNum, colour);
			count++;
			winnerCheck();
		}
		
		display();
		System.out.println("The " + winner + " player won");
	}
	
	public void winnerCheck() {
		verticleCheck(row);
		horizentalCheck(row);
		crossRightCheck(row);
		crossLeftCheck(row);
	}
	
	public void verticleCheck(String row[][]) {
		for(int i = 0; i < ROWNUM; i++) {
			int yCount = 0;
			int rCount = 0;
			for(int j = 0; j < COLNUM; j++) {
				if(row[i][j] == "Y") {
					if(rCount != 0) {
						rCount = 0;
					}
					yCount++;
				}else if(row[i][j] == "R") {
					if(yCount != 0) {
						yCount = 0;
					}
					rCount++;
				}
				
				if(yCount == 4) {
					winnerFlag = true;
					winner = "Yellow";
				}else if(rCount == 4) {
					winnerFlag = true;
					winner = "Red";
				}
			}
		}
	}
	
	public void horizentalCheck(String row[][]) {
		for(int i = 0; i < ROWNUM; i++) {
			int yCount = 0;
			int rCount = 0;
			for(int j = 0; j < COLNUM; j++) {
				if(row[j][i] == "Y") {
					if(rCount != 0) {
						rCount = 0;
					}
					yCount++;
				}else if(row[j][i] == "R") {
					if(yCount != 0) {
						yCount = 0;
					}
					rCount++;
				}
				
				if(yCount == 4) {
					winnerFlag = true;
					winner = "Yellow";
				}else if(rCount == 4) {
					winnerFlag = true;
					winner = "Red";
				}
			}
		}
	}
	
	public void crossRightCheck(String row[][]) {
		for(int i = 3; i < 10; i++) {
			int j;
			int k;
			int yCount = 0;
			int rCount = 0;
			
			if(i < 7) {
				k = 0;
				for(j = i; j > -1; j--) {
					if(row[j][k] == "Y") {
						if(rCount != 0) {
							rCount = 0;
						}
						yCount++;
					}else if(row[j][k] == "R") {
						if(yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}
					
					if(yCount == 4) {
						winnerFlag = true;
						winner = "Yellow";
					}else if(rCount == 4) {
						winnerFlag = true;
						winner = "Red";
					}
					k++;
				}
			}else {
				j = 6;
				for(k = i - 6; k < 7; k++) {
					if(row[j][k] == "Y") {
						if(rCount != 0) {
							rCount = 0;
						}
						yCount++;
					}else if(row[j][k] == "R") {
						if(yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}
					
					if(yCount == 4) {
						winnerFlag = true;
						winner = "Yellow";
					}else if(rCount == 4) {
						winnerFlag = true;
						winner = "Red";
					}
					j--;
				}
			}
		}
	}
	
	public void crossLeftCheck(String row[][]) {
		for(int i = 3; i < 10; i++) {
			int j;
			int k;
			int yCount = 0;
			int rCount = 0;
			
			if(i < 7) {
				k = 6;
				for(j = i; j > -1; j--) {
					if(row[j][k] == "Y") {
						if(rCount != 0) {
							rCount = 0;
						}
						yCount++;
					}else if(row[j][k] == "R") {
						if(yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}
					
					if(yCount == 4) {
						winnerFlag = true;
						winner = "Yellow";
					}else if(rCount == 4) {
						winnerFlag = true;
						winner = "Red";
					}
					k--;
				}
			}else {
				j = 6;
				for(k = i - 6; k < -1; k--) {
					if(row[j][k] == "Y") {
						if(rCount != 0) {
							rCount = 0;
						}
						yCount++;
					}else if(row[j][k] == "R") {
						if(yCount != 0) {
							yCount = 0;
						}
						rCount++;
					}
					
					if(yCount == 4) {
						winnerFlag = true;
						winner = "Yellow";
					}else if(rCount == 4) {
						winnerFlag = true;
						winner = "Red";
					}
					j--;
				}
			}
		}
	}
	
	public void display() {
		displayRow(row);
		System.out.println(
			"---------------"
		);
	}
	
	public void write(int colNum, String colour) {
		for(int i = 0; i < ROWNUM; i++) {
			if(row[ROWNUM - i - 1][colNum] == "") {
				row[ROWNUM - i - 1][colNum] = colour;
				break;
			}
		}
	}
	
	public void initializeRow(String row[][]) {
		for(int i = 0; i < ROWNUM; i++) {
			for(int j = 0; j < COLNUM; j++) {
				row[i][j] = "";
			}
		}
	}
}
