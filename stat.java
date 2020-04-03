import java.text.DecimalFormat;

//***********************************************************
//Name: Yongsung Park
//Title: SimpleStat.java
//Description: Methods, implementing classes
//Time spent: 1 hour
//Date: 03/30/2020
//**********************************************************



public class stat {
	private double largest, sum, count;
	
	public stat() {
		largest = 0; sum = 0; count = 0;
	}
	
	public boolean addNumber(int num) {
		boolean add = false;
		
		/*If num is valid, add it to the sum and increment the count, and find
		out if it is the new largest by calling the private method
		isNewLargest. Once a number has been received and added to
		running total, it is not kept.*/
		if ( isNewLargest(num)) {
			largest = num;
		}
		if (num != -1) {
			sum += num;
			add = true;
			count++;
		} else {add = false;}
		
		return add;
	}
	
	private boolean isNewLargest(int num) {
		boolean isit = false;
		if ( num > largest) {
			isit = true;
		}
		return isit;
	}
	
	public double getLargest() {
		return largest;
	}
	
	public double getCount() {
		return count;
	}
	
	public String calcAverage() {
		double av = sum / count;
		DecimalFormat ff = new DecimalFormat("0.000");
		return ff.format(av);
	}
	
	public String toString() {
		String output = "";
		if (count!=0) {
		output = "You entered " + count + " values.\nThe largest value was " + largest +
		"\nThe average was " + calcAverage() ;
		} else {
		output = "You entered 0 values.\nThe largest value was zero because"
				+ " no values were entered.";
		}
		return output;
	}
}
