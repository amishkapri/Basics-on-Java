/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Hangman extends ConsoleProgram {
  // instance variables
	private HangmanLexicon u = new HangmanLexicon() ;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private int y = u.getWordCount() ;
    private String r;
   	int a = rgen.nextInt(y);
	String c = u.getWord(a); // getting a random word from the hangmanlexicon class
	private  int NOG = 8; // Number of guess allowed
	private int TGM = 0; // total guess made to get right answer
			// finding the dashed line that should be present initially
	String p ="----------------------------------------------".substring(0,c.length()); 
	private HangmanCanvas canvas;
	public void init() {    
		canvas = new HangmanCanvas();    
		add(canvas);
		}
    public void run() {
		println("Welcome to Hangman!");
		canvas.reset();
		// using loop and half
		while(true) {
			String k = p; //making a copy of the string p because it an object			
			println("The Word now looks like this:"+k);
			println("You have"+" "+ NOG +" " +"guess left.");
			String b = readLine("Your Guess:" );
			 r = b.toUpperCase(); // converting the user given word into Upper Case
			if(b.length()==1) {         // providing the condition to run the for loop and the user must input only one word at a time				
				for(int i=0;i<c.length();i++) {        // checking whether if the given word is contained in the original word
					String g = Character.toString(c.charAt(i));
					if(r.equals(g)) {                 // if the user given letter is contained then replacing it 
						 p = p.substring(0,i)+r+p.substring(i+1);	
						 TGM = TGM + 1 ;
					}
			    }
			}else {                         // if user enters more than one letter the following message is poped up
				println("Enter one word at one time.");
			}
			canvas.displayWord(p,NOG);
				if(p.contains(r)) {      // if the replaced string contains the user given letter we manipulate the Number of Guess(NOG)
		                 NOG = NOG ;     // using this only to run the loop		                 					
			    }else {               // if it doesn't contains the user provided input we will reduce NOG by 1
			    	println("There is no"+" "+ r +" "+"in the word.");
			    	NOG = NOG - 1 ;
			    	canvas.noteIncorrectGuess(r.charAt(0),NOG);
			    }			
			if(NOG==0) {          // providing the condition when the NOG is zero. and then breaking the loop
				println("The Word now looks like this:"+k);
				println("You Loose!");
				println("The Correct word was "+c);
				break;
			}
			if(p.equals(c)) {      // providing the condition to win
				println("The Word now looks like this:"+c);
				println("Congratulation!You Won!");
				break;
			}			
			
		}
		
	}

}
