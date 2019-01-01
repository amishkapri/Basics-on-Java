/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  IMPORTANT NOTE:
  * ON SOME PLATFORMS THESE CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS
  * OF THE GRAPHICS CANVAS.  Use getWidth() and getHeight() to get the 
  * dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  IMPORTANT NOTE: ON SOME PLATFORMS THESE 
  * CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS OF THE GRAPHICS
  * CANVAS.  Use getWidth() and getHeight() to get the dimensions of
  * the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
private static final int gravity = 6;	
private  GRect rect2;
private int m;
private int p = 0;
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		addMouseListeners();
		setup();		
		playit();	
		addMouseListeners();
	}
	
    public void setup() {
    	// finding the space from left of the wall.
    	double k = (getWidth()-((BRICK_WIDTH*10)+((NBRICKS_PER_ROW - 1) * BRICK_SEP)))/2 ;
    	// finding the distance to move x-coordinate
    	double p = BRICK_WIDTH + BRICK_SEP ;
    	// finding the distance to move y coordinate
    	double q = BRICK_HEIGHT + BRICK_SEP;
    	// putting it all together in for loop
    	for(int i=0;i<NBRICK_ROWS;i++) {               // moves horizontally
    		for(int j=0;j<NBRICKS_PER_ROW;j++) {        // moves vertically
    			double x = k +(p*j);
    			double y = BRICK_Y_OFFSET+(q*i);
    			GRect rect1 = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
       			if((i==0) || (i==1)) {
    		    rect1.setFillColor(Color.RED); 
    		    rect1.setFilled(true);
    			}else if((i==2) || (i==3)) {
    				rect1.setFillColor(Color.ORANGE); 
        		    rect1.setFilled(true);
    			}else if((i==4)||(i==5)) {
    				rect1.setFillColor(Color.YELLOW); 
        		    rect1.setFilled(true);
    			}else if((i==6)||(i==7)) {
    				rect1.setFillColor(Color.GREEN); 
        		    rect1.setFilled(true);
    			}else if((i==8)||(i==9)) {
    				rect1.setFillColor(Color.CYAN); 
        		    rect1.setFilled(true);
    			}    			
        			add(rect1);
   			}
    		}
     	// creating the paddle 
    	 m = getHeight()-PADDLE_Y_OFFSET ; // finding the y-coordinate for the paddle
    	double n = (getWidth()/2)-(PADDLE_WIDTH)/2; // finding the x-cordinate so that to put the paddle in the center position.
        rect2 = new GRect(n,m,PADDLE_WIDTH,PADDLE_HEIGHT)	;
        rect2.setFillColor(Color.BLACK);
        rect2.setFilled(true);
        add(rect2);       
        }   
    public void mouseMoved(MouseEvent z)  {
    	rect2.setLocation(z.getX()-PADDLE_WIDTH/2,m);   
    }
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private double vx,vy;
    private GOval Ball;
    public void playit() {
    	//creating a ball   	
        double x1 = (getWidth()/2)-BALL_RADIUS;
        double y1 = (getHeight()/2)-BALL_RADIUS;
        Ball = new GOval(x1,y1,2*BALL_RADIUS,2*BALL_RADIUS);
        Ball.setFilled(true);
        add(Ball);
        //assigning the initial velocity to the ball
        vy = 3.0+gravity;
        vx = rgen.nextDouble(1.0,3.0);
        if (rgen.nextBoolean(0.5))  vx = -vx ;
        // making the ball move        
        while(Ball.getX()<=getWidth()) {
        	moveBall();
        	checkforcollison();
        	checkforboundary();
        	pause(50);
            }           
      }
    
        
      private void moveBall() {
    	  Ball.move(vx,vy);
      }
      private void checkforcollison() {
    	  if (getElementAt(Ball.getX(),Ball.getY())!= null) {
    		  collider = getElementAt(Ball.getX(),Ball.getY());
    		  if(collider == rect2) {
        		  vy = -vy ;
        	  }else {
        		  remove(collider);
        		  vy = -vy;
        	  }
    	  }else if (getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY())!= null) {
    		  collider =(getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()));
    		  if(collider == rect2) {
        		  vy = -vy ;
        	  }else {
        		  remove(collider);
        		  vy = -vy;
        	  }
    	  }else if (getElementAt(Ball.getX(),Ball.getY()+2*BALL_RADIUS)!= null) {
    		  collider = getElementAt(Ball.getX(),Ball.getY()+2*BALL_RADIUS);
    		  if(collider == rect2) {
        		  vy = -vy ;
        	  }else {
        		  remove(collider);
        		  vy = -vy;
        	  }
    	  }else if (getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()+2*BALL_RADIUS)!= null) {
    		  collider = getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()+2*BALL_RADIUS);
    		  if(collider == rect2) {
        		  vy = -vy ;
        	  }else {
        		  remove(collider);
        		  vy = -vy;
        	  }
    	  }
      }
      private GObject collider;
     // making sure that the ball returns once it touches the wall.	 
      private void checkforboundary() {
    	  if(Ball.getX()+2*BALL_RADIUS >= getWidth()) {
    		vx = -vx;
    	  } 
    	  if(Ball.getX()<=0) {
    		 vx=-vx;
    	  }
    	  if(Ball.getY()<=0) {
    		  vy=-vy;
    	  }
    	  if(Ball.getY()>= m) {
    		  vy = 0;
    		  vx =0;
    		  p +=1;
    	  }
      }
    
    
}
