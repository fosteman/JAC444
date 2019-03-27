package com.senecacollege.workshop7.task2;

public class ParallelAdd implements Runnable {
	double matrix1[][];
	double matrix2[][];
	int size;
	double sum;
	int threadID;
	
	public ParallelAdd(double m1[][], double m2[][], int threadId) {
		matrix1 = m1;
		matrix2 = m2;
		threadID = threadId;
		size = matrix1.length;
		sum = 0;
	}
	
	@Override
	public void run() {
		int colStart = (int)((threadID % 2) * (size / 2));
		int rowStart = (int)((int)(threadID / 2) * (size / 2));
		int colEnd = colStart + (int)(size / 2);
		int rowEnd = rowStart + (int)(size / 2);
		
		for(int i = colStart; i < colEnd; i++) {
			for(int j = rowStart; j < rowEnd; j++) {
				sum += matrix1[i][j] + matrix2[i][j];
			}
		}
	}
	
	public double getSum() {
		return this.sum;
	}

}
