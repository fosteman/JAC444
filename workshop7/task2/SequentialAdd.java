/**********************************************

Workshop #7

Course:JAC444 - Winter Semester

Last Name: Lee

First Name: Hyunji

ID: 145732178

Section: SCC

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature Hyunji Lee

Date: 29/3/2019

**********************************************/

package com.senecacollege.workshop7.task2;

public class SequentialAdd {
	double matrix1[][];
	double matrix2[][];
	int size;
	static double sum[][];
	
	public SequentialAdd(double m1[][], double m2[][]) {
		matrix1 = m1;
		matrix2 = m2;
		size = m1.length;
		sum = new double[size][size];
	}
	
	public static double[][] sequentialAddMatrix(double[][] m1, double[][] m2) {
		int arraySize = m1.length;
		double sum[][] = new double[arraySize][arraySize];
		long startTime, endTime;
		
		startTime = System.nanoTime();

		for(int i = 0; i < arraySize; i++) {
			for(int j = 0; j < arraySize; j++) {
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		endTime = System.nanoTime();
		
		System.out.println("Sequential time:" + (endTime - startTime));

		return sum;
	}
	
	public void displaySequentialTime() {
		sequentialAddMatrix(matrix1, matrix2);
	}
}
