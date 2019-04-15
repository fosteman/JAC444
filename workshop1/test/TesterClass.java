package com.senecacollege.test;

import com.senecacollege.task1.*;
import com.senecacollege.task2.*;
import com.senecacollege.task3.*;
import java.util.Scanner;

public class TesterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CramarRule carmar = new CramarRule();
		carmar.solution();
		
		ZellerCongruence zeller = new ZellerCongruence();
		zeller.calDayOfWeek();
	}

}
