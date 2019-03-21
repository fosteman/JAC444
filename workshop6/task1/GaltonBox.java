package com.senecacollege.workshop6.task1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GaltonBox {
	private int ballNum, slotNum, slotBall[], slotBallMax;
	List slotBallList;
	
	public GaltonBox() {
		ballNum = 0;
		slotNum = 0;
		slotBall = null;
		slotBallList = new ArrayList();
	}
	
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}
	
	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}
	
	public int numberInput(String askSentence) {
		boolean whileFlag = true;
		int whichNum = -1;
		Scanner input = new Scanner(System.in);
		
		while(whileFlag) {
			System.out.print(askSentence);
			try {
				whichNum = input.nextInt();
				whileFlag = false;
				if(whichNum < 1) {
					System.err.println("Please enter more than 1 number");
					input.next();
				}
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
				input.next();
				whileFlag = true;
			}catch(Exception e) {
				System.err.println("Exception: " + e);
				whileFlag = true;
			}
		}
		
		return whichNum;
	}
	
	public void slotBallInitialize() {
		this.slotBall = new int[this.slotNum];
		for(int i = 0; i < slotBall.length; i++) {
			slotBall[i] = 0;
		}
		
		for(int i = 0; i < slotBall.length; i++)
			slotBallList.add(0);
		
		slotBallMax = 0;
		
	}
	
	public boolean playAgainCheck(boolean playFlag) {
		boolean whileFlag = true;
		int playAgainAnswer;
		Scanner input = new Scanner(System.in);
		
		while(whileFlag) {
			System.out.print("Do you want to play again? (1: yes, 0: no) ");
			try {
				playAgainAnswer = input.nextInt();
				
				if(playAgainAnswer == 0 || playAgainAnswer == 1) {
					whileFlag = false;
					
					if(playAgainAnswer == 0) {
						System.out.println("Bye bye!");
						playFlag = false;
					}else {
						System.out.println("Play Game Again!");
					}
				}else {
					System.err.println("Please enter 1 (yes) or 0 (no)");
				}
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
				input.next();
				whileFlag = true;
			}catch(Exception e) {
				System.err.println("Exception: " + e);
				whileFlag = true;
			}
		}
		
		return playFlag;
	}
	
	public void ballRouteTrace() {
		System.out.println();
		for(int i = 0; i < this.ballNum; i++) {
			int count = 0;
			for(int j = 0; j < this.slotNum - 1; j++) {
				int ranNum = (int)Math.ceil(Math.random() * 2) - 1;
				String leftRight;
				
				if(ranNum == 0) {
					leftRight = "L";
				}else {
					leftRight = "R";
					count++;
				}
				System.out.print(leftRight);
			}
//			int listBallNum = (int)this.slotBallList.get(count);
//			this.slotBallList.set(count, listBallNum + 1);
			this.slotBall[count]++;
			if(this.slotBallMax < this.slotBall[count])
				this.slotBallMax = this.slotBall[count];
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void slotBallDisplay() {
		String[][] slotShow = new String[this.slotBallMax][this.slotNum];
			
		for(int i = 0; i < this.slotBallMax; i++) {
			for(int j = 0; j < this.slotNum; j++) {
				if(this.slotBallMax - this.slotBall[j] <= i)
					System.out.print("O");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}
	
	public void playGame() {
		Scanner input =  new Scanner(System.in);
		boolean whileFlag, playFlag = true;
		int playAgainAnswer;
		
		while(playFlag) {
			whileFlag = true;
			
			this.ballNum = numberInput("Enter the number of balls to drop: ");
			this.slotNum = numberInput("Enter the number of slots in the bean machine: ");	
			
			slotBallInitialize();
			ballRouteTrace();
			slotBallDisplay();
			
			playFlag = playAgainCheck(playFlag);
			
		}
		
	}
}
