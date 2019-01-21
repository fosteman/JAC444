import java.util.Scanner;

public class MaxValueArray{
	public static Location locateLargest(double[][] a) {
		Location location = new Location(a);
		double maxVal = location.userArray[0][0];
		int i, j;
		
		for(i = 0; i < location.userArray.length; i++) {
			for(j = 0; j < location.userArray[0].length; j++) {
				if(location.userArray[i][j] > maxVal) {
					location.maxValue = location.userArray[i][j];
					location.row = i;
					location.column = j;
				}
			}
		}
		
		System.out.print("The location of the largest element is " + location.maxValue + " at (" + location.row + ", " + location.column + ")");
		return location;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j;
		
		
		System.out.print("Enter the number of rows and columns in the array: ");
		int rowNum = input.nextInt();
		int columnNum = input.nextInt();
		double[][] userArray = new double[rowNum][columnNum];
		
		System.out.println("Enter the array:");
		for(i = 0; i < rowNum; i++) {
			for(j = 0; j < columnNum; j++) {
				userArray[i][j] = input.nextDouble();
			}	
		}
		
		locateLargest(userArray);
		
		
	}

}
