/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		// You fill this in //
	    int fs = line.indexOf(" ");
	    int ss = line.indexOf(" ",fs+1);
	    int ts = line.indexOf(" ",ss+1);
	    int fos = line.indexOf(" ",ts+1);
	    int fis = line.indexOf(" ",fos+1);
	    int sis = line.indexOf(" ",fis+1);
	    int ses = line.indexOf(" ",sis+1);
	    int es = line.indexOf(" ",ses+1);
	    int ns = line.indexOf(" ",es+1);
	    int tes = line.indexOf(" ",ns+1);
	    int els = line.indexOf(" ",tes+1);
	    
	    first = Integer.parseInt(line.substring(fs+1,ss));
	    second = Integer.parseInt(line.substring(ss+1,ts));
	    third = Integer.parseInt(line.substring(ts+1,fos));
	    fourth = Integer.parseInt(line.substring(fos+1,fis));
	    fifth =Integer.parseInt(line.substring(fis+1,sis));
	    sixth = Integer.parseInt(line.substring(sis+1,ses));
	    seventh = Integer.parseInt(line.substring(ses+1,es));
	    eighth = Integer.parseInt(line.substring(es+1,ns));
	    ninth = Integer.parseInt(line.substring(ns+1,tes));
	    tenth = Integer.parseInt(line.substring(tes+1,els));
	    eleventh =Integer.parseInt(line.substring(els+1));
	    
	    word = line.substring(0,fs);
	}
	

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return word;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		switch(decade) {
		case 1:
			return first;
		case 2:
			return second;
		case 3:
			return third;
		case 4:
			return fourth;
		case 5:
			return fifth;
		case 6:
			return sixth;
		case 7:
			return seventh;
		case 8:
			return eighth;
		case 9:
			return ninth;
		case 10:
			return tenth;
		case 11:
			return eleventh;
		}
		return 0;
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String g ="[" ;
		String p = "]" ;
		String k= first +" "+ second+" "+ third+" "+ fourth+" "+ fifth+" "+ sixth+" "+ seventh+" "+eighth+" "+ ninth+" "+ tenth+" "+eleventh+"" ; 
		return word+g+k+p ;
	}
	// instance variable
	private int first ; int second ; int third ; int fourth ; int fifth ; int sixth; int seventh; int eighth; int ninth; int tenth; int eleventh;
	private String word;
}

