package com.senecacollege.workshop8.task1;

import java.io.*; 
import java.util.*; 
import java.net.*; 
  
// Server class 
public class Server{  
    static Vector<ClientHandler> ar = new Vector<>(); 
  
    public static void main(String[] args) throws IOException  
    { 
        // server is listening on port 1234 
        ServerSocket ss = new ServerSocket(1234);          
        Socket s; 
          
        while (true){  
            s = ss.accept(); 
  
            System.out.println("New client request received : " + s); 
              
            // obtain input and output streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
              
            System.out.println("Creating a new handler for this client..."); 
  
            ClientHandler mtch = new ClientHandler(s, s.getPort()); 
  
            Thread t = new Thread(mtch); 
              
            System.out.println("Adding this client to active client list"); 
   
            ar.add(mtch); 
  
            t.start(); 
        } 
    } 
} 