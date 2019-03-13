package com.senecacollege.workshop5.task1;

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

public class AccountATMRegister extends Application {
	AccountATMDesc accountDesc = new AccountATMDesc();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
 
	public void start(Stage primaryStage, Account[] allAccount, Account account) {
		// Create a pane and set its properties
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    // Place nodes in the pane
	    Label lblRegister = new Label("Account Register");
	    GridPane.setHalignment(lblRegister, HPos.CENTER);
	    pane.add(lblRegister, 0, 0);
	    
	    Label lblAccountNum = new Label("Enter an account number: ");
	    GridPane.setHalignment(lblAccountNum, HPos.CENTER);
	    pane.add(lblAccountNum, 0, 1);
	    
	    TextField txtAccountNum = new TextField();
	    GridPane.setHalignment(txtAccountNum, HPos.CENTER);
	    pane.add(txtAccountNum, 0, 2);
	    
	    Label lblBalance = new Label("What is your balance?");
	    GridPane.setHalignment(lblBalance, HPos.CENTER);
	    pane.add(lblBalance, 0, 3);
	    
	    TextField txtBalanceNum = new TextField();
	    GridPane.setHalignment(txtBalanceNum, HPos.CENTER);
	    pane.add(txtBalanceNum, 0, 4);
	    
	    Label lblFirstName = new Label("What is your first name?");
	    GridPane.setHalignment(lblFirstName, HPos.CENTER);
	    pane.add(lblFirstName, 0, 5);
	    
	    TextField txtFirstName = new TextField();
	    GridPane.setHalignment(txtFirstName, HPos.CENTER);
	    pane.add(txtFirstName, 0, 6);
	    
	    Label lblLastName = new Label("What is your last name?");
	    GridPane.setHalignment(lblLastName, HPos.CENTER);
	    pane.add(lblLastName, 0, 7);
	    
	    TextField txtLastName = new TextField();
	    GridPane.setHalignment(txtLastName, HPos.CENTER);
	    pane.add(txtLastName, 0, 8);
	    
	    Button btnSubmit = new Button("Submit");
	    pane.add(btnSubmit, 0, 9);
	    GridPane.setHalignment(btnSubmit, HPos.CENTER);
	 
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("ShowGridPane"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				if(txtAccountNum.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter your account number");
					return;
				}else {
					account.setId(Integer.parseInt(txtAccountNum.getText()));
					account.setBalance(Double.parseDouble(txtBalanceNum.getText()));
					account.setFirstName(txtFirstName.getText());
					account.setLastName(txtLastName.getText());
					
					account.print();
					accountDesc.start(primaryStage, allAccount, account);
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
