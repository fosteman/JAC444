package com.senecacollege.workshop8.task1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args)
	{
		final int port = 5500;
		String clientName;
		Scanner scanner = new Scanner(System.in);
		try {
			Socket sock = new Socket("localhost",port);
			
			System.out.print("What is your name: ");
			clientName = scanner.next();
			
			SendThread sendThread = new SendThread(sock, clientName);
			Thread thread = new Thread(sendThread);
			thread.start();
			
			RecieveThread recieveThread = new RecieveThread(sock, clientName);
			Thread thread2 =new Thread(recieveThread);
			thread2.start();
		} catch (Exception e) {System.out.println(e.getMessage());} 
	}
}

class RecieveThread implements Runnable
{
	Socket sock=null;
	String clientName;
	BufferedReader recieve=null;
	
	public RecieveThread(Socket sock, String name) {
		this.sock = sock;
		this.clientName = name;
	}//end constructor
	public void run() {
		try{
		recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));//get inputstream
		String msgRecieved = null;
		while((msgRecieved = recieve.readLine())!= null)
		{
			System.out.println(msgRecieved);
			System.out.println("Please enter something to send to server..");
		}
		}catch(Exception e){System.out.println(e.getMessage());}
	}//end run
}//end class recievethread

class SendThread implements Runnable
{
	Socket sock=null;
	String clientName;
	PrintWriter print=null;
	BufferedReader brinput=null;
	
	public SendThread(Socket sock, String name)
	{
		this.sock = sock;
		this.clientName = name;
	}//end constructor
	
	public void run(){
		try{
		if(sock.isConnected())
		{
			System.out.println("Client connected to "+sock.getInetAddress() + " on port "+sock.getPort());
			this.print = new PrintWriter(sock.getOutputStream(), true);	
		while(true){
			System.out.println("Type your message to send to server..type 'EXIT' to exit");
			System.out.print(clientName + ": ");
			brinput = new BufferedReader(new InputStreamReader(System.in));
			String msgtoServerString=null;
			msgtoServerString = brinput.readLine();
			this.print.println(clientName + ": " + msgtoServerString);
			this.print.flush();
		
			if(msgtoServerString.equals("EXIT"))
			break;
			}//end while
		sock.close();}}catch(Exception e){System.out.println(e.getMessage());}
	}//end run method
}//end class