//***********************************************************
// Name: Yongsung Park
// Title: Assignment6.java
// Description: Methods, implementing classes
// Time spent: 1 hour
// Date: 03/30/2020
//**********************************************************
package git_CSE110_assignments;



import java.util.*;
public class Assignment6 {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		int num;
		String choice;
		char command;
		 SimpleStat stat;
		do
		{
		 stat = new SimpleStat();
		 
		 System.out.println("Please enter the set of non-negative integers:\r\n" + 
		 		"values you want to average, enter -1 after the last value. ");
		boolean control;
		do {
			 num = read.nextInt();
		control = stat.addNumber(num);
			 
		} while (control); // close do
		
		System.out.println(stat.toString());

		System.out.println("Do you want to try a new set of integers; "
				+ "type Y/y to continue or N/n to quit");
		choice = read.next();
		command = choice.charAt(0);
		
		} while (command == 'y' || command == 'Y');
		
		System.out.println("Good Bye!");
		
		read.close();

	}

}
