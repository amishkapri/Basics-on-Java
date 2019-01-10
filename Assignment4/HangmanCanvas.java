/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		GLine scaf = new GLine(dside,dtop,dside,dtop+SCAFFOLD_HEIGHT);
		add(scaf);
		GLine beam = new GLine(dside,dtop,dside+BEAM_LENGTH,dtop);
		add(beam);
		GLine rope = new GLine(dside+BEAM_LENGTH,dtop,dside+BEAM_LENGTH,dtop+ROPE_LENGTH);
		add(rope);
	}
private GLabel display;
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word,int k) {
		if(display != null) {
			remove(display);
		}
	    display = new GLabel(word,dside+k,420);	
	    display.sendForward();
	    display.setFont("TIMES_ROMAN-20");
	    getElementAt(dside+k-1,420);
		add(display);
	}
    private double dtop = Height/2 - SCAFFOLD_HEIGHT/2 ;
    private double dside = Width/2 - BEAM_LENGTH ;
/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
   private int n = 8;
	public void noteIncorrectGuess(char letter,int n) {		
		while(true) {
			if(n==7) {
				GOval head = new GOval(dside+BEAM_LENGTH-HEAD_RADIUS,dtop+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS);
				add(head);
				addstring(letter,n);
				break;
			}else if(n==6) {
	GLine body = new GLine(dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS,dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
				add(body);
				addstring(letter,n);
				break;
			}else if(n==5) {
	GLine leftarm = new GLine(dside+BEAM_LENGTH-UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
	add(leftarm);
	GLine leftarmline = new GLine(dside+BEAM_LENGTH-UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,dside+BEAM_LENGTH-UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	add(leftarmline);
	addstring(letter,n);
	break;
			}else if(n==4) {
	GLine rightarm = new GLine(dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,dside+BEAM_LENGTH+UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		add(rightarm);
	GLine rightarmline = new GLine(dside+BEAM_LENGTH+UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,dside+BEAM_LENGTH+UPPER_ARM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	add(rightarmline);
	addstring(letter,n);
		break;
			}else if(n==3) {
	GLine leftleg = new GLine(dside+BEAM_LENGTH-HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
				add(leftleg);
				
	GLine leftlegline = new GLine(dside+BEAM_LENGTH-HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,dside+BEAM_LENGTH-HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				add(leftlegline);
				addstring(letter,n);
				break;
			}else if(n==2) {
	GLine rightleg = new GLine(dside+BEAM_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,dside+BEAM_LENGTH+HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
				add(rightleg);
	GLine rightlegline = new GLine(dside+BEAM_LENGTH+HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,dside+BEAM_LENGTH+HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				add(rightlegline);
				addstring(letter,n);
				break;
			}else if(n==1) {
	GLine leftfoot = new GLine(dside+BEAM_LENGTH-HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,dside+BEAM_LENGTH-HIP_WIDTH-FOOT_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				add(leftfoot);
				addstring(letter,n);
				break;
			}else if(n==0) {
	GLine rightfoot = new GLine(dside+BEAM_LENGTH+HIP_WIDTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,dside+BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,dtop+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
			add(rightfoot);
			addstring(letter,n);
			break;
		}
			}
		n = n+1;
	}
	private GLabel addstring(char a,int n) {
		String p = "" ;
		String k = p +""+ Character.toString(a);
		GLabel word = new GLabel(k,dside+9*n,450);
		add(word);
		return word ;
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
    private static final int Width = 400;
    private static final int Height = 450;
}
