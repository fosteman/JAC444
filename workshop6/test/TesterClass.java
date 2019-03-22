
/**********************************************

Workshop #6

Course:JAC444 - Winter Semester

Last Name:Lee

First Name:Hyunji

ID:145732178

Section:C

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature Hyunji Lee

Date:21 March 2019

**********************************************/

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
