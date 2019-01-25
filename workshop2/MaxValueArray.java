import java.util.Scanner;

public class MaxValueArray{
	public static Location locateLargest(double[][] a) {
		Location location = new Location(a);
		location.setRowNum(a.length);
		location.setColumnNum(a[0].length);
		location.setMaxValue(location.getArrayNum(0, 0));
		location.setMaxRow(0);
		location.setMaxColumn(0);
		int i, j;
		
		for(i = 0; i < location.getRowNum(); i++) {
			for(j = 0; j < location.getColumnNum(); j++) {
				if(location.getArrayNum(i, j) > location.getMaxValue()) {
					location.setMaxValue(location.getArrayNum(i, j));
					location.setMaxRow(i);
					location.setMaxColumn(j);
				}
			}
		}
		
		System.out.print("The location of the largest element is " + location.getMaxValue() + " at (" + location.getMaxRowNum() + ", " + location.getMaxColumnNum() + ")");
		return location;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j, rowNum = 0, columnNum = 0, inputRow = 0, inputColumn = 0;
		double[][] userArray;
		boolean flag = true;
		
		do{
			System.out.print("Enter the number of rows and columns in the array: ");
			
			if(input.hasNextInt()) {
				inputRow = input.nextInt();
				if(inputRow < 0) {
					System.out.println("Please enter positive number");
				}else {
					if(input.hasNextInt()) {
						inputColumn = input.nextInt();
						if(inputColumn < 0) {
							System.out.println("Please enter positive number");
						}else {
							columnNum = inputColumn;
							flag = false;
						}
					}else {
						System.out.println("Please enter number");
						input.next();
					}
				}
			}else {
				System.out.println("Please enter number");
				input.next();
				input.next();
			}
			
		}while(flag);
		
		rowNum = inputRow;
		columnNum = inputColumn;
		userArray = new double[rowNum][columnNum];
			
		System.out.println("Enter the array:");
		for(i = 0; i < rowNum; i++) {
			for(j = 0; j < columnNum; j++) {
				boolean inputFlag = true;
				do {
					while(!input.hasNextDouble()) {
						System.out.println("You didn't enter number at (" + i + ", " + j + ")");
						input.next();
						if(j != columnNum - 1) {
							j++;
						}else {
							i++;
						}
					}
					userArray[i][j] = input.nextDouble();
					inputFlag = false;
				}while(inputFlag);
			}	
		}
		
		locateLargest(userArray);
		
	}

}
