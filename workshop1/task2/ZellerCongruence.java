package com.senecacollege.task2;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Exception;

public class ZellerCongruence {
	private int year, month, day, dayOfWeek;
	
	public void setYear() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter year: (e.g., 2012): ");
			
			try {
				year = input.nextInt();
				
				if(year <= 0) {
					System.err.println("Please input year number (not minus number)");
				}else {
					flag = false;
				}
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
				input.nextLine();
			}catch(Exception e) {
				System.err.println("Error occurs: " + e);
			}
		}
	}
	
	public void setMonth() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter month (1-12): ");		
			
			try {
				month = input.nextInt();
				
				if(month < 1 || month > 12) {
					System.err.println("Please input month (1-12)");
					input.nextLine();
				}else {
					flag = false;
					input.nextLine();
				}
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
				input.nextLine();
			}catch(Exception e) {
				System.err.println("Error occurs: " + e);
			}
		}
	}
	
	public void setDay() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {	
			setDayMonth(31);	
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			setDayMonth(30);	
		}else {
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				setDayMonth(29);
			}else {
				setDayMonth(28);
			}
		}
	}
	
	public void setDayMonth(int endDay) {
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		
		while(flag) {
			System.out.print("Enter the day of the month(1-" + endDay + "): ");
			
			try {
				day = input.nextInt();
			}catch(InputMismatchException e) {
				System.err.println("Please enter number");
			}catch(Exception e) {
				System.err.println("Error occurs: " + e);
			}
			
			if(day <= 0 || day > endDay) {
				System.err.println("Please enter 1-" + endDay + " number");
			}else {
				flag = false;
			}
		}
	}
	
	public void calDayOfWeek() {
		setYear();
		setMonth();
		setDay();
		
		dayOfWeek = (day + 26 * (month + 1) / 10 + year % 100 + year % 100 / 4 + year / 100 / 4 + 5 * year * 100) % 7;
		
		System.out.print("Day of the week is ");
		
		if(dayOfWeek == 0) {
			System.out.println("Saturday");
		}else if (dayOfWeek == 1) {
			System.out.println("Sunday");
		}else if (dayOfWeek == 2) {
			System.out.println("Monday");
		}else if (dayOfWeek == 3) {
			System.out.println("Tuesday");
		}else if (dayOfWeek == 4) { 
			System.out.println("Wednesday");
		}else if (dayOfWeek == 5) {
			System.out.println("Thursday");
		}else {
			System.out.println("Friday");
		}
	}
	
}