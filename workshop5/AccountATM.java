package com.senecacollege.workshop5.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

public class AccountATM extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AccountATM accountAtm = new AccountATM();
		Account[] account = new Account[10];
		for(int i = 0; i < 10; i++) {
			account[i] = new Account(0, 100);
		}
		
		accountAtm.start(primaryStage, account);
	}

	public void start(Stage primaryStage, Account[] account) {
	// Create a pane and set its properties
	  
	  AccountATMDesc accountDesc = new AccountATMDesc();
	  AccountATMRegister accountRegister = new AccountATMRegister();
	  
	  
	  
	  GridPane pane1 = new GridPane();
	  pane1.setAlignment(Pos.CENTER);
	  pane1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	  pane1.setHgap(5.5);
	  pane1.setVgap(5.5);
	    
	  // Place nodes in the pane
	  Label lblAccountNum = new Label("Enter your Account number:");
	  GridPane.setHalignment(lblAccountNum, HPos.CENTER);
	  pane1.add(lblAccountNum, 0, 0);
	  
	  TextField txtAccountNum = new TextField();
	  GridPane.setHalignment(txtAccountNum, HPos.CENTER);
	  pane1.add(txtAccountNum, 1, 0);
	  
	  Button btnSubmit = new Button("Submit");
	  pane1.add(btnSubmit, 1, 3);
	  GridPane.setHalignment(btnSubmit, HPos.RIGHT);
	    
	  Button btnExit = new Button("Exit");
	  pane1.add(btnExit, 1,4);
	  GridPane.setHalignment(btnExit, HPos.RIGHT);
	    
	  Scene scene = new Scene(pane1);
	  primaryStage.setTitle("ATM"); // Set the stage title
	  primaryStage.setScene(scene); // Place the scene in the stage
	  primaryStage.show(); // Display the stage
	  
	  btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			if(txtAccountNum.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, pane1.getScene().getWindow(), "Form Error!", "Please enter your account number");
				return;
			}else {
				int findAccount = -1;
				int findInitAccount = -1;
				int accountNum = Integer.parseInt(txtAccountNum.getText());
				
				for(int i = 0; i < 10; i++) {
					if(account[i].getId() == accountNum) {
						findAccount = i;
					}
					
					if(findInitAccount == -1 && account[i].getId() == 0) {
						findInitAccount = i;
					}
				}
				
				System.out.println(findInitAccount);
				
				if(findAccount != -1) {
					accountDesc.start(primaryStage, account, account[findAccount]);
				}else {
					accountRegister.start(primaryStage, account, account[findInitAccount]);
				}
			}
						
		}
	    	
	  });
	    
	  btnExit.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			try {
				FileOutputStream fos = new FileOutputStream("account.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(account);
				fos.close();
				oos.close();
					
				FileInputStream fis = new FileInputStream("account.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Account[] accountFromSavedFile = (Account[])ois.readObject();
				
				for(int i = 0; i < 10; i++) {
					accountFromSavedFile[i].print();
				}
					
				fis.close();
				ois.close();
				primaryStage.close();
			}catch(IOException e) {
				System.err.println("IOException occurs");
			}catch(Exception e) {
				System.err.println("Exception occurs");
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
  

