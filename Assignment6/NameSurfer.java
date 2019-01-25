/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the top of the window.
 */
	public void init() {
    // add different interactive interface
		name = new JLabel("Name");
		entry = new JTextField(20);
		graph = new JButton("Graph");
		clear = new JButton("Clear");
		em = new NameSurferDataBase("names-data.txt");
		add(name,SOUTH);
		add(entry,SOUTH);
		add(graph,SOUTH);
		add(clear,SOUTH);
	    display = new NameSurferGraph();
	    add(display);
	    addActionListeners();
	    entry.addActionListener(this);
	    
		
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		if(e.getSource()==entry || e.getSource()==graph) {
			NameSurferEntry p = em.findEntry(entry.getText());
	//		println("Graph:"+ p.toString()) ; 
			display.addEntry(p);
			display.update();
		}
	    if(e.getSource()==clear) {
	//    	println("Clear ALl");
	    	display.clear();	
	    	display.update();
		}
		
	}
	// instance variables
	private JButton graph;
	private JLabel name;
	private JButton clear;
	private JTextField entry;
	private NameSurferDataBase em;
	private NameSurferGraph display= new NameSurferGraph();
	
}
