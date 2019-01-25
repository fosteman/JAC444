
public class Location {
	private double maxValue;
	private int row, column, maxRow, maxColumn;
	private double[][] userArray;
	
	public Location(double[][] a){
		this.userArray = new double[(int)(a.length)][(int)(a[0].length)];
		userArray = a;
	}
	
	public void setMaxValue(double maxVal) {
		this.maxValue = maxVal;
	}
	
	public void setRowNum(int rowNum) {
		this.row = rowNum;
	}
	
	public void setColumnNum(int columnNum) {
		this.column = columnNum;
	}
	
	public void setMaxRow(int maxRowNum) {
		this.maxRow = maxRowNum;
	}
	
	public void setMaxColumn(int maxColumnNum) {
		this.maxColumn = maxColumnNum;
	}
	
	public double getMaxValue() {
		return this.maxValue;
	}
	
	public int getRowNum() {
		return this.row;
	}
	
	public int getColumnNum() {
		return this.column;
	}
	
	public int getMaxRowNum() {
		return this.maxRow;
	}
	
	public int getMaxColumnNum() {
		return this.maxColumn;
	}
	
	public double getArrayNum(int rowNum, int columnNum) {
		return userArray[rowNum][columnNum];
	}

}
