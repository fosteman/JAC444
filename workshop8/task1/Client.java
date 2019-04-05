package com.senecacollege.workshop8.task1;

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
public class Client  
{ 
    final static int ServerPort = 1234; 
  
    public static void main(String args[]) throws UnknownHostException, IOException  
    { 
        Scanner scn = new Scanner(System.in); 
           
        InetAddress ip = InetAddress.getByName("localhost"); 
           
        Socket s = new Socket(ip, ServerPort); 
          
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
            	System.out.print("What is your name: " );
            	String name = scn.nextLine();
            	
            	try {
					dos.writeUTF(name + " connects");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	boolean flag = true;
            	
                while (flag) { 
  
                	System.out.println(name + ": ");
                    // read the message to deliver. 
                    String msg = scn.nextLine(); 
                      
                    try { 
                        // write on the output stream 
                        dos.writeUTF(name + ": " + msg); 
                    } catch (IOException e) { 
                        e.printStackTrace(); 
                    } 
                    
                    if(msg.equals("exit")) {
                    	flag = false;
                    	try {
							s.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                } 
            } 
        }); 
          
        // readMessage thread 
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
            	boolean flag = true;
                while (flag) { 
                    try {  
                        String msg = dis.readUTF(); 
                        System.out.println(msg); 
                    } catch (IOException e) { 
                        try {
							s.close();
							flag = false;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
                    } 
                } 
            } 
        }); 
  
        sendMessage.start(); 
        readMessage.start(); 
  
    } 
} 
