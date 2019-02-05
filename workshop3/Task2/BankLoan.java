package Task2;
import java.util.Scanner;

public class BankLoan{
	private int loanBankId;
	private double loanBankAmount;
	
	public BankLoan(int bankId) {
		Scanner input = new Scanner(System.in);
		double bankAmount;
		this.loanBankId = bankId;
		
		System.out.print("Amount: ");
		bankAmount = input.nextDouble();
		this.loanBankAmount = bankAmount;
	}
	
	public void setLoanBankAmount(double balance) {
		this.loanBankAmount = balance;
	}
	
	public int getLoanBankId() {
		return this.loanBankId;
	}
	
	public double getLoanBankAmount() {
		return this.loanBankAmount;
	}
	
	public void resetLoanBankAmount() {
		loanBankAmount = 0;
	}
}
