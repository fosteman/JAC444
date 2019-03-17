package com.senecacollege.workshop6.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GaltonBox {
	private int ballNum, slotNum;
	
	public GaltonBox() {
		ballNum = 0;
		slotNum = 0;
		System.out.println("GaltonBox created");
	}
	
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}
	
	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}
	
	public void playGame() {
		Scanner input =  new Scanner(System.in);
		boolean whileFlag, playFlag = true;
		int playAgainAnswer;
		
		while(playFlag) {
			whileFlag = true;
			
			while(whileFlag) {
				System.out.print("Enter the number of balls to drop: ");
				try {
					this.ballNum = input.nextInt();
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
			
			whileFlag = true;
			
			while(whileFlag) {
				System.out.print("Enter the number of slots in the bean machine: ");
				try {
					this.slotNum = input.nextInt();
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
			
			whileFlag = true;
			while(whileFlag) {
				System.out.print("Do you want to play again? (1: yes, 0: no)");
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
			
		}
		
	}
}
