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
	    Label lblWelcome = new Label("Welcome Account" + account.getId());
	    GridPane.setHalignment(lblWelcome, HPos.CENTER);
	    pane.add(lblWelcome, 0, 0);
	    
	    Label lblWhatToDo = new Label("What would you like to do?");
	    GridPane.setHalignment(lblWhatToDo, HPos.CENTER);
	    pane.add(lblWhatToDo, 0, 1); 
	    
	    Button btChkBalance = new Button("Check Balance");
	    pane.add(btChkBalance, 0, 2);
	    GridPane.setHalignment(btChkBalance, HPos.CENTER)
	    ;
	    Button btWithdrawMoney = new Button("Withdraw Money");
	    pane.add(btWithdrawMoney, 0, 3);
	    GridPane.setHalignment(btWithdrawMoney, HPos.CENTER);
	    
	    Button depositMoney = new Button("Deposit Money");
	    pane.add(depositMoney, 0, 4);
	    GridPane.setHalignment(depositMoney, HPos.CENTER);
	    
	    Button exitAccount = new Button("Exit the Account");
	    pane.add(exitAccount, 0, 5);
	    GridPane.setHalignment(exitAccount, HPos.CENTER);
	 
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("ShowGridPane"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    exitAccount.setOnAction(new EventHandler<ActionEvent>() {
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
