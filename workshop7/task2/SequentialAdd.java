package com.senecacollege.workshop7.task2;

public class SequentialAdd {
	double matrix1[][];
	double matrix2[][];
	int size;
	double sum;
	
	public SequentialAdd(double m1[][], double m2[][]) {
		matrix1 = m1;
		matrix2 = m2;
		size = m1.length;
		sum = 0;
	}
	
	public void sequential(double[][] m1, double[][] m2) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				sum += m1[i][j] + m2[i][j];
			}
		}
	}
	
	public double getSum() {
		return this.sum;
	}
}
