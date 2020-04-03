/*-------------------------------------------------------------------------
// AUTHOR: Yongsung Park
// FILENAME: Lab9.java
// SPECIFICATION: Arrays...
// FOR: CSE 110- Lab #9
// TIME SPENT: 1 hour 
//----------------------------------------------------------------------*/

import java.util.Scanner;

public class Lab9
{
    public static void main(String[] args)
    {
        int arrSize, swap;
        Scanner read = new Scanner(System.in);
 
        System.out.println("How many elements are in the array?");
        arrSize = read.nextInt();
        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++)
        {        
        	System.out.println("Enter next element of the array");
        	arr[i] = read.nextInt();
        }

        for (int i = 0; i < arrSize; i++)
        {
            for (int j = i + 1; j < arrSize; j++)
            {
            	if (arr[i] >= arr[j]) {
            		swap = arr[i];
            		arr[i] = arr[j];
            		arr[j] = swap;
            	} //close if
            } // close for 2
        } // close for 1

        System.out.println("The array after sorting");

        for (int i = 0; i < arrSize; i++)
        {
        	System.out.print(arr[i]);
        	if(i<arrSize-1) { System.out.print(", ");}
        	
        }
        	System.out.println();
        

        int offset = -1;
        
        // In this for loop, we move the element at i + 1 to the position i
        for (int i = 0; i < arrSize + offset; i++)
        {
           arr[i] = arr[i+1];
        }

        	arr[arr.length-1] = 0;
        
        System.out.println("The array with the minimum removed");
        
        for (int i = 0; i < arrSize; i++)
        {
        	System.out.print(arr[i]);
            if(i<arrSize-1) { System.out.print(", ");}
        }

        	System.out.println();

        	
        System.out.println("Enter the value to search and remove:");

        int valRemove = read.nextInt();

        boolean isFound = false;
        int counter = 0;
        for (int i = 0; i < arrSize; i++)
        {
        	if (arr[i] == valRemove) {
        		isFound = true;
          		System.out.println("Search element found");
          		counter++;
        	} else { isFound = false; }
        	if (isFound) {
        		 for (int j = i; j < arrSize + offset; j++)
        	        {
        	           arr[j] = arr[j+1];
        	        }
        		 arr[arrSize-1] = 0;
        	}  
        } // close for loop i
        if (counter == 0) { System.out.println("No element found"); 
    	
        System.out.println("\nThe final array");
        
        for (int i = 0; i < arrSize; i++)
        {
           System.out.print(arr[i]);
           if(i<arrSize-1) { System.out.print(", ");}
        }
        System.out.println();
        
        read.close();
    }
    }
}