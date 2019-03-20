package com.senecacollege.workshop6.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PopulationRank {
	String rank[];
	String boyNum[];
	String girlNum[];
	String boyName[];
	String girlName[];
	
	public PopulationRank() {
		rank = new String[1000];
		boyNum = new String[1000];
		girlNum = new String[1000];
		boyName = new String[1000];
		girlName = new String[1000];
	}
	
	public int findName(String gender, String name) {
		int rank = -1;
		
		if(gender.equals("M")) {
			System.out.println("Works");
			for(int i = 0; i < 1000; i++) {
				if(boyName[i].equals(name)) {
					rank = i + 1;
				}
			}
		}else {
			System.out.println("works2");
			for(int i = 0; i < 1000; i++) {
				if(girlName[i].equals(name)) {
					rank = i + 1;
				}
			}
		}
			
		return rank;
	}
	
	public void getFileInfo(String fileName) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("babynamesranking" + fileName + ".txt"));
			String line = reader.readLine();
			int count = 0;
			while(line != null) {							
				StringTokenizer token;
				
				try {
					if(line != null) {
						token = new StringTokenizer(line);
						
						rank[count] = token.nextToken();
						boyName[count] = token.nextToken();
						boyNum[count] = token.nextToken();
						girlName[count] = token.nextToken();
						girlNum[count] = token.nextToken();
					}
						
				}catch(Exception e) {
					System.out.println("Exception: " + e);
				}
				
				line = reader.readLine();
				count++;
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Exception: " + e);
		}
	}
}
