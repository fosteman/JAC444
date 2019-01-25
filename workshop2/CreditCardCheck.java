import java.util.Scanner;
import java.lang.Math;

public class CreditCardCheck{
	
	//method 1
	public static boolean checkCreditValid(long cardNum) {
		int validNum = 0;
		if(numOfDigit(cardNum) >= 13 && numOfDigit(cardNum) <= 16) {
			if(cardPrefix(cardNum)) {
				validNum = SecondDigitDoubleSum(cardNum) + oddSum(cardNum);
				if(validNum %10 == 0) {
					return true;
				}else {
					return false;
				}
			}else {
				System.out.println("The prefix number is different");
			}
		}else {
			System.out.println("The number of card number should between 13 and 16");
		}
		return false;
	}
	
	//method 2
	public static int SecondDigitDoubleSum(long cardNum) {
		int cardNumOfDigit = numOfDigit(cardNum);
		int secondDigitDouble = 0;
		int cardNumSum = 0, i, j;
		long tenDivision = 10;
		
		for(i = 0; i < cardNumOfDigit; i++) {
			secondDigitDouble = (int)(2 * (((cardNum % (tenDivision * 10)) - (cardNum % tenDivision)) / tenDivision));
			tenDivision *= 100;
			i++;
			
			cardNumSum += cardNumSumCheck(secondDigitDouble);
		}
		
		return cardNumSum;
	}
	
	//method 3
	public static long cardNumSumCheck(long cardNumSum) {
		
		if(cardNumSum < 10) {
			return cardNumSum;
		}else {
			return cardNumSum % 10 + cardNumSum / 10;
		}
	}
	
	//method 4
	public static int oddSum(long cardNum) {
		int sum = 0;
		
		for(int i = 1; i < numOfDigit(cardNum) + 1; i++) {
			double modularNum = Math.pow(10, i) / 10;
			sum += ((cardNum % (modularNum * 10)) - (cardNum % modularNum)) / modularNum;
			i++;
		}
		
		return sum;
	}
	
	//method 5
	public static boolean cardPrefix(long cardNum) {
		int cardDigitNum = numOfDigit(cardNum);
		int prefix1 = (int)(cardNum / Math.pow(10, cardDigitNum - 1));
		int prefix2 = (int)(cardNum / Math.pow(10, cardDigitNum - 2));
		
		if(prefix1 == 4 || prefix1 == 5 || prefix1 == 6 || prefix2 == 37) {
			return true;
		}else {
			return false;
		}
	}
	
	//method 6
	public static int numOfDigit(long cardNum) {
		int count = 0;
		
		while(cardNum != 0) {
			cardNum /= 10;
			count++;
		}
		
		return count;
	}
	
	//method 7
	public static long firstKNumber(long cardNum, int k) {
		long product = 1;
		
		for(int i = 0; i < cardNum; i++)
			product *= cardNum;
		
		while((int)(product / Math.pow(10, k)) != 0)
			product = product / 10;
		
		return product;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int creditCardLength = 0;
		long creditCardNum, inputCardNum = 0;
		boolean flag = true;
		
		while(flag){
			System.out.println("Enter a credit card number as a long integer:");
			
			while(!input.hasNextLong()) {
				System.out.println("Please input number");
				input.next();
			}
			
			inputCardNum = input.nextLong();	
			
			if(inputCardNum < 0) {
				System.out.println("Please enter positive number");
			}else {
				flag = false;
			}	
		}
		
		System.out.print("  ");
		creditCardNum = inputCardNum;
		
		if(checkCreditValid(creditCardNum)) {
			System.out.println(creditCardNum + " is valid");
		}else {
			System.out.println(creditCardNum + " is invalid");
		}
		
		
	}

}
