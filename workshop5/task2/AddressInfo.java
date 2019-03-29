package com.senecacollege.workshop5.task2;
import java.io.RandomAccessFile;
import java.io.IOException;

public class AddressInfo {
	String firstName;
	String lastName;
	String city;
	String province;
	String postalCode;
	
	void read(RandomAccessFile raf) throws IOException{
		char[] temp = new char[15];
		for(int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		firstName = new String(temp);
		
		temp = new char[15];
		for(int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		lastName = new String(temp);
		
		temp = new char[15];
		for(int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		city = new String(temp);
		
		temp = new char[30];
		for(int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		province = new String(temp);
		
		temp = new char[15];
		for(int i = 0; i < temp.length; i++)
			temp[i] = raf.readChar();
		postalCode = new String(temp);
		
		//System.out.println("first name: " + firstName + " lastName: " + lastName + " city: " + city + " province: " + province + " postalCode: " + postalCode);
		
	}
	
	void write(RandomAccessFile raf) throws IOException{
		StringBuffer sb;
		if(firstName != null)
			sb = new StringBuffer(firstName);
		else
			sb = new StringBuffer();
		
		sb.setLength(15);
		raf.writeChars(sb.toString());
		
		if(lastName != null)
			sb = new StringBuffer(lastName);
		else
			sb = new StringBuffer();
		
		sb.setLength(15);
		raf.writeChars(sb.toString());
		
		if(city != null)
			sb = new StringBuffer(city);
		else
			sb = new StringBuffer();
		
		sb.setLength(15);
		raf.writeChars(sb.toString());
			
		if(province != null)
			sb = new StringBuffer(province);
		else
			sb = new StringBuffer();
		
		sb.setLength(30);
		raf.writeChars(sb.toString());
			
		if(postalCode != null)	
			sb = new StringBuffer(postalCode);
		else
			sb = new StringBuffer();
		
		sb.setLength(15);
		raf.writeChars(sb.toString());
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
