package com.senecacollege.workshop7.task2;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MatrixCalTime {
	static int size = 10000;
	double matrix1[][] = new double[size][size];
	double matrix2[][] = new double[size][size];
	SequentialAdd seqAdd;
	static ParallelAdd parAdd0;
	static ParallelAdd parAdd1;
	static ParallelAdd parAdd2;
	static ParallelAdd parAdd3;
	
	public MatrixCalTime() {
		this.initialize();
	}
	
	public void initialize() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix1[i][j] = Math.random();
				matrix2[i][j] = Math.random();
			}
		}
	}
	
	public void getTime() throws InterruptedException {
		long startTime, endTime, duration;
		seqAdd = new SequentialAdd(matrix1, matrix2);
		parAdd0 = new ParallelAdd(matrix1, matrix2, 0);
		parAdd1 = new ParallelAdd(matrix1, matrix2, 1);
		parAdd2 = new ParallelAdd(matrix1, matrix2, 2);
		parAdd3 = new ParallelAdd(matrix1, matrix2, 3);
		
		Thread t0 = new Thread(parAdd0);
		Thread t1 = new Thread(parAdd1);
		Thread t2 = new Thread(parAdd2);
		Thread t3 = new Thread(parAdd3);
		
		//sequential method time
		startTime = System.nanoTime();
		seqAdd.sequential(matrix1, matrix2);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		
		System.out.println("Sequential sum: " + seqAdd.getSum());
		System.out.println("Sequential time:" + duration);
		
		//parallel method time
		startTime = System.nanoTime();
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
		t0.join();
		t1.join();
		t2.join();
		t3.join();
		double threadSum = threadSum();
		endTime = System.nanoTime();
		duration = endTime - startTime;
	
		System.out.println("Parallel sum:\t" + threadSum);
		System.out.println("Parallel time:\t" + duration);
	}
	
	private static double threadSum() {
		return parAdd0.getSum() + parAdd1.getSum() + parAdd2.getSum() + parAdd3.getSum();
	}
}
