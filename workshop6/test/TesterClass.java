package com.senecacollege.workshop6.test;

import com.senecacollege.workshop6.task1.*;
import com.senecacollege.workshop6.task2.*;
import javafx.application.Application;

import java.util.StringTokenizer;

public class TesterClass {
	public static void main(String[] args) {
		//task1
		GaltonBox galtonBox = new GaltonBox();
		galtonBox.playGame();
		
		//task2
		Application.launch(RankingPanel.class);
	}
}
