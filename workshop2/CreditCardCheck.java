import java.util.Scanner;
import java.lang.Math;

public class CreditCardCheck {
	
	//method 1
	public static boolean checkCreditValid(long cardNum) {
		return false;
	}
	
	//method 2
	public static int cardNumSum(long cardNum) {
		int cardNumOfDigit = numOfDigit(cardNum);
		int cardNumSum = 0, tenDivision = 1, i;
		
		for(i = 0; i < cardNumOfDigit; i++) {
			cardNumSum += ((cardNum % (tenDivision * 10)) - (cardNum % tenDivision)) / tenDivision;
			tenDivision *= 10;
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
			double modularNum = Math.pow(10, i);
			sum += (cardNum % (modularNum * 10)) - (cardNum % modularNum);
			i++;
		}
		
		return sum;
	}
	
	//method 5
	public static boolean cardPrefix(long cardNum) {
		return false;
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
	public static int firstKNumber(long cardNum) {
		return 0;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int creditCardLength = 0;
		long creditCardNum;
		
		System.out.println("Enter a credit card number as a long integer:");
		System.out.print("  ");
		creditCardNum = input.nextLong();
		
		System.out.print(oddSum(creditCardNum));
		
		
	}

}
