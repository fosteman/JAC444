package com.senecacollege.workshop8.task1;

import java.awt.List;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		final int port = 5500;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Server waiting for connection on port "+port);
		ServerSocket ss = new ServerSocket(port);
		Socket clientSocket = ss.accept();
		
		System.out.println("Recieved connection. Wait for another client");
		Socket clientSocket1 = ss.accept();
		
		System.out.println("Received another connection");
		
		//create two threads to send and recieve from client
		RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket, clientSocket1);
		Thread thread = new Thread(recieve);
		thread.start();
		
	}}

class RecieveFromClientThread implements Runnable
{
	Socket clientSocket=null;
	Socket clientSocket2 = null;
	BufferedReader brBufferedReader = null;
	BufferedReader brBufferedReader2 = null;
	PrintWriter pwPrintWriter;
	PrintWriter pwPrintWriter2;
	
	public RecieveFromClientThread(Socket clientSocket, Socket clientSocket2)
	{
		this.clientSocket = clientSocket;
		this.clientSocket2 = clientSocket2;
	}//end constructor
	public void run() {
		try{
		brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		brBufferedReader2 = new BufferedReader(new InputStreamReader(this.clientSocket2.getInputStream()));
		pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));//get outputstream
		pwPrintWriter2 = new PrintWriter(new OutputStreamWriter(this.clientSocket2.getOutputStream()));
		
		String messageString, messageString2;
		while(true){
			boolean startFlag = true;
			int disConnectCount = 0;
			while(startFlag || brBufferedReader.ready() || brBufferedReader2.ready()) {
				String msgToAnotherClient = null;
				String mainMessage = "";
				String name = "";
				int index;
				
				if(brBufferedReader.ready()) {
					messageString = brBufferedReader.readLine();
					msgToAnotherClient = messageString;
					System.out.println(messageString);
					
					
				
					index = messageString.indexOf(' ');
					System.out.println(index);
					name = messageString.substring(0, index - 1);
					mainMessage = messageString.substring(index + 1);
					System.out.println(mainMessage);
					
					if(mainMessage.equals("EXIT")){
						disConnectCount++;
						System.out.println(name + " close chat");
						this.clientSocket.close();
					}else {
						pwPrintWriter.println(msgToAnotherClient);//send message to client with PrintWriter
						pwPrintWriter.flush();//flush the PrintWriter
					}
					
					pwPrintWriter2.println(msgToAnotherClient);
					pwPrintWriter2.flush();

				}else if(brBufferedReader2.ready()) {
					messageString2 = brBufferedReader2.readLine();
					msgToAnotherClient = messageString2;
					System.out.println(messageString2);
						
					index = messageString2.indexOf(' ');
					System.out.println(index);
					name = messageString2.substring(0, index - 1);
					mainMessage = messageString2.substring(index + 1);
					System.out.println(mainMessage);
					
					if(mainMessage.equals("EXIT")){
						disConnectCount++;
						System.out.println(name + " close chat");
						this.clientSocket.close();
					}else {
						pwPrintWriter.println(msgToAnotherClient);//send message to client with PrintWriter
						pwPrintWriter.flush();//flush the PrintWriter
					}
	
					
				}
				
				if(disConnectCount == 2) {
					System.out.println("Chatting ends");
					break;
				}	
			}

		System.exit(0);
		}
		
	}
	catch(Exception ex){System.out.println(ex.getMessage());}
	}
}//end class RecieveFromClientThread
