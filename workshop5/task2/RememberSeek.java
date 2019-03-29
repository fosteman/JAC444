package com.senecacollege.workshop5.task2;

public class RememberSeek {
	private long seekNum;
	
	public RememberSeek() {
		this.seekNum = -1;
	}
	
	public RememberSeek(long seekNum) {
		this.seekNum = seekNum;
	}
	
	public long getSeekNum() {
		return seekNum;
	}
	
	public void setSeekNum(long seekNum) {
		this.seekNum = seekNum;
	}
}
