/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		// You fill in the rest //
		 record = new ArrayList<NameSurferEntry>();		
	}
	
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		// You fill this in //
		record.clear();
	}
	
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
		record.add(entry);
	}
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		// You fill this in //
		removeAll();
		 k = getWidth()/NDECADES ;
		for(int i=0;i<NDECADES;i++) {
			GLine grid = new GLine(k*i,0,k*i,getHeight());
			line.add(grid);
		}
		 horup = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		 hordown = new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE);;
		for(int i=0;i<NDECADES;i++) {
			int y = 1900+(i*10);
			 GLabel year=new GLabel(Integer.toString(y),(i*k)+5,getHeight()-GRAPH_MARGIN_SIZE+15);
			label.add(year);
		}
		add(horup);
		add(hordown);
		for(int i=0;i<line.size();i++) {
			add(line.get(i));
		}
		for(int i=0;i<label.size();i++) {
			add(label.get(i));
		}
		
		if(record.size()>=0) {
		double p = (getHeight()-(2*GRAPH_MARGIN_SIZE))/1000 ;  // calibration for vertical space for one rank
		for(int i=0;i<record.size();i++) {
			for(int j=0;j<=NDECADES-1;j++) {
				newentry =record.get(i);
				double x1 = k*j;
				double y1 = GRAPH_MARGIN_SIZE+(p*(newentry.getRank(j+1)));
				double x2= k*(j+1);
				double y2 = GRAPH_MARGIN_SIZE+(p*(newentry.getRank(j+2)));
				GLine join = new GLine(x1,y1,x2,y2);
				add(join);
				String h= newentry.getName();
				String o = Integer.toString(record.get(i).getRank(j));
				GLabel name = new GLabel(h+" "+o,x1+10,y1);
				add(name);
			}
		}
		}		
		
	}
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
//	private GLine line;
//	private GLabel label;
	private double k; //distance from leftmost corner
	private GLine horup;
	private GLine hordown;
	private ArrayList<GLine> line = new ArrayList<GLine>();
	private ArrayList<GLabel> label= new ArrayList<GLabel>();
	private ArrayList<NameSurferEntry> record;
	private NameSurferEntry newentry;
}
