package Main;

import java.util.Scanner;
import Task1.*;
import Task2.*;
import Task3.*;

public class TesterClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Task1
		try {
			double num1 = 0, num2 = 0;
			boolean flag = true;
			
			do {
				System.out.print("Enter the first complex number: ");
				if(input.hasNextDouble()) {
					num1 = input.nextDouble();
					if(input.hasNextDouble()) {
						num2 = input.nextDouble();
						flag = false;
					}else {
						System.out.println("You enter strings. Please enter number");
						input.next();
						num1 = 0;
					}
				}else {
					System.out.println("You enter strings. Please enter number");
					input.next();
					input.next();
				}
			}while(flag);
			
			Complex com1 = new Complex(num1, num2);
			flag = true;
			
			do {
				System.out.print("Enter the Second complex number: ");
				if(input.hasNextDouble()) {
					num1 = input.nextDouble();
					if(input.hasNextDouble()) {
						num2 = input.nextDouble();
						flag = false;
					}else {
						System.out.println("You enter strings. Please enter number");
						input.next();
						num1 = 0;
					}
				}else {
					System.out.println("You enter strings. Please enter number");
					input.next();
					input.next();
				}
			}while(flag);
			
			Complex com2 = new Complex(num1, num2);
			
			com1.add(com2);
			com1.substract(com2);
			com1.multiply(com2);
			com1.divide(com2);
			com1.abs();
			
			System.out.println();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		
		
		//Task2
		try {
			BankManager manager = new BankManager();
			manager.safeResultPrint();
			
			System.out.println();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		
		
		//Task3
		try {
			GeometricObject[] geoObj = new GeometricObject[5];
			
			geoObj[0] = new Square();
			geoObj[1] = new Octagon();
			geoObj[2] = new Triangle();
			geoObj[3] = new Octagon();
			geoObj[4] = new Square();
			
			for(int i = 0; i < 5; i++) {
				geoObj[i].howToColor();
			}
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
	
	}

}
