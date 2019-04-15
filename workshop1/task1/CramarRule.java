package com.senecacollege.task1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Exception;

public class CramarRule {
	private double a, b, c, d, e, f;
	
	public CramarRule() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter a, b, c, d, e, f: ");
			
			try {
				a = input.nextDouble();
				b = input.nextDouble();
				c = input.nextDouble();
				d = input.nextDouble();
				e = input.nextDouble();
				f = input.nextDouble();
				flag = false;
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
				input.nextLine();
			}catch(Exception e) {
				System.err.println("Error occurs: " + e);
			}
		}	
	}
	
	public void solution() {
		if(a * d - b * c == 0) {
			System.out.println("The equation has no solution");
		}else {
			double x = (e * d - b * f) / (a * d - b * c);
			double y = (a * f - e * c) / (a * d - b * c);
			
			System.out.println("x is " + x + " and y is " + y);
		}
	}

}