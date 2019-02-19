package com.senecacollege.workshop4_task3;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneRemember {
	private static final String FILENAME = "./src/com/senecacollege/workshop4_task3/phoneChar.txt";
	private int[] listNum = new int[7];
	private int phoneNum;
	private boolean flag = true;
	
	public PhoneRemember(int phoneNum) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		this.phoneNum = phoneNum;
		
		try {
			String content = "";
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			char letter;		
			long countLoop = 0L;
			
			for(long i = 0L; i < Math.pow(3, 7); i++) {
				String word = "";
				long count = i;
				int makeCharPhone = this.phoneNum;
				for(int j = 0; j < 7; j++) {
					int onePhoneNumAscii = asciiNumPhone(makeCharPhone % 10);
					int module3 = (int)count % 3;
					
					if(onePhoneNumAscii == 77 && module3 != 0)
						module3++;
					int contentAscii = onePhoneNumAscii + module3;
					word += (char)contentAscii;
					count = count/3;
					makeCharPhone = makeCharPhone / 10;
				}
				StringBuilder reverseWord = new StringBuilder();
				reverseWord.append(word);
				reverseWord = reverseWord.reverse();
				
				bw.write(reverseWord + " ");

			}

			flag = false;
		}catch(IOException e) {
			System.err.println(e);
			flag = true;
		}finally {
			try {
				if(bw != null)
					bw.close();
				if(fw != null)
					fw.close();
			}catch(IOException ex) {
				System.err.println("Error");
			}
		}
	}
	
	public int asciiNumPhone(int onePhoneNum) {
		if(onePhoneNum == 2) 
			return 62;
		else if(onePhoneNum == 3)
			return 65;
		else if(onePhoneNum == 4)
			return 68;
		else if(onePhoneNum == 5)
			return 71;
		else if(onePhoneNum == 6)
			return 74;
		else if(onePhoneNum == 7)
			return 77;
		else if(onePhoneNum == 8)
			return 81;
		else //if(onePhoneNum == 9)
			return 84;
	}
	
	public boolean getFlag() {
		return flag;
	}
}
