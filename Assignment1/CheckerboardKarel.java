/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	public void run() {
		putBeeper();
		putalternative();
		changerow();
	}
    private void putalternative() {
    	while (frontIsClear()) {
    		move();
    		if (noBeepersPresent()) {
    			if (frontIsClear()) {
    			turnAround();
    			move();
    			if (beepersPresent()) {
    				turnAround();
        			move();
        			move();
        			putBeeper(); 
    			}
    			}
    		} else {
    			move();
    		}
    	}
    }
    private void changerow()	{
      	while(frontIsBlocked()) {
      		if(leftIsClear()) {
      		if(beepersPresent()) {
      		turnLeft();
      		move();
      		turnLeft();
      		move();
      		putBeeper();
      		putalternative();
      		} else {
      			turnLeft();
          		move();
          		turnLeft();
          		putBeeper();
          		putalternative();
      		}
      	    } 
      	    
      	
    		if(rightIsClear()) {
    				if(beepersPresent()) {
    	    			turnRight();
    	    			move();
    	    			turnRight();
    	    			move();
    	    			putBeeper();
    	    			putalternative();
    	    		} else {
    	    			turnRight();
    	    			move();
    	    			turnRight();
    	    			putBeeper();
    	    			putalternative();
    	    		}
    			} else {
    				turnAround();
    			}
    		}    	    	    
}
}
