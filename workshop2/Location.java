
public class Location {
	public double row, column, maxValue;
	public double[][] userArray;
	
	public Location(double[][] a){
		this.userArray = new double[(int)(a.length)][(int)(a[0].length)];
		userArray = a;
	}

}
