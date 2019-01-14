/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.Iterator;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		storecategory = new int[nPlayers][N_CATEGORIES];
		 totalscore = new int[nPlayers];
		 lowerscore = new int[nPlayers];
		 upperscore = new int[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		//making a layout of the game 
        for(int i=1; i<= N_SCORING_CATEGORIES;i++) {
        	for(int j=1;j<=nPlayers;j++) {
        		DiceSetup(j);
        		playerDiceCombination();
        		playerDiceCombination();
        		selectCategory(j);
        	}
        }
		updatewinner();

	}
	// first step in setting up the dice 
	private void DiceSetup(int j) {
		display.printMessage( playerNames[j-1]+"\'s"+" "+"turn! Click \"Roll Dice\" button to roll the Dice.");
		display.waitForPlayerToClickRoll(j);
		displayDice();
	}
	// providing the option for the player to make his final decision on the arrangement of the dice(re-rolling the dice)
	private void playerDiceCombination() {
		display.printMessage("Select the dice you wish to reroll and click \"Roll Again\" ");
		display.waitForPlayerToSelectDice();
		if(display.isDieSelected(0)) {
			dice[0] = rgen.nextInt(1,6);
		}
	    if(display.isDieSelected(1)) {
			dice[1] = rgen.nextInt(1,6);
		}
	    if(display.isDieSelected(2)) {
			dice[2] = rgen.nextInt(1,6);
		}
	    if(display.isDieSelected(3)) {
			dice[3] = rgen.nextInt(1,6);
		}
	    if(display.isDieSelected(4)) {
			dice[4] = rgen.nextInt(1,6);
		}
		display.displayDice(dice);
	}
	// Allowing player to select the Dice Category
	// will update the score board
	private void selectCategory(int u) {                                // u is the player selected	
             while (true) {               
            	 display.printMessage("Select a category for this roll.");
                  category = display.waitForPlayerToSelectCategory();
               if ((storecategory[u-1][category-1])==0) {               	 
                	 calculatecategory(u);    
                	 break;
                }
               display.printMessage("This Category is not Empty.Please Choose another Category!");
             }
	}
	private void calculatecategory(int u) {
		       storecategory[u-1][category-1]=1;
		       int score = getscore(category) ;
                 if(category <UPPER_SCORE) {
                	 display.updateScorecard(category, u, score);
                   	 upperscore[u-1] += score;
                	 display.updateScorecard(UPPER_SCORE, u, upperscore[u-1]);
                 }
                 if(category > UPPER_SCORE) {
                	 display.updateScorecard(category,u,score);
                	 lowerscore[u-1] +=  score;
                	 display.updateScorecard(LOWER_SCORE,u,lowerscore[u-1]);        
                 }
                 totalscore[u-1] = upperscore[u-1] + lowerscore[u-1];
                 if( upperscore[u-1]>= bonuslimit) {
                	 display.updateScorecard(UPPER_BONUS, u, bonusadded);
                	 totalscore[u-1] += bonusadded;
                 }
                 display.updateScorecard(TOTAL,u,totalscore[u-1]);
                 
               
             
      }
	
		//Assigning the value of score for different cases
		private int getscore(int number) {
			int one = 0;int two = 0;int three = 0; int four = 0;int five = 0; int six =0;	
			int count1 =0;int count2 =0;int count3 =0;int count4 =0;int count5 =0;int count6 =0;
			// finding the repetition of number in dice
			for(int w=0;w<N_DICE;w++) {			
				if(dice[w]==1) {
					one =one+ 1;
					count1 = count1+1;
				}
				if(dice[w]==2) {
					two = two + 2;
					count2 = count2+1;
				}
				if(dice[w]==3) {
					three = three + 3;
					count3 = count3+1;
				}
				if(dice[w]==4) {
					four = four+4;
					count4 = count4+1;
				}
				if(dice[w]==5) {
					five = five+5;
					count5 = count5+1;
				}
				if(dice[w]==6) {
					six = six+6;
					count6 = count6+1;
				}
			}
			// adding all the values shown in the dice
			 p = 0;
			for(int i=0;i<N_DICE;i++) {
				p = p + dice[i];              // p is the total score of the dice
			}
			//assigning the score to each category and checking the validity of the dice configuration
			int score = 0;
			switch(number) {
			case 1:
				score = one;
				break;
			case 2:
				score = two;
				break;
			case 3:
				score = three;
				break;
			case 4:
				score = four;
				break;
			case 5:
				score = five;
				break;
			case 6:
				score = six;
				break;
			case 9:
				if(count1==3||count2==3||count3==3||count4==3||count5==3||count6==3) {
					score = p;
				}
				break;
			case 10:
				if(count1==4||count2==4||count3==4||count4==4||count5==4||count6==4) {
				score = p;
				}
				break;
			case 11:
				if(count1==3||count2==3||count3==3||count4==3||count5==3||count6==3 && count1==2||count2==2||count3==2||count4==2||count5==2||count6==2)
				score = 25;
				break;
			case 12:
				if(count1==1&&count2==1&&count3==1&&count4==1) {
				score = 30;
				}else if(count2==1&&count3==1&&count4==1&&count5==1) {
					score = 30;
				}else if(count6==1&&count3==1&&count4==1&&count5==1) {
					score=30;
				}
				break;
			case 13:
				if(count1==1&&count2==1&&count3==1&&count4==1&&count5==1) {
				score = 40;
				}else if(count2==1&&count3==1&&count4==1&&count5==1&&count6==1) {
					score = 40;	
				}
				break;
			case 14:
				if(count1==5||count2==5||count3==5||count4==5||count5==5||count6==5) {
				score = 50;
			    }
				break;
			case 15:
				score = p;
				break;				
			}
			return score;
		}
		private String player;
		private int winningscore;
		// finding the winner of the game
  private void updatewinner() {
	  for(int i=1;i<nPlayers;i++) {
		   winningscore =0;
		  if(totalscore[i-1]>winningscore) {             // checking the highest score obtained
			  winningscore = totalscore[i-1];
			  player = playerNames[i-1];
		  }
	  }
	  display.printMessage("Congratulation!"+" "+player+" "+"has won the game with the total score of"+" "+winningscore);
  }

	// The displayDice method will provide the value of dice after rolling all the dices
	private void displayDice() {
		for(int i=0;i<N_DICE;i++) {
			dice[i]= rgen.nextInt(1,6);
		}
		display.displayDice(dice);
	}
	// setting up the dice for the first time		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
    private int[] dice = new int[N_DICE];
    private int p; // adding all the numbers shown by the 5 dices
    private int[] upperscore ;
    private int[] lowerscore;
    private int[] totalscore;
    private int[][] storecategory;        // to make sure that one category is not selected more than once
    private int bonuslimit = 63;
    private int bonusadded = 35;
    private int category;
    
}
