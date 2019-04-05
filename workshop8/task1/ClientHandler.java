package com.senecacollege.workshop8.task1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

class ClientHandler implements Runnable  
{ 
    Scanner scn = new Scanner(System.in); 
    DataInputStream dis; 
    DataOutputStream dos; 
    Socket s; 
    boolean isConnect;
    int portNum;
      
    // constructor 
    public ClientHandler(Socket s, int portNum) { 
        try {
        	this.dis = new DataInputStream(s.getInputStream()); 
			this.dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        this.portNum = portNum;
        this.s = s; 
        this.isConnect = true; 
    } 
  
    @Override
    public void run() { 
  
        String received; 
        while (true)  
        { 
            try
            { 
                // receive the string 
                received = dis.readUTF(); 
                  
                System.out.println(received); 
                
                String mainMessage = received.substring(received.indexOf(' ') + 1);
                  
                if(mainMessage.equals("exit")){ 
                    this.isConnect=false; 
                    this.s.close(); 
                    break; 
                } 

                for (ClientHandler mc : Server.ar)  
                { 
                    // if the recipient is found, write on its 
                    // output stream 
                    if (mc.portNum != this.portNum && mc.isConnect == true)  
                    { 
                        mc.dos.writeUTF(received); 
                    } 
                } 
            } catch (IOException e) { 
                  
                e.printStackTrace(); 
            } 
              
        } 
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 
