package com.senecacollege.workshop6.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GaltonBox {
	private int ballNum, slotNum, slotBall[];
	
	public GaltonBox() {
		ballNum = 0;
		slotNum = 0;
		slotBall = null;
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
		this.slotBall = new int[this.slotNum - 1];
		for(int i = 0; i < slotBall.length; i++) {
			slotBall[i] = 0;
		}
		
		System.out.println("Slot initialized");
		
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
	
	public void playGame() {
		Scanner input =  new Scanner(System.in);
		boolean whileFlag, playFlag = true;
		int playAgainAnswer;
		
		while(playFlag) {
			whileFlag = true;
			
			this.ballNum = numberInput("Enter the number of balls to drop: ");
			this.slotNum = numberInput("Enter the number of slots in the bean machine: ");	
			
			slotBallInitialize();
			
			playFlag = playAgainCheck(playFlag);
			
		}
		
	}
}
