/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter a Number:");
		int b = 0;
		int c = 0;
		while(n>=1) {
			if((n%2)==0 & n!=1) {
			int	a =n;
			n = n/2;
			b = b+1;
			println(a+" "+"is even, so I take half:"+n);
			} 
			if ((n%2)!=0 & n!=1) {
				int p =n;
				n = (3*n)+1;
				c=c+1;
				println(p+" " +"is odd,so I make 3n+1:"+n);	
			}
			if(n==1) {
				int w = b+c;
				println("The process took"+" "+w+" "+"to reach 1.");
				break;
			}
		}
		
	}
}

