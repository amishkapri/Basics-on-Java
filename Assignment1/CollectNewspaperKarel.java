/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	public void run() {
		Movetothenewspaper();
		Pickitup();
		Returntoitsstartingpoint();
	  }
	
	private void Movetothenewspaper() {
	move();
	move();
	turnRight();
    move();
    turnLeft();
	}
	private void Pickitup() {
	move();	
	pickBeeper();
	move();
	turnAround();
	move();
	putBeeper(); 
	move();
	}
	private void Returntoitsstartingpoint() {
	move();
	move();
	turnRight();
	move();
	turnRight();
	}
}	