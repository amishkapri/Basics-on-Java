/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		double x = getWidth()/2 ;
		double y = getHeight() / 2;
		GOval A = filledCircle(x, y, 72.0,Color.RED);
		GOval B = filledCircle(x,y,46.8,Color.WHITE);
		GOval C = filledCircle(x,y,21.6,Color.RED);
		add(A);
		add(B);
		add(C);
	}
/* Defining a common formula to draw the circle because we are going to make three circles
 * 	with same center but different radius. 
 */
	private GOval filledCircle(double p, double q, double r, Color color) { 
		GOval Circle = new GOval(p-r,q-r, 2*r, 2*r) ;
		Circle.setFilled(true);
		Circle.setColor(color);
		return(Circle);
	}
}
