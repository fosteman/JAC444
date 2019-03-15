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

public class AccountATMDesc extends Application {
	
	AccountATM accountAtm = new AccountATM();
	AccountATMBalance accountBalance = new AccountATMBalance();
	AccountATMWithdraw accountWithdraw = new AccountATMWithdraw();
	AccountATMDeposit deposit = new AccountATMDeposit();
	
	private int pin;
	
	  public void start(Stage primaryStage, Account[] allAccount, Account account) {
		  pin = account.getId();
	    // Create a pane and set its properties
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    // Place nodes in the pane
	    Label lblWelcome = new Label("Welcome! Account number: " + account.getId());
	    GridPane.setHalignment(lblWelcome, HPos.CENTER);
	    pane.add(lblWelcome, 0, 0);
	    
	    Label lblWhatToDo = new Label("What would you like to do?");
	    GridPane.setHalignment(lblWhatToDo, HPos.CENTER);
	    pane.add(lblWhatToDo, 0, 1); 
	    
	    Button btnChkBalance = new Button("Check Balance");
	    pane.add(btnChkBalance, 0, 2);
	    GridPane.setHalignment(btnChkBalance, HPos.CENTER)
	    ;
	    Button btnWithdraw = new Button("Withdraw Money");
	    pane.add(btnWithdraw, 0, 3);
	    GridPane.setHalignment(btnWithdraw, HPos.CENTER);
	    
	    Button btndeposit = new Button("Deposit Money");
	    pane.add(btndeposit, 0, 4);
	    GridPane.setHalignment(btndeposit, HPos.CENTER);
	    
	    Button btnExit = new Button("Exit the Account");
	    pane.add(btnExit, 0, 5);
	    GridPane.setHalignment(btnExit, HPos.CENTER);
	 
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("ATM Account"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    btnChkBalance.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		accountBalance.start(primaryStage, allAccount, account);
	    	}
	    });
	    
	    btnWithdraw.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		accountWithdraw.start(primaryStage, allAccount, account);
	    	}
	    });
	    
	    btndeposit.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		deposit.start(primaryStage, allAccount, account);
	    	}
	    });
	    
	    btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				accountAtm.start(primaryStage, allAccount);							
			}
		    	
		});
	  }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
