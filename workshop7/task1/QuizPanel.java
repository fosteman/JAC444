package com.senecacollege.workshop7.task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class QuizPanel extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		int num1 = (int)Math.ceil(Math.random() * 10);
		int num2 = (int)Math.ceil(Math.random() * 10);
		QuizPanel quizPanel = new QuizPanel();
		quizPanel.start(primaryStage, num1, num2);
		
	}	
	
	public void start(Stage primaryStage, int num1, int num2) throws Exception{
		GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(11.5, 120, 11.5, 120));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    // Place nodes in the pane
	    Label lblNumShow = new Label("Two randomly generated numbers are: " + num1 + " and " + num2);
	    GridPane.setHalignment(lblNumShow, HPos.CENTER);
	    pane.add(lblNumShow, 0, 0);
	    
	    Label lblAdd = new Label("What is addition of " + num1 + " and " + num2 );
	    GridPane.setHalignment(lblAdd, HPos.CENTER);
	    pane.add(lblAdd, 0, 1);
	    
	    TextField txtAdd = new TextField();
	    GridPane.setHalignment(txtAdd, HPos.CENTER);
	    txtAdd.setMaxWidth(132);
	    txtAdd.setMinWidth(132);
	    pane.add(txtAdd, 1, 1);
	    
	    Label lblSub = new Label("What is substraction of " + num1 + " and " + num2 );
	    GridPane.setHalignment(lblSub, HPos.CENTER);
	    pane.add(lblSub, 0, 2);
	    
	    TextField txtSub = new TextField();
	    GridPane.setHalignment(txtSub, HPos.CENTER);
	    txtSub.setMaxWidth(132);
	    txtSub.setMinWidth(132);
	    pane.add(txtSub, 1, 2);
	    
	    Label lblMul = new Label("What is multiplication of " + num1 + " and " + num2 );
	    GridPane.setHalignment(lblMul, HPos.CENTER);
	    pane.add(lblMul, 0, 3);
	    
	    TextField txtMul = new TextField();
	    GridPane.setHalignment(txtMul, HPos.CENTER);
	    txtMul.setMaxWidth(132);
	    txtMul.setMinWidth(132);
	    pane.add(txtMul, 1, 3);
	    
	    Label lblDiv = new Label("What is division of " + num1 + " and " + num2 );
	    GridPane.setHalignment(lblDiv, HPos.CENTER);
	    pane.add(lblDiv, 0, 4);
	    
	    TextField txtDiv = new TextField();
	    GridPane.setHalignment(txtDiv, HPos.CENTER);
	    txtDiv.setMaxWidth(132);
	    txtDiv.setMinWidth(132);
	    pane.add(txtDiv, 1, 4);
	    
	    Label lblCorrectAnsw = new Label("Number of Correct Answers: ");
	    GridPane.setHalignment(lblCorrectAnsw, HPos.CENTER);
	    pane.add(lblCorrectAnsw, 0, 5);
	    
	    Label lblWrngAnsw = new Label("Number of Wrong Answers: ");
	    GridPane.setHalignment(lblWrngAnsw, HPos.CENTER);
	    pane.add(lblWrngAnsw, 0, 6);
	    
	    Button btnSubmit = new Button("Check Answer");
	    pane.add(btnSubmit, 0, 7);
	    GridPane.setHalignment(btnSubmit, HPos.CENTER);
	    
	    Button btnReset = new Button("Reset Number");
	    pane.add(btnReset, 1, 7);
	    GridPane.setHalignment(btnReset, HPos.CENTER);
	        
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Quiz Application"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean isEmpty = txtAdd.getText().isEmpty() || txtSub.getText().isEmpty() || txtMul.getText().isEmpty() || txtDiv.getText().isEmpty();
				
				if(isEmpty) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please fill in the blank");
				}else {
//					String gender = txtGender.getText();
//					String year = txtYear.getText();
//					int yearInt = Integer.parseInt(year);
//					String name = txtName.getText();
//					if(!gender.equals("M") && !gender.equals("F")) {
//						if(yearInt < 2001 || yearInt > 2010) {
//							showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter M or F in the Name box\n"
//																										+ "Please enter between 2001 and 2010 in the Year box");	
//						}else {
//							showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter M or F in the Name box");	
//						}
//						
//					}else if(yearInt < 2001 || yearInt > 2010) {
//						showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter between 2001 and 2010 in the Year box");	
//					}else {
//						int rank;
//						popRank.initialize();
//						
//						if(gender.equals("M")) {
//							popRank.getFileInfo(year);
//							rank = popRank.findName(gender, name);
//							if(rank != -1) {
//								lblResult.setText("Boy name " + txtName.getText() + " is ranked #" + rank + " in " + txtYear.getText() + " year.");
//							}else {
//								lblResult.setText("Boy name " + txtName.getText() + " in " + year + ": No result");
//							}
//							
//						}else {
//							popRank.getFileInfo(year);
//							rank = popRank.findName(gender, name);
//							if(rank != -1) {
//								lblResult.setText("Girl name " + txtName.getText() + " is ranked #" + rank + " in " + txtYear.getText() + " year.");
//							}else {
//								lblResult.setText("Girl name " + txtName.getText() + " in " + year + ": No result");
//							}							
//						}
//					}
					
				}							
			}		    	
		  });
	    
	    btnReset.setOnAction(new EventHandler<ActionEvent>(){
	    	QuizPanel quizPanel = new QuizPanel();
	    	
			@Override
			public void handle(ActionEvent event) {
				int num1 = (int)Math.ceil(Math.random() * 10);
				int num2 = (int)Math.ceil(Math.random() * 10);
				try {
					quizPanel.start(primaryStage, num1, num2);
				} catch (Exception e) {
					System.err.println("Exception: " + e);
				}
			}
	    });
	}
	
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	  	Alert alert = new Alert(alertType);
	  	alert.setTitle(title);
	  	alert.setHeaderText(null);
	  	alert.setContentText(message);
	  	alert.initOwner(owner);
	  	alert.show();
	  }
}
