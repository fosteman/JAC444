//package com.senecacollege.workshop8.task1;
//
//import java.io.*;
//import java.net.*;
//import java.lang.*;
//
//public class ChatServer {
//	public static void main(String[] args) throws IOException {
//		final int port = 444;
//		System.out.println("Server waiting for connection on port "+port);
//		ServerSocket ss = new ServerSocket(port);
//		Socket clientSocket = ss.accept();
//		
////		System.out.println("Recieved connection. Wait for another client");
////		Socket clientSocket1 = ss.accept();
//		
//		//create two threads to send and recieve from client
//		RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket);
//		Thread thread = new Thread(recieve);
//		thread.start();
//		SendToClientThread send = new SendToClientThread(clientSocket);
//		Thread thread2 = new Thread(send);
//		thread2.start();
//		
//	}}
//class RecieveFromClientThread implements Runnable
//{
//	Socket clientSocket=null;
//	BufferedReader brBufferedReader = null;
//	
//	public RecieveFromClientThread(Socket clientSocket)
//	{
//		this.clientSocket = clientSocket;
//	}//end constructor
//	public void run() {
//		try{
//		brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));		
//		
//		String messageString;
//		while(true){
//			messageString = brBufferedReader.readLine();
//			
//		while(messageString != null){//assign message from client to messageString
//			if(messageString.equals("EXIT"))
//			{
//				break;//break to close socket if EXIT
//			}
//			System.out.println("From Client: " + messageString);//print the message from client
//			System.out.println("Please enter something to send back to client..");
//		}
//		this.clientSocket.close();
//		System.exit(0);
//	}
//		
//	}
//	catch(Exception ex){System.out.println(ex.getMessage());}
//	}
//}//end class RecieveFromClientThread
//class SendToClientThread implements Runnable
//{
//	PrintWriter pwPrintWriter;
//	Socket clientSock = null;
//	
//	public SendToClientThread(Socket clientSock)
//	{
//		this.clientSock = clientSock;
//	}
//	public void run() {
//		try{
//		pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
//		
//		while(true)
//		{
//			String msgToClientString = null;
//			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput
//			
//			msgToClientString = input.readLine();//get message to send to client
//			
//			pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
//			pwPrintWriter.flush();//flush the PrintWriter
//			System.out.println("Please enter something to send back to client..");
//		}//end while
//		}
//		catch(Exception ex){System.out.println(ex.getMessage());}	
//	}//end run
//}//end class SendToClientThread




package com.senecacollege.workshop8.task1;

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		final int port = 444;
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
		SendToClientThread send = new SendToClientThread(clientSocket, clientSocket1);
		Thread thread2 = new Thread(send);
		thread2.start();
		
	}}

class RecieveFromClientThread implements Runnable
{
	Socket clientSocket=null;
	Socket clientSocket2 = null;
	BufferedReader brBufferedReader = null;
	BufferedReader brBufferedReader2 = null;
	
	public RecieveFromClientThread(Socket clientSocket, Socket clientSocket2)
	{
		this.clientSocket = clientSocket;
		this.clientSocket2 = clientSocket2;
	}//end constructor
	public void run() {
		try{
		brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		brBufferedReader2 = new BufferedReader(new InputStreamReader(this.clientSocket2.getInputStream()));
		
		String messageString, messageString2;
		while(true){
			
		while((messageString = brBufferedReader.readLine())!= null && (messageString2 = brBufferedReader2.readLine())!= null){//assign message from client to messageString
			if(messageString.equals("EXIT") || messageString2.equals("EXIT"))
			{
				System.out.println("Bye bye");
				System.out.println("Disconnected");
				break;//break to close socket if EXIT
			}
			System.out.println("From " + messageString);//print the message from client
			System.out.println("From " + messageString2);
			System.out.println("Please enter something to send back to client..");
			System.out.println("Still receive");
		}
		this.clientSocket.close();
		this.clientSocket2.close();
		System.out.println("Recieve end");
		System.exit(0);
	}
		
	}
	catch(Exception ex){System.out.println(ex.getMessage());}
	}
}//end class RecieveFromClientThread

class SendToClientThread implements Runnable
{
	PrintWriter pwPrintWriter;
	PrintWriter pwPrintWriter2;
	Socket clientSock = null;
	Socket clientSock2 = null;
	
	public SendToClientThread(Socket clientSock, Socket clientSocket2)
	{
		this.clientSock = clientSock;
		this.clientSock2 = clientSocket2;
	}
	public void run() {
		try{
		pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
		pwPrintWriter2 = new PrintWriter(new OutputStreamWriter(this.clientSock2.getOutputStream()));
		
		while(true)
		{
			System.out.println("Send start");
			String msgToClientString = null;
			String msgToClientString2 = null;
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput
//			BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
			
			msgToClientString = input.readLine();//get message to send to client
//			msgToClientString2 = input2.readLine();
			
			pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
			pwPrintWriter2.println(msgToClientString);
			pwPrintWriter.flush();//flush the PrintWriter
			pwPrintWriter2.flush();
			
//			pwPrintWriter2.println(msgToClientString2);
//			pwPrintWriter2.flush();
			
			
			System.out.println("Please enter something to send back to client..");
		}//end while
		}
		catch(Exception ex){System.out.println(ex.getMessage());}	
	}//end run
}//end class SendToClientThread