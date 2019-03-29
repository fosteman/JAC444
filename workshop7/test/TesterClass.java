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

package com.senecacollege.workshop7.test;

import com.senecacollege.workshop7.task1.*;
import com.senecacollege.workshop7.task2.*;
import javafx.application.Application;

public class TesterClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//task1
		Application.launch(QuizPanel.class);
		
		//task2
		MatrixCalTime time = new MatrixCalTime();
		time.getTime();
	}

}
