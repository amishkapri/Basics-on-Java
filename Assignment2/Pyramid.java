/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
// import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
/* 

*/
	public void run() {		
		int h = BRICK_HEIGHT ;   // giving variable to the height of brick
		double b = getWidth() / BRICK_WIDTH ;  // finding the total number of bricks that can be kept in the baseline
		double k = (b-BRICKS_IN_BASE)/ 2 ;   // finding the point to put the first brick in the baseline
	    double x = k * BRICK_WIDTH ;        // finding the x-co-ordinate
	    double y = getHeight()- h ;        // finding the y-co-ordinate
	    double m = (BRICK_WIDTH)/2 ;      // finding the midpoint of the brick
	    for(int j=0; j < (BRICKS_IN_BASE); j++) {   // this for loop is to move across the vertical line
            double n = BRICKS_IN_BASE - j ;
            for(int i=0;i<n;i++) { // thid for loop is to move across the horizontal path
            	double p = x + (m *j) + (BRICK_WIDTH * i);   	// finding a common technique to change the x co-ordinate 
                double l = y - (h*j);                          // finding a common technique to change the y-co-ordinate
            	GRect box = new GRect(p,l,BRICK_WIDTH,BRICK_HEIGHT);   
            	add(box);
            }
	    }
	}
}

