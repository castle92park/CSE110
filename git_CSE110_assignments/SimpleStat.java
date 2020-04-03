package git_CSE110_assignments;


import java.text.DecimalFormat;

public class SimpleStat {
	private int largest, sum, count;
	
	public SimpleStat() {
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
	
	public int getLargest() {
		return largest;
	}
	
	public int getCount() {
		return count;
	}
	
	public String calcAverage() {
		double av = (double)sum / count;
		DecimalFormat ff = new DecimalFormat("0.00");
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
