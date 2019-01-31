package Task1;
import java.util.Scanner;

public class Complex implements Cloneable {
	private double realPart;
	private double imaginaryPart;
	
	public Complex(double a, double b){
		realPart = a;
		imaginaryPart = b;
	}

	public Complex(double a){
		realPart = a;
		imaginaryPart = 0;
	}
	
	public Complex(){
		realPart = 0;
		imaginaryPart = 0;
	}
	
	public String toString(double compNum, double imaginNum) {
		if(imaginNum == 0) {
			String result = Double.toString(compNum);
			return result;
		}else {
			return compNum + " + " + imaginNum + "i";
		}
	}
	
	public double getRealPart() {
		return this.realPart;
	}
	
	public double getImaginaryPart() {
		return this.imaginaryPart;
	}
	
	public void add(Complex com2) {
		double realResult = this.getRealPart() + com2.getRealPart();
		double imaginResult = this.getImaginaryPart() + com2.getImaginaryPart();
		
		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart())
				 + ") + (" + com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = "
				 + realResult + " + " + imaginResult + "i");
	}

	public void substract(Complex com2) {
		double realResult = this.getRealPart() - com2.getRealPart();
		double imaginResult = this.getImaginaryPart() - com2.getImaginaryPart();
		
		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart())
		 + ") - (" + com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = "
		 + realResult + " + " + imaginResult + "i");
	}
	
	public void multiply(Complex com2) {
		double realResult = this.getRealPart() * com2.getRealPart() - this.getImaginaryPart() * com2.getImaginaryPart();
		double imaginResult = this.getImaginaryPart() * com2.getRealPart() + this.getRealPart() * com2.getImaginaryPart();
		
		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart())
		 + ") * (" + com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = "
		 + realResult + " + " + imaginResult + "i");
	}
	
	public void divide(Complex com2) {
		double pow2Plus = Math.pow(com2.getRealPart(), 2) + Math.pow(com2.getImaginaryPart(), 2);
		double realResult = (this.getRealPart() * com2.getRealPart() + this.getImaginaryPart() * com2.getImaginaryPart())
				/ pow2Plus;
		double imaginResult = (this.getImaginaryPart() * com2.getRealPart() - this.getRealPart() * com2.getImaginaryPart())
				/ pow2Plus;
		
		System.out.println("(" + this.toString(this.getRealPart(), this.getImaginaryPart())
		 + ") / (" + com2.toString(com2.getRealPart(), com2.getImaginaryPart()) + ") = "
		 + realResult + " + " + imaginResult + "i");
	}
	
	public void abs() {
		double result = Math.sqrt(Math.pow(this.getRealPart(), 2) + Math.pow(this.getImaginaryPart(), 2));
		System.out.println("|(" + this.toString(this.getRealPart(), this.getImaginaryPart())
		 + ")| = " + result);
	}
	
	

}
