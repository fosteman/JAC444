package com.senecacollege.workshop6.task1;

import java.util.Scanner;

public class GaltonBox {
	private int ballNum, slotNum;
	
	public GaltonBox() {
		ballNum = 0;
		slotNum = 0;
	}
	
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}
	
	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}
	
	public void playGame() {
		Scanner input =  new Scanner(System.in);
		
		System.out.print("Enter the number of balls to drop: ");
		System.out.print("Enter the number of slots in the bean machine: ");
	}
}
