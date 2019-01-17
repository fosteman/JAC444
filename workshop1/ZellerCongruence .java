import java.util.Scanner;

public class ZellerCongruence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int inputYear, inputMonth, inputDay, year, month, day;
		
		do {
			System.out.print("Enter year: (e.g., 2012): ");
			inputYear = input.nextInt();
		}while(inputYear <= 0);
		year = inputYear;
		
		do {
			System.out.print("Enter month: 1-12: ");
			inputMonth = input.nextInt();
		}while(inputMonth < 1 || inputMonth > 12);
		month = inputMonth;
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			do {
				System.out.print("Enter the day of the month: 1-31: ");
				inputDay = input.nextInt();
			}while(inputDay <= 0 || inputDay > 31);
			day = inputDay;
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			do {
				System.out.print("Enter the day of the month: 1-30: ");
				inputDay = input.nextInt();
			}while(inputDay <= 0 || inputDay > 30);
			day = inputDay;
		}else {
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				do {
					System.out.print("Enter the day of the month: 1-29: ");
					inputDay = input.nextInt();
				}while(inputDay <= 0 || inputDay > 29);
				day = inputDay;
			}else {
				do {
					System.out.print("Enter the day of the month: 1-28: ");
					inputDay = input.nextInt();
				}while(inputDay <= 0 || inputDay > 28);
				day = inputDay;
			}
		}
		
		
		int DOW = (day + 26 * (month + 1) / 10 + year % 100 + year % 100 / 4 + year / 100 / 4 + 5 * year * 100) % 7;
		
		System.out.print("Day of the week is ");
		
		if(DOW == 0) {
			System.out.println("Saturday");
		}else if (DOW == 1) {
			System.out.println("Sunday");
		}else if (DOW == 2) {
			System.out.println("Monday");
		}else if (DOW == 3) {
			System.out.println("Tuesday");
		}else if (DOW == 4) { 
			System.out.println("Wednesday");
		}else if (DOW == 5) {
			System.out.println("Thursday");
		}else {
			System.out.println("Friday");
		}
		

	}

}
