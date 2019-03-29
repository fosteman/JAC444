package com.senecacollege.workshop5.tester;
import com.senecacollege.workshop5.task1.*;
import com.senecacollege.workshop5.task2.*;
import com.senecacollege.workshop5.task3.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Scanner;
import java.io.*;

public class TesterClass {

	public static void main(String[] args){	
		//task1, task2
		Application.launch(TesterApplication.class);
		
		//task3
		ConnectFour cf = new ConnectFour();
		cf.play();
	}
	

}
