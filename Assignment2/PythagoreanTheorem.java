/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter Values to Compute the Pythagorean Theorem.");
		double k = readDouble("a:");
		double p = readDouble("b:");
		double l = (k*k) + (p*p) ;
		double m = Math.sqrt(l);
		println("c="+m);
	}
}
