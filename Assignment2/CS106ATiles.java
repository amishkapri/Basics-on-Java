/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
// import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
// length of the rectangular box 
    private static final double TILE_WIDTH = 250 ;
// breadth of the rectangular box
    private static final double TILE_HEIGHT= 100 ;
// Assigning the constants    
	public void run() {
	    double a = getWidth()/2;
	    double b = getHeight()/2;
	    double c = TILE_SPACE/2 ;
	    double k = TILE_WIDTH/2 ;
	    double l = TILE_HEIGHT/2;
		// finding the center for the rectangles 
		// Center for 1st rectangle(northwest)
		double x1 = a-(c+TILE_WIDTH) ;
		double y1 = b-(c+TILE_HEIGHT);
	// Center for second rectangle(northeast)	
		double x2 = a + c ;
		double y2 = b - (c+ TILE_HEIGHT) ;
	// Center for third rectangle(southwest)
		double x3 = a -(c+TILE_WIDTH) ;
		double y3 = b+c ;
    // Center for fourth rectangle(southeast)
		double x4 = a+c ;
		double y4 = b+c ;
	// making the rectangles 
		GRect r1 = new GRect(x1,y1,TILE_WIDTH ,TILE_HEIGHT) ;
		add(r1);
		GRect r2 = new GRect(x2,y2,TILE_WIDTH ,TILE_HEIGHT) ;
        add(r2);
        GRect r3 = new GRect(x3,y3,TILE_WIDTH ,TILE_HEIGHT) ;
        add(r3);
        GRect r4 = new GRect(x4,y4,TILE_WIDTH ,TILE_HEIGHT) ;
	    add(r4); 
	 // defining some constant needed for the label(text)   
	    GLabel glabel = new GLabel("CS106A",x2,y2);
	   double p = glabel.getAscent()/2 ;
	   double q = glabel.getWidth()/2 ;
	 // finding the center for the text   
	 // first text center(northwest)
	   double x5 = a-(k+c+q) ;
	   double y5 = b-c-l+p ;
	 // second text center(northeast) 
	   double x6 = (a+c)+(k-q);
	   double y6 = b-c-l+p ;
	 // third text center(southwest)
	   double x7 = a-(k+c+q);
	   double y7 = b+c+l+p;
	 // fourth text center(southeast)
	   double x8 = (a+c)+(k-q);
	   double y8 = b+c+l+p ;
	 // fitting the text in the graphics windows 
	   GLabel label = new GLabel("CS106A",x5,y5);
	   add(label);
	   GLabel l2 = new GLabel("CS106A",x6,y6);
	   add(l2);
	   GLabel l3 = new GLabel("CS106A",x7,y7);
	   add(l3);
	   GLabel l4 = new GLabel("CS106A",x8,y8);
	   add(l4); 	    
	}	
}

