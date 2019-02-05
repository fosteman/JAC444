package Task2;
import java.util.Scanner;

public class Bank{
	private int id;
	private int numBankLoan;
	public BankLoan[] bankLoan;
	public double amountTotal;
	private double balance;
	private boolean isSafe;
	
	public Bank(){
		this.id = 0;
		this.numBankLoan = 0;
		this.amountTotal = 0;
		this.balance = 0;
		this.isSafe = true;
	}
	
	public Bank(int bankId){
		Scanner input = new Scanner(System.in);
		this.amountTotal = 0;
		this.isSafe = true;
		this.id = bankId;
		double balance; 
		
		System.out.println("Bank#" + this.id);
		System.out.print("Balance: ");
		balance = input.nextDouble();
		this.balance = balance;
	}
	
	public void setBankLoan() {
		Scanner input = new Scanner(System.in);
		int bankLoanNum;

		System.out.print("Number of banks Loaned: ");
		bankLoanNum = input.nextInt();
		this.numBankLoan = bankLoanNum;
		
		bankLoan = new BankLoan[this.numBankLoan];
		
		for(int i = 0; i < this.numBankLoan; i++) {
			int loanBankId;
			double bankAmount;
			System.out.print("Bank ID: ");
			loanBankId = input.nextInt();
			bankLoan[i] = new BankLoan(loanBankId);
			
			this.amountTotal += bankLoan[i].getLoanBankAmount();
		}
	}
	
	public void setAmount(double amount) {
		this.amountTotal += amount;
	}
	
	public void setIsSafe(boolean isSafe) {
		this.isSafe = isSafe;
	}
	
	public double getAmount() {
		return this.amountTotal;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getBankLoanNum() {
		return this.numBankLoan;
	}
	
	public BankLoan getBankLoan(int loanId) {
		return bankLoan[loanId];
	}
	
	public boolean getIsSafe() {
		return this.isSafe;
	}
	
}
