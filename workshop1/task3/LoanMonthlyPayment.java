package com.senecacollege.task3;

import java.util.Scanner;

public class LoanMonthlyPayment {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
	
		System.out.print("Loan Amount: ");
		double balance = input.nextDouble();
		System.out.print("Number of Years: ");
		int numberOfYears = input.nextInt();
		System.out.print("Annual Interest Rate: ");
		double rate = input.nextInt();		
		
		double monthlyInterestRate = rate / 1200;		
		int i;
		double interest, principal;
		double monthlyPayment = balance * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate,-(numberOfYears * 12))));
		
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

}