/**********************************************

Workshop #7

Course:JAC444 - Winter Semester

Last Name: Lee

First Name: Hyunji

ID: 145732178

Section: SCC

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature Hyunji Lee

Date: 29/3/2019

**********************************************/

package com.senecacollege.workshop7.task1;

import java.util.*;

public class StoreNum {
	int addAsr;
	int subAsr;
	int mulAsr;
	double divAsr;
	int correctNum;
	int wrongNum;
	
	public StoreNum(int add, int sub, int mul, double div) {
		this.addAsr = add;
		this.subAsr = sub;
		this.mulAsr = mul;
		this.divAsr = div;
	}
	
	public void setCorrectNum(int correct) {
		this.correctNum = correct;
	}
	
	public int getCorrectNum() {
		return this.correctNum;
	}
	
	public void setWrongNum(int wrong) {
		this.wrongNum = wrong;
	}
	
	public int getWrongNum() {
		return this.wrongNum;
	}
	
	@Override
	public String toString() {
		return "Answer Collection [Add answer=" + this.addAsr + ", Sub answer=" 
				+ this.addAsr + ", Mul answer=" + this.mulAsr + ", Div answer=" 
				+ this.divAsr + ", Correct=" + this.correctNum + ", Wrong=" 
				+ this.wrongNum;
	}
}
