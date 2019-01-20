import java.util.Scanner;
import java.lang.Math;

public class Task1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = {"write", "that", "tplay", "tcode"};
		int missedCount = 0;
		char YN;
		
		do {
			char inputChar;
			String word = words[(int)(Math.random() * words.length)];		
			String userAnswer = "";
			String YNInput = "", userInput;
			int i, userAnswerCount = 0;
			
			for(i = 0; i < word.length(); i++) {
				userAnswer += "*";
			}

			do {
				int inTheWordCount = 0;
				do {
					System.out.print("(Guess) Enter a letter in word " + userAnswer + " > ");
					userInput = input.next();
					
					if(userInput.length() > 1) {
						System.out.println("Only input letter, not string");
					}
				}while(userInput.length() == 0);
				
				inputChar = userInput.charAt(0);
				
				for(i = 0; i < word.length(); i++) {
					if(userAnswer.charAt(i) == inputChar) {
						System.out.println("\t" + inputChar + " is already in the word");
						inTheWordCount++;
						break;
					}else {
						if(word.charAt(i) == inputChar) {
							String newUserAnswer = userAnswer.substring(0, i) + inputChar + userAnswer.substring(i+1);
							userAnswer = newUserAnswer;
							userAnswerCount++;
							inTheWordCount++;
						}
					}	
				}
				
				if(inTheWordCount == 0) {
					System.out.println("\t" + inputChar + " is not in the word");
					missedCount++;
				}
			}while(userAnswerCount != word.length());
			
			System.out.println("The word is program. You missed " + missedCount + " time");
			
			do {
				System.out.print("Do you want to guess another word? Enter y or n> ");
				YNInput = input.next();
				YN = YNInput.charAt(0);
			}while((YN != 'Y' && YN != 'y' && YN != 'N' && YN != 'n') || YNInput.length() > 1);
			
		} while(YN == 'Y' || YN == 'y');
	}
}