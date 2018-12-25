/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0 ;
	public void run() {
		println("This Programs finds the smallest and largest numbers.");
		double max = -1 * Double.MAX_VALUE;
		double min = Double.MAX_VALUE;
		int count = 0;
	    while(true) {
	    	double val = readDouble("");
	    	if(val==SENTINEL) {
	    		break;
	    	}
	    	if(val>max) {
	    		max = val;
	    	}	    	
	    	if(val<min) {
	    		min = val;
	    	}
	    	count++;
	    }
	    if (count != 0) {
		    println("Greatest = "+max);
		    println("Smallest = "+min);
	    }else {
	    	println("No value present");
	    }
	}		
	}
