package com.senecacollege.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanMonthlyPayment {
	int numberOfYears;
	double rate, monthlyInterestRate, monthlyPayment;
	double interest, principal, balance;
	
	public void inputData() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("Loan Amount: ");
			try{
				balance = input.nextDouble();
				flag = false;
			}catch(InputMismatchException e) {
				flag = true;
				System.err.println("Please input right number");
				input.nextLine();
			}
		}
		
		flag = true;
		while(flag) {
			System.out.print("Number of Years: ");
			try{
				numberOfYears = input.nextInt();
				flag = false;
			}catch(InputMismatchException e) {
				flag = true;
				System.err.println("Please input right number");
				input.nextLine();
			}
		}
		
		flag = true;
		while(flag) {
			System.out.print("Annual Interest Rate: ");
			try{
				rate = input.nextInt();
				flag = false;
			}catch(InputMismatchException e) {
				flag = true;
				System.err.println("Please input right number");
				input.nextLine();
			}
		}
	}
	
	public void calculate() {
		monthlyInterestRate = rate / 1200;		
		int i;
		
		monthlyPayment = balance * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate,-(numberOfYears * 12))));
		
		System.out.printf("\nMonthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n", monthlyPayment * numberOfYears * 12);
		
		System.out.println("\nPayment#\tInterest\tPrincipal\tBalance");
		
		for(i = 1; i <= numberOfYears * 12; i++) {
			interest = monthlyInterestRate * balance;

			principal = monthlyPayment - interest;
			balance = balance - principal;
			if(balance < 0) {
				balance = 0.0;
			}
			System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n", i, interest, principal, balance);
		}
	}

	public void display() {
		inputData();
		calculate();	
	}

}