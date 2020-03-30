

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class RPS_test {
public static void main(String[] args) {
	String P1, P2;
	final int throwTimes = 10000;	// play times
	int run = 0;
	int p1Throw, p2Throw;
	int p1Wins = 0, p2Wins = 0;
	int winner=0;
	double p1Time, p2Time;
	double winRate; 
	
	NumberFormat perc = DecimalFormat.getPercentInstance();	// percent formatter
	
	
	while (run != -1)	// -1 = quit, runs until user quits
	{
		dispMenu();
	
	Scanner read = new Scanner(System.in);
	
	String pQ = read.next();
	pQ= pQ.toUpperCase();
	
	switch (pQ){	// user input operation switch
	case "Y" : 
		System.out.println("Choose the player names. Type in "
				+ "\nthe player names one by one. Player 1:\n");
		read.next();
		P1 = read.nextLine();
		System.out.println("Okay! Now Player 2:\n");
		P2 = read.nextLine();
		System.out.println("========================="
				+ "\nPlayer 1: " + P1 + "\nPlayer 2: " + P2
				+ "\n=========================");
		
		Timer timer = new Timer("timer");
		
		for (int i=1; i<=throwTimes; i++) {
			do {
			timer.start();		// use the separate timer class
			p1Throw = gen();
			timer.end();
			p1Time = timer.getTime();
			
			timer.start();
			p2Throw = gen();
			timer.end();
			p2Time = timer.getTime();
			winner = judge(p1Throw, p2Throw);
			
			} 
			while (winner==0 || fairTest(p1Time, p2Time, 0.05)==false 
			);  // close do loop, prevent tie, keeps fair
		
			if (winner == 1) {
				p1Wins++;
			} else { p2Wins++; }	

		} // close for loop
		
		System.out.println("\n\nThe players has completed their match!"
				+ "\nThe results are as following: \n\n"
				+ "Out of " + throwTimes + " plays:\n"
				+ P1 + " won " + p1Wins + " times.\n"
				+ P2 + " won " + p2Wins + " times.\n");
		String bar = "=========================";
		if (p1Wins >= p2Wins) {
			winRate = winRate(p1Wins, throwTimes);
			System.out.println(P1 + " wins overall by: " + perc.format(winRate)+ "\n" + bar);
		} else {
			winRate = winRate(p2Wins, throwTimes);
			System.out.println(P2 + " wins overall by: " + perc.format(winRate)+"\n"+bar);
		}
		
		
		System.out.println("Would you like to play again?");
		pQ = read.next();


		break;
		
	case "Q" : System.exit(0); run = -1; break;
	default  : System.out.println("Your input was invalid, try again . . ."
			+ "*****************************");

				break;
		
	} // close switch
	read.close();
	} // close while loop

} // close main method
		
		
	




private static int gen() {	// random throw generator.
	int ranThrow;
	ranThrow = (int)(Math.random()*3 + 1);	// generates rand 1-3
											// 1=rock, 2=paper, 3=scissors
	 
	return ranThrow;
} // close Gen

private static boolean fairTest(double time1, double time2, double threshold) {	// fairness tester. 
	boolean fair;
	double limit = threshold;
	double p1 = time1, p2 = time2;
	
	
	if ((p1 - p2)< limit) {
		fair = true;
	}else { fair = false; }
	
	return fair;
} // close fairTest

private static int judge(int p1, int p2) {
	int winner=0;
	switch(p1) {
	
	case 1 : if (p2 == 1) {
				winner = 0;
			} else if (p2 == 2) {
				winner = 2;
			} else if (p2 == 3) {
				winner = 1;
			} break;
	case 2 : if (p2 == 1) {
				winner = 1;
			} else if (p2 == 2 ) {
				winner = 0;
			} else if (p2 == 3) {
				winner = 2;
			} break;
	case 3 : if (p2 == 1) {
				winner = 2;
			} else if (p2 == 2) {
				winner = 1;
			} else if (p2 == 3) {
				winner = 0;
			} break;	
	}// close switch
	
	return winner;
}

private static double winRate(double wintimes, double throwT) {
	double winRate = 0;
	winRate = ((double)(wintimes / throwT ));
	
	return winRate;
}
private static void dispMenu() {
	System.out.println("\nWelcome to the game!"
			+ "\nThis game will demonstrate the computer playing"
			+ "\nrock-paper-scissors with itself.\n"
			+"=============================================="
			+ "\nType Y to start running the program. Type Q to"
			+ "\nquit the program: \n");
}


}



