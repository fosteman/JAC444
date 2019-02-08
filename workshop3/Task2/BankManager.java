package Task2;

import java.util.Scanner;

public class BankManager {
	private int bankNum;
	private double assetLimit;
	private Bank[] bank;
	
	public BankManager() {
		Scanner input = new Scanner(System.in);
		int bankNum;
		double assetLimit;
		boolean flag = true;
		
		do {
			System.out.print("Number of banks: ");
			if(input.hasNextInt()) {
				bankNum = input.nextInt();
				this.bankNum = bankNum;
				flag = false;

			}else {
				System.out.println("Please enter integar number");
				input.next();
			}
		}while(flag);
		
		flag = true;
		
		do {
			System.out.print("Minimum asset limit: ");
			if(input.hasNextDouble()) {
				assetLimit = input.nextDouble();
				this.assetLimit = assetLimit;
				flag = false;

			}else {
				System.out.println("Please enter number");
				input.next();
			}
		}while(flag);
		

		bank = new Bank[this.bankNum];
		
		for(int i = 0; i < this.bankNum; i++) {
			bank[i] = new Bank(i);
		}
		
		for(int i = 0; i < this.bankNum; i++) {
			System.out.println("Bank#" + i);
			bank[i].setBankLoan();
		}
	}
	
	public void isSafe() {
		for(int i = 0; i < bankNum; i++) {
			if(this.assetLimit > bank[i].getAmount() + bank[i].getBalance()) {
				bank[i].setIsSafe(false);
			}
		}
	}
	
	public void safeCheck() {
		for(int i = 0; i < this.bankNum; i++) {
			if(!bank[i].getIsSafe()) {
				for(int j = 0; j < this.bankNum; j++) {
					for(int k = 0; k < bank[j].getBankLoanNum(); k++) {
						if(bank[j].getBankLoan(k).getLoanBankId() == i) {
							bank[j].setAmount((bank[j].getBankLoan(k).getLoanBankAmount()) * (-1));
							bank[j].getBankLoan(k).resetLoanBankAmount();
						}
					}
				}
			}
		}
	}
	
	public void safeResultPrint() {
		int count = 0;
		this.isSafe();
		this.safeCheck();
		this.isSafe();
		
		for(int i = 0; i < this.bankNum; i++) {
			if(!bank[i].getIsSafe()) {
				count++;
			}
		}
		
		if(count > 0) {
			System.out.print("Unsafe banks are Bank ");
			
			for(int i = 0; i < this.bankNum; i++) {
				if(!bank[i].getIsSafe()) {
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public void bankLoanCheck() {
		for(int i = 0; i < this.bankNum; i++) {
			System.out.println("Bank#" + i);
			for(int j = 0; j < this.bank[i].getBankLoanNum(); j++) {
				System.out.println("BankLoanId" + this.bank[i].bankLoan[j].getLoanBankId() + "\nAmount: " + this.bank[i].bankLoan[j].getLoanBankAmount());
				System.out.println("Total Amount: " + this.bank[i].amountTotal);
			}
		}
	}
	
}

